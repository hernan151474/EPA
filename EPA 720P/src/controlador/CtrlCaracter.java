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
import modelo.Caracter;

/**
 *
 * @author Leonel
 */
public class CtrlCaracter {
    Connection conexion;
    Caracter caracter = new Caracter();
    public void crearCaracter(Caracter crtr)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO Caracter (caracter) VALUES (?)");
            stmt.setString(1, crtr.getCaracter());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void modificarCaracter(Caracter crtr)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Caracter SET caracter=? WHERE idCaracter = ?");
            stmt.setString(1, crtr.getCaracter());
            stmt.setInt(2, crtr.getIdCaracter());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void eliminarCaracter(Caracter crtr)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Caracter SET borrado = 1 WHERE idCaracter = ?");
            stmt.setInt(1, crtr.getIdCaracter());
            stmt.execute();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "No se puede eliminar el caracter","Error al eliminar",ERROR_MESSAGE);
        }
        Conexion.desconectar(conexion);
    }
    
    public Caracter leerCaracter(String nombreCaracter)
    {
        conexion = Conexion.conectar();
        ResultSet rs;
        caracter = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT idCaracter FROM Caracter WHERE caracter = ?");
            stmt.setString(1, nombreCaracter);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                caracter = new Caracter();
                caracter.setIdCaracter(rs.getInt("idCaracter"));
                caracter.setCaracter(nombreCaracter);
            }
                    
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return caracter;
    }
    
    public List<Caracter> leerTodos()
    {
        conexion = Conexion.conectar();
        List<Caracter> lista = new ArrayList();
        caracter = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT caracter FROM Caracter WHERE borrado = 0 ORDER BY caracter");
            rs = stmt.executeQuery();
            while(rs.next())
            {
                caracter = new Caracter();
                caracter.setCaracter(rs.getString("caracter"));
                lista.add(caracter);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }
}
