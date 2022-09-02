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
import modelo.Usuario;

/**
 *
 * @author Leonel
 */
public class CtrlUsuario {
    Connection conexion;
    Usuario usuario = new Usuario();
    
    public void crearUsuario(Usuario user)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO Usuario (usuario,contraseña,nivel) VALUES (?,?,?)");
            stmt.setString(1, user.getUsuario());
            stmt.setString(2, user.getContraseña());
            stmt.setInt(3, user.getNivel());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
    }
    
    public void modificarUsuario(Usuario user)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Usuario SET usuario=?, contraseña=?, nivel=? WHERE idUsuario = ?");
            stmt.setString(1, user.getUsuario());
            stmt.setString(2, user.getContraseña());
            stmt.setInt(3, user.getNivel());
            stmt.setInt(4, user.getIdUsuario());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
    }
    
    public void eliminarUsuario(Usuario user)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("DELETE FROM Usuario WHERE idUsuario = ?");
            stmt.setInt(1, user.getIdUsuario());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
    }
    
    public Usuario leerUsuario(String nombreUsuario)
    {
        conexion = Conexion.conectar();
        ResultSet rs;
        usuario = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT idUsuario,contraseña,nivel FROM epa.usuario WHERE usuario = ?");
            stmt.setString(1, nombreUsuario);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setNivel(rs.getInt("nivel"));
            }     
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return usuario;
    }
    
    
    public Boolean ultimoAdmin()
    {
        Boolean verificar = false;
        conexion = Conexion.conectar();
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT COUNT(*) FROM Usuario WHERE nivel = 1");
            rs = stmt.executeQuery();
            if(rs.next())
            {
                if(rs.getInt("COUNT(*)") == 1)
                {
                    verificar = true;
                }else
                    verificar = false;
            }     
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return verificar;
    }
}
