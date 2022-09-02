/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import modelo.AlumnoMateria;
import modelo.Curso;
import modelo.Materia;

/**
 *
 * @author Leonel
 */
public class CtrlMateria {

    Connection conexion;
    CtrlPlanEstudio ctrlPlanEstudio = new CtrlPlanEstudio();
    CtrlCurso ctrlCurso = new CtrlCurso();
    Materia materia = new Materia();
    Curso curso = new Curso();

    public void crearMateria(Materia mate) {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO Materia (materia, planEstudio, año) VALUES (?,?,?)");
            stmt.setString(1, mate.getMateria());
            stmt.setInt(2, mate.getPlanEstudio().getIdPlanEstudio());
            stmt.setInt(3, mate.getAño());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public void modificarMateria(Materia mate) {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Materia SET materia=?, planEstudio=?, año=? WHERE idMateria = ?");
            stmt.setString(1, mate.getMateria());
            stmt.setInt(2, mate.getPlanEstudio().getIdPlanEstudio());
            stmt.setInt(3, mate.getAño());
            stmt.setInt(4, mate.getIdMateria());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public void eliminarMateria(Materia mate) {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Materia SET borrado = 1 WHERE idMateria = ?");
            stmt.setInt(1, mate.getIdMateria());
            stmt.execute();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "No se puede eliminar la materia", "Error al eliminar", ERROR_MESSAGE);
        }
        Conexion.desconectar(conexion);
    }

    public Materia leerMateria(String nombreMateria, int año) {
        conexion = Conexion.conectar();
        ResultSet rs;
        materia = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT idMateria FROM Materia WHERE materia = ? AND año = ?");
            stmt.setString(1, nombreMateria);
            stmt.setInt(2, año);
            rs = stmt.executeQuery();
            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setMateria(nombreMateria);
                materia.setAño(año);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return materia;
    }

    public List<Materia> leerAñosMateria(String nombreMateria) {
        conexion = Conexion.conectar();
        List<Materia> lista = new ArrayList();
        ResultSet rs;
        materia = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT año FROM Materia WHERE materia = ?");
            stmt.setString(1, nombreMateria);
            rs = stmt.executeQuery();
            while (rs.next()) {
                materia = new Materia();
                materia.setAño(rs.getInt("año"));
                lista.add(materia);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }

    public List<Materia> leerTodos() {
        conexion = Conexion.conectar();
        List<Materia> lista = new ArrayList();
        materia = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT materia,planEstudio,año FROM Materia WHERE borrado = 0 ORDER BY materia");
            rs = stmt.executeQuery();
            while (rs.next()) {
                materia = new Materia();
                materia.setMateria(rs.getString("materia"));
                materia.setPlanEstudio(ctrlPlanEstudio.leerPlanEstudio(rs.getInt("planEstudio")));
                materia.setAño(rs.getInt("año"));
                lista.add(materia);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }

    //------------------------------------------------------------------------
    public List<Materia> leerTodos(AlumnoMateria mat) {
        conexion = Conexion.conectar();
        List<Materia> lista = new ArrayList();
        materia = null;
        ResultSet rs;
        System.err.println(mat.getAula().getCurso().getCurso());
        int anio = obtenerNumero(mat.getAula().getCurso().getCurso());
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM Materia "
                    + "WHERE borrado = 0 AND planEstudio = ? AND año = ? "
                    + "ORDER BY materia");
            stmt.setInt(1, mat.getMateria().getPlanEstudio().getIdPlanEstudio());
            stmt.setInt(2, anio);
//            stmt.setInt(2, Integer.parseInt(mat.getAula().getCurso().getCurso()));
            rs = stmt.executeQuery();
            while (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setMateria(rs.getString("materia"));
//                materia.setPlanEstudio(ctrlPlanEstudio.leerPlanEstudio(rs.getInt("planEstudio")));
                materia.setAño(rs.getInt("año"));
                lista.add(materia);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }

    private int obtenerNumero(String texto) {
        String nuevoTexto = "";
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) != '°') {
                System.err.println(texto.charAt(i));
                nuevoTexto = nuevoTexto + texto.charAt(i);
            }
        }
        return Integer.valueOf(nuevoTexto);
    }

    public List<Materia> leerAnio(int anio) {
        conexion = Conexion.conectar();
        List<Materia> lista = new ArrayList();
        materia = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM Materia "
                    + "WHERE borrado = 0 AND año = ? "
                    + "ORDER BY materia");
            stmt.setInt(1, anio);
            rs = stmt.executeQuery();
            while (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setMateria(rs.getString("materia"));
//                materia.setPlanEstudio(ctrlPlanEstudio.leerPlanEstudio(rs.getInt("planEstudio")));
                materia.setAño(rs.getInt("año"));
                lista.add(materia);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }

    public Materia leer(int id) {
        conexion = Conexion.conectar();
        List<Materia> lista = new ArrayList();
        materia = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM Materia "
                    + "WHERE borrado = 0 AND idMateria = ? "
                    + "ORDER BY materia");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setMateria(rs.getString("materia"));
//                materia.setPlanEstudio(ctrlPlanEstudio.leerPlanEstudio(rs.getInt("planEstudio")));
                materia.setAño(rs.getInt("año"));
                lista.add(materia);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return materia;
    }
}
