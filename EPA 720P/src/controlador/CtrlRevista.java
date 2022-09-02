/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import modelo.Revista;

/**
 *
 * @author Leonel
 */
public class CtrlRevista {
    Connection conexion;
    Revista revista = new Revista();
    public void crearRevista(Revista rvta)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO Revista (revista) VALUES (?)");
            stmt.setString(1, rvta.getRevista());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void modificarRevista(Revista rvta)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Revista SET revista=? WHERE idRevista = ?");
            stmt.setString(1, rvta.getRevista());
            stmt.setInt(2, rvta.getIdRevista());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void eliminarRevista(Revista rvta)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Revista SET borrado = 1 WHERE idRevista = ?");
            stmt.setInt(1, rvta.getIdRevista());
            stmt.execute();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "No se puede eliminar la revista","Error al eliminar",ERROR_MESSAGE);
        }
        Conexion.desconectar(conexion);
    }
    
    public Revista leerRevista(String nombreRevista)
    {
        conexion = Conexion.conectar();
        ResultSet rs;
        revista = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT idRevista FROM Revista WHERE revista = ?");
            stmt.setString(1, nombreRevista);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                revista = new Revista();
                revista.setIdRevista(rs.getInt("idRevista"));
            }   
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return revista;
    }
    
    public List<Revista> leerTodos()
    {
        conexion = Conexion.conectar();
        List<Revista> lista = new ArrayList();
        revista = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT revista FROM Revista WHERE borrado = 0 ORDER BY revista");
            rs = stmt.executeQuery();
            while(rs.next())
            {
                revista = new Revista();
                revista.setRevista(rs.getString("revista"));
                lista.add(revista);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }
}
