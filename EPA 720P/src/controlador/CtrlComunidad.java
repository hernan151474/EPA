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
import modelo.Comunidad;

/**
 *
 * @author acer
 */
public class CtrlComunidad {

    Connection conexion;

    public void crear(Comunidad com) {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO Comunidad (nombre, borrado) VALUES (?,false)");
            stmt.setString(1, com.getNombre());
            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public void modicar() {

    }

    public void eliminar() {

    }

    public List<Comunidad> leerTodoComunidad() {
        conexion = Conexion.conectar();
        List<Comunidad> lista = new ArrayList();
        Comunidad comunidad = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM Comunidad WHERE borrado = 0 ORDER BY nombre");
            rs = stmt.executeQuery();
            while (rs.next()) {
                comunidad = new Comunidad();
                comunidad.setIdCargoPersonal(rs.getInt("idComunidades"));//Agregado mio(Kevin) para poder reutilizar este metodo

                comunidad.setNombre(rs.getString("nombre"));
                lista.add(comunidad);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }

    public Comunidad leerId(int id) {
        conexion = Conexion.conectar();

        Comunidad comunidad = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM Comunidad WHERE borrado = 0 AND idComunidades = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                comunidad = new Comunidad();
                comunidad.setIdCargoPersonal(id);//Agregado mio(Kevin) para poder reutilizar este metodo

                comunidad.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return comunidad;
    }

    public Comunidad leerId(String nombre) {
        conexion = Conexion.conectar();

        Comunidad comunidad = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM Comunidad "
                    + "WHERE borrado = 0 AND nombre = ?");
            stmt.setString(1, nombre);
            rs = stmt.executeQuery();
            if (rs.next()) {
                comunidad = new Comunidad();
                comunidad.setIdCargoPersonal(rs.getInt("idComunidades"));//Agregado mio(Kevin) para poder reutilizar este metodo

                comunidad.setNombre(nombre);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return comunidad;
    }

    public int leerUltimoRegCargado() {
        conexion = Conexion.conectar();
        ResultSet rs;
        PreparedStatement stmt;

        try {
            stmt = conexion.prepareStatement("SELECT MAX(idComunidades) "
                    + "AS id FROM Comunidad");

            rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return 0;
    }

    public int existe(String nombre) {
        conexion = Conexion.conectar();
        ResultSet rs;
        PreparedStatement stmt;
        try {
            stmt = conexion.prepareStatement("SELECT COUNT(idComunidades) AS existe "
                    + "FROM Comunidad "
                    + "WHERE nombre = ?");
            stmt.setString(1, nombre);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("existe");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        return 0;
    }
}
