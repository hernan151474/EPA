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
import modelo.Estado;
import modelo.Personal;

/**
 *
 * @author acer
 */
public class CtrlEstado {

    Connection conexion;

    public void crear(Alumno alm) {
        conexion = Conexion.conectar();

        PreparedStatement stmt;
        try {
            stmt = conexion.prepareStatement("INSERT INTO Alumno (personal, estado) VALUES (?,?)");
            stmt.setInt(1, alm.getPersonal().getIdPersonal());
            stmt.setInt(2, alm.getEstado().getIdEstado());
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

    public List<Estado> leerTodo() {
        List<Estado> listaEstado = new ArrayList<>();
        Estado estado = null;
        conexion = Conexion.conectar();
        ResultSet rs = null;
        PreparedStatement stmt;
        try {
            stmt = conexion.prepareStatement("SELECT * FROM Estado ORDER BY estado");
            rs = stmt.executeQuery();
            if (rs.next()) {
                estado = new Estado();
                estado.setIdEstado(rs.getInt("idEstado"));
                estado.setEstado(rs.getString("estado"));
                listaEstado.add(estado);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        return listaEstado;
    }

    public Estado leer(int id) {
        Estado est = null;
        conexion = Conexion.conectar();

        PreparedStatement stmt;
        ResultSet rs = null;
        try {
            stmt = conexion.prepareStatement("SELECT * FROM Estado WHERE idEstado = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                est = new Estado();
                est.setIdEstado(id);
                est.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return est;
    }

}
