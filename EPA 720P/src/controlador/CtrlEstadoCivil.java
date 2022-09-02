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
import modelo.EstadoCivil;

/**
 *
 * @author Leonel
 */
public class CtrlEstadoCivil {
    Connection conexion;
    EstadoCivil estadoCivil = new EstadoCivil();
    public void crearEstadoCivil(EstadoCivil escv)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO EstadoCivil (estadoCivil) VALUES (?)");
            stmt.setString(1, escv.getEstadoCivil());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void modificarEstadoCivil(EstadoCivil escv)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE EstadoCivil SET estadoCivil=? WHERE idEstadoCivil = ?");
            stmt.setString(1, escv.getEstadoCivil());
            stmt.setInt(2, escv.getIdEstadoCivil());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void eliminarEstadoCivil(EstadoCivil escv)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE EstadoCivil SET borrado = 1 WHERE idEstadoCivil = ?");
            stmt.setInt(1, escv.getIdEstadoCivil());
            stmt.execute();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "No se puede eliminar el estado civil","Error al eliminar",ERROR_MESSAGE);
        }
        Conexion.desconectar(conexion);
    }
    
    public EstadoCivil leerEstadoCivil(String nombreEstadoCivil)
    {
        conexion = Conexion.conectar();
        ResultSet rs;
        estadoCivil = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT idEstadoCivil FROM EstadoCivil WHERE estadoCivil = ?");
            stmt.setString(1, nombreEstadoCivil);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                estadoCivil = new EstadoCivil();
                estadoCivil.setIdEstadoCivil(rs.getInt("idEstadoCivil"));
            }
                    
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return estadoCivil;
    }
    
    public EstadoCivil leerEstadoCivil(int idEstadoCivil)
    {
        conexion = Conexion.conectar();
        ResultSet rs;
        estadoCivil = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT estadoCivil FROM EstadoCivil WHERE idEstadoCivil = ?");
            stmt.setInt(1, idEstadoCivil);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                estadoCivil = new EstadoCivil();
                estadoCivil.setEstadoCivil(rs.getString("estadoCivil"));
            }
                    
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return estadoCivil;
    }
    
    public List<EstadoCivil> leerTodos()
    {
        conexion = Conexion.conectar();
        List<EstadoCivil> lista = new ArrayList();
        estadoCivil = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT idEstadoCivil, estadoCivil FROM EstadoCivil WHERE borrado = 0 ORDER BY estadoCivil");
            rs = stmt.executeQuery();
            while(rs.next())
            {
                estadoCivil = new EstadoCivil();
                estadoCivil.setIdEstadoCivil(rs.getInt("idEstadoCivil"));//Agregado mio(Kevin) para poder reutilizar este metodo
                estadoCivil.setEstadoCivil(rs.getString("estadoCivil"));
                lista.add(estadoCivil);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }
}
