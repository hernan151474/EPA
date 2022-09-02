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
import modelo.Titulo;

/**
 *
 * @author Leonel
 */
public class CtrlTitulo {
    Connection conexion;
    Titulo titulo = new Titulo();
    CtrlNivel ctrlNivel = new CtrlNivel();
    public void crearTitulo(Titulo ttlo)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO Titulo (titulo,nivel) VALUES (?,?)");
            stmt.setString(1, ttlo.getTitulo());
            stmt.setInt(2, ttlo.getNivel().getIdNivel());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void modificarTitulo(Titulo ttlo)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Titulo SET titulo=?,nivel=? WHERE idTitulo = ?");
            stmt.setString(1, ttlo.getTitulo());
            stmt.setInt(2, ttlo.getNivel().getIdNivel());
            stmt.setInt(3, ttlo.getIdTitulo());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void eliminarTitulo(Titulo ttlo)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Titulo SET borrado = 1 WHERE idTitulo = ?");
            stmt.setInt(1, ttlo.getIdTitulo());
            stmt.execute();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "No se puede eliminar el titulo","Error al eliminar",ERROR_MESSAGE);
        }
        Conexion.desconectar(conexion);
    }
    
    public Titulo leerTitulo(String nombreTitulo, int idNivel)
    {
        conexion = Conexion.conectar();
        ResultSet rs;
        titulo = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT idTitulo FROM Titulo WHERE titulo = ? AND nivel = ?");
            stmt.setString(1, nombreTitulo);
            stmt.setInt(2, idNivel);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                titulo = new Titulo();
                titulo.setIdTitulo(rs.getInt("idTitulo"));
            }
                    
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return titulo;
    }
    
    public Titulo leerTitulo(String nombreTitulo)
    {
        conexion = Conexion.conectar();
        ResultSet rs;
        titulo = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT idTitulo,nivel FROM Titulo WHERE titulo = ?");
            stmt.setString(1, nombreTitulo);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                titulo = new Titulo();
                titulo.setIdTitulo(rs.getInt("idTitulo"));
                titulo.setNivel(ctrlNivel.leerNivel(rs.getInt("nivel")));
            }
                    
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return titulo;
    }
    
    public List<Titulo> leerTodos()
    {
        conexion = Conexion.conectar();
        List<Titulo> lista = new ArrayList();
        titulo = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT titulo,nivel FROM Titulo WHERE borrado = 0 ORDER BY titulo");
            rs = stmt.executeQuery();
            while(rs.next())
            {
                titulo = new Titulo();
                titulo.setTitulo(rs.getString("titulo"));
                titulo.setNivel(ctrlNivel.leerNivel(rs.getInt("nivel")));
                lista.add(titulo);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }
}
