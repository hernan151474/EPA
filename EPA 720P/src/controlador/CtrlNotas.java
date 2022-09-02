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
import modelo.Notas;

/**
 *
 * @author acer
 */
public class CtrlNotas {

    Connection conexion;

    public void crear(Notas nt) {
        conexion = Conexion.conectar();

        PreparedStatement stmt;
        java.sql.Date fecha = new Date(nt.getFecha().getTime());

        try {
            stmt = conexion.prepareStatement("INSERT INTO Notas (alumnoMateria, nota, fecha) "
                    + "VALUES (?,?,?)");
            stmt.setInt(1, nt.getAlumnoMateria().getIdAlumnoMateria());
            stmt.setFloat(2, nt.getNota());
            stmt.setDate(3, fecha);
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
    public Notas leerAlumno(int idAlumno) {
        conexion = Conexion.conectar();
       Notas notas = null;

        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM notas "
                    + "where fecha = (SELECT MAX(fecha) FROM notas "
                    + "where alumnoMateria = ?)");
            stmt.setInt(1, idAlumno);
            rs = stmt.executeQuery();

            if (rs.next()) {
                notas = new Notas();
                notas.setIdNota(rs.getInt("idNotas"));
                notas.setNota(rs.getFloat("nota"));
                notas.setFecha(rs.getDate("fecha"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return notas;
    }
}
