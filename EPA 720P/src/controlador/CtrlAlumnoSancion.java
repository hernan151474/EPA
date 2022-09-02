/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Alumno;
import modelo.AlumnoSancion;

/**
 *
 * @author acer
 */
public class CtrlAlumnoSancion {

    Connection conexion;

    public void crear(AlumnoSancion als) {
        conexion = Conexion.conectar();

        PreparedStatement stmt;

        java.sql.Date fechaCarga = new Date(als.getFecha().getTime());
        try {
            if (als.getObservacion().isEmpty()) {
                stmt = conexion.prepareStatement("INSERT INTO AlumnoSancion (alumno, sancion, cantidad, fecha) VALUES (?,?,?,?)");
                stmt.setInt(1, als.getAlumno().getIdAlumno());
                stmt.setInt(2, als.getSancion().getIdSancion());
                stmt.setInt(3, als.getCantidad());
                stmt.setDate(4, fechaCarga);
            } else {
                stmt = conexion.prepareStatement("INSERT INTO AlumnoSancion (alumno, sancion, cantidad, fecha, observacion) VALUES (?,?,?,?,?)");

                stmt.setInt(1, als.getAlumno().getIdAlumno());
                stmt.setInt(2, als.getSancion().getIdSancion());
                stmt.setInt(3, als.getCantidad());
                stmt.setDate(4, fechaCarga);
                stmt.setString(5, als.getObservacion());
            }

            stmt.execute();
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

    public void modificarCantidad(Alumno alm) {
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

    public boolean existeSancionAlumno(int id, int idSancion) {
        conexion = Conexion.conectar();
        try {
            ResultSet rs;
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM AlumnoSancion "
                    + "WHERE alumno= ? AND sancion = ?");
            stmt.setInt(1, id);
            stmt.setInt(2, idSancion);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return false;
    }

    public AlumnoSancion recuperarRegistro(int id, int idSancion) {
        conexion = Conexion.conectar();
        AlumnoSancion alumnoSancion = null;
        try {
            ResultSet rs;
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM AlumnoSancion "
                    + "WHERE alumno= ? AND sancion = ?");
            stmt.setInt(1, id);
            stmt.setInt(2, idSancion);
            rs = stmt.executeQuery();
            if (rs.next()) {
                alumnoSancion = new AlumnoSancion();
                alumnoSancion.setIdAlumnoSancion(rs.getInt("idAlumnoSancion"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return alumnoSancion;
    }

    public int obtenerTotal(int id, int idSancion) {
        conexion = Conexion.conectar();
        AlumnoSancion alumnoSancion = null;
        int total = 0;
        try {
            ResultSet rs;
            
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM AlumnoSancion "
                    + "WHERE alumno= ? AND sancion = ?");
            stmt.setInt(1, id);
            stmt.setInt(2, idSancion);
            rs = stmt.executeQuery();
            while (rs.next()) {
                total = total + rs.getInt("cantidad");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return total;
    }
}
