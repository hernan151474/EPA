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
import modelo.Nivel;

/**
 *
 * @author Leonel
 */
public class CtrlNivel {
    Connection conexion;
    Nivel nivel = new Nivel();
    
    public void crearNivel(Nivel nivl)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO Nivel (nivel) VALUES (?)");
            stmt.setString(1, nivl.getNivel());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void modificarNivel(Nivel nivl)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Nivel SET nivel=? WHERE idNivel = ?");
            stmt.setString(1, nivl.getNivel());
            stmt.setInt(2, nivl.getIdNivel());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void eliminarNivel(Nivel nivl)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Nivel SET borrado = 1 WHERE idNivel = ?");
            stmt.setInt(1, nivl.getIdNivel());
            stmt.execute();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "No se puede eliminar el nivel","Error al eliminar",ERROR_MESSAGE);
        }
        Conexion.desconectar(conexion);
    }
    
    public Nivel leerNivel(String nombreNivel)
    {
        conexion = Conexion.conectar();
        ResultSet rs;
        nivel = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT idNivel FROM Nivel WHERE nivel = ?");
            stmt.setString(1, nombreNivel);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                nivel = new Nivel();
                nivel.setIdNivel(rs.getInt("idNivel"));
            }
                    
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return nivel;
    }
    
    public Nivel leerNivel(int idNivel)
    {
        conexion = Conexion.conectar();
        ResultSet rs;
        nivel = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT nivel FROM Nivel WHERE idNivel = ?");
            stmt.setInt(1, idNivel);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                nivel = new Nivel();
                nivel.setNivel(rs.getString("nivel"));
            }
                    
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return nivel;
    }
    
    public List<Nivel> leerTodos()
    {
        conexion = Conexion.conectar();
        List<Nivel> lista = new ArrayList();
        nivel = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT nivel FROM Nivel WHERE borrado = 0 ORDER BY nivel");
            rs = stmt.executeQuery();
            while(rs.next())
            {
                nivel = new Nivel();
                nivel.setNivel(rs.getString("nivel"));
                lista.add(nivel);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }
}
