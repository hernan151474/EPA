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
import modelo.Alumno;
import modelo.AlumnoMateria;
import modelo.Materia;

/**
 *
 * @author acer
 */
public class CtrlAlumnoMateria {

    Connection conexion;

    public void crear(AlumnoMateria alm) {
        conexion = Conexion.conectar();
        List<Materia> lista = new ArrayList<>();
        CtrlMateria ctrlMateria = new CtrlMateria();
        lista = ctrlMateria.leerTodos(alm);
        PreparedStatement stmt;
        try {
            for (int i = 0; i < lista.size(); i++) {
                stmt = conexion.prepareStatement("INSERT INTO AlumnoMateria (alumno, materia, aula, cicloLectivo) VALUES (?,?,?,?)");
                stmt.setInt(1, alm.getAlumno().getIdAlumno());
                stmt.setInt(2, lista.get(i).getIdMateria());
                stmt.setInt(3, alm.getAula().getIdAula());
                stmt.setInt(4, alm.getCicloLectivo());

                stmt.execute();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public void modificar(Alumno alm) {
        conexion = Conexion.conectar();

        PreparedStatement stmt;
        try {
            stmt = conexion.prepareStatement("UPDATE  Alumno SET personal=?, estado = ? "
                    + "WHERE idAlumno = ?");
            stmt.setInt(1, alm.getPersonal().getIdPersonal());
            stmt.setInt(2, alm.getEstado().getIdEstado());
            stmt.setInt(3, alm.getIdAlumno());
            stmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public void eliminar(Alumno alm) {
        conexion = Conexion.conectar();

        PreparedStatement stmt;
        try {
            stmt = conexion.prepareStatement("DELETE FROM Alumno WHERE idAlumno = ?");
            stmt.setInt(1, alm.getIdAlumno());
            stmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public List<Materia> leerAulaMateria(AlumnoMateria mat) {
        conexion = Conexion.conectar();
        List<Materia> lista = new ArrayList();
        Materia materia = null;
        ResultSet rs;
        CtrlMateria ctrlMateria = new CtrlMateria();
//        int anio = obtenerNumero(mat.getCurso().getCurso());
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM AlumnoMateria "
                    + "WHERE aula = ? "
                    + "ORDER BY materia");
            stmt.setInt(1, mat.getAula().getIdAula());
            rs = stmt.executeQuery();

            while (rs.next()) {
                System.err.println(rs.getInt("aula"));
                materia = new Materia();
                materia = ctrlMateria.leer(rs.getInt("materia"));
                lista.add(materia);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }

    public List<Alumno> leerAulaAlumno(AlumnoMateria mat) {
        conexion = Conexion.conectar();
        List<Alumno> lista = new ArrayList();
        Alumno alumno = null;
        ResultSet rs;
        CtrlAlumno ctrlAlumno = new CtrlAlumno();
        try {
           
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM AlumnoMateria "
                    + "WHERE aula = ? AND materia = ?");
            stmt.setInt(1, mat.getAula().getIdAula());
            stmt.setInt(2, mat.getMateria().getIdMateria());
            rs = stmt.executeQuery();

            while (rs.next()) {
                alumno = new Alumno();
                alumno = ctrlAlumno.leer(rs.getInt("alumno"));
                lista.add(alumno);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }

    public AlumnoMateria leerAlumno(AlumnoMateria mat) {
        conexion = Conexion.conectar();
        AlumnoMateria alm = null;

        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM AlumnoMateria "
                    + "WHERE aula = ? AND materia = ? AND alumno = ?");
            stmt.setInt(1, mat.getAula().getIdAula());
            stmt.setInt(2, mat.getMateria().getIdMateria());
            stmt.setInt(3, mat.getAlumno().getIdAlumno());
            rs = stmt.executeQuery();

            while (rs.next()) {
                alm = new AlumnoMateria();
                alm.setIdAlumnoMateria(rs.getInt("idAlumnoMateria"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return alm;
    }

    public List<AlumnoMateria> leerAlumnoLibro(int idAlumno) {
        conexion = Conexion.conectar();
        AlumnoMateria alm = null;
        List<AlumnoMateria> lista = new ArrayList<>();
        ResultSet rs;
        CtrlMateria ctrlMateria = new CtrlMateria();
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM AlumnoMateria "
                    + "INNER JOIN Materia ON AlumnoMateria.materia = Materia.idMateria "
                    + "WHERE AlumnoMateria.alumno = ? ORDER BY Materia.año, Materia.materia");
            stmt.setInt(1, idAlumno);
            rs = stmt.executeQuery();

            while (rs.next()) {
                alm = new AlumnoMateria();
                alm.setMateria(ctrlMateria.leer(rs.getInt("AlumnoMateria.materia")));
                alm.setIdAlumnoMateria(rs.getInt("AlumnoMateria.idAlumnoMateria"));
                lista.add(alm);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }

    public boolean tieneMaterias(int idAlumno) {
        conexion = Conexion.conectar();
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT alumno FROM AlumnoMateria "
                    + "WHERE alumno = ?");
            stmt.setInt(1, idAlumno);
            rs = stmt.executeQuery();

            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return false;
    }
}
