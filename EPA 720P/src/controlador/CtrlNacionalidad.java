/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.Nacionalidad;

/**
 *
 * @author Leonel
 */
public class CtrlNacionalidad {
    Connection conexion;
    Nacionalidad nacionalidad = new Nacionalidad();
    
    public Nacionalidad leerNacionalidad(int idNacionalidad)
    {
        conexion = Conexion.conectar();
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT nombre FROM Nacionalidad WHERE idNacional = ?");
            stmt.setInt(1, idNacionalidad);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                nacionalidad = new Nacionalidad();
                nacionalidad.setIdNacionalidad(idNacionalidad);
                nacionalidad.setNombre(rs.getString("nombre"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return nacionalidad;
    }
    
    public Nacionalidad leerNacionalidad(String nombreNacionalidad)
    {
        conexion = Conexion.conectar();
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT idNacionalidad FROM Nacionalidad WHERE nombre = ?");
            stmt.setString(1, nombreNacionalidad);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                nacionalidad = new Nacionalidad();
                nacionalidad.setIdNacionalidad(rs.getInt("idNacionalidad"));
                nacionalidad.setNombre(nombreNacionalidad);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return nacionalidad;
    }
}
