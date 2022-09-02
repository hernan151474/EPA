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
import modelo.Curso;

/**
 *
 * @author Leonel
 */
public class CtrlCurso {
    Connection conexion;
    Curso curso = new Curso();
    
    public void crearCurso(Curso curs)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO Curso (curso) VALUES (?)");
            stmt.setString(1, curs.getCurso());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void modificarCurso(Curso curs)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Curso SET curso=? WHERE idCurso = ?");
            stmt.setString(1, curs.getCurso());
            stmt.setInt(2, curs.getIdCurso());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void eliminarCurso(Curso curs)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Curso SET borrado = 1 WHERE idCurso = ?");
            stmt.setInt(1, curs.getIdCurso());
            stmt.execute();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "No se puede eliminar el curso","Error al eliminar",ERROR_MESSAGE);
        }
        Conexion.desconectar(conexion);
    }
    
    public Curso leerCurso(String nombreCurso)
    {
        conexion = Conexion.conectar();
        ResultSet rs;
        curso = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT idCurso FROM Curso WHERE curso = ?");
            stmt.setString(1, nombreCurso);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                curso = new Curso();
                curso.setIdCurso(rs.getInt("idCurso"));
                curso.setCurso(nombreCurso);
            }
                    
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return curso;
    }
    
    public Curso leerCurso(int idCurso)
    {
        conexion = Conexion.conectar();
        ResultSet rs;
        curso = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT curso FROM Curso WHERE idCurso = ?");
            stmt.setInt(1, idCurso);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                curso = new Curso();
                curso.setCurso(rs.getString("curso"));
            }
                    
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return curso;
    }
    
    public List<Curso> leerTodos()
    {
        conexion = Conexion.conectar();
        List<Curso> lista = new ArrayList();
        curso = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT curso FROM Curso WHERE borrado = 0 ORDER BY curso");
            rs = stmt.executeQuery();
            while(rs.next())
            {
                curso = new Curso();
                curso.setCurso(rs.getString("curso"));
                lista.add(curso);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }
}
