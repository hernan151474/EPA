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
import modelo.RegimenEspecial;

/**
 *
 * @author acer
 */
public class CtrlRegimenEspecial {

    Connection conexion;

    public void crear(RegimenEspecial reg) {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO RegimenEspecial (nombre, borrado) VALUES (?,false)");
            stmt.setString(1, reg.getNombre());
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

    public List<RegimenEspecial> leerTodoRegimen() {
        conexion = Conexion.conectar();
        List<RegimenEspecial> lista = new ArrayList();
        RegimenEspecial regimenEspecial = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM RegimenEspecial WHERE borrado = 0 ORDER BY nombre");
            rs = stmt.executeQuery();
            while (rs.next()) {
                regimenEspecial = new RegimenEspecial();
                regimenEspecial.setIdRegimenEspecial(rs.getInt("idRegimenEspecial"));//Agregado mio(Kevin) para poder reutilizar este metodo

                regimenEspecial.setNombre(rs.getString("nombre"));
                lista.add(regimenEspecial);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }

    public RegimenEspecial leerId(int id) {
        conexion = Conexion.conectar();

        RegimenEspecial regimenEspecial = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM RegimenEspecial WHERE borrado = 0 AND idRegimenEspecial = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                regimenEspecial = new RegimenEspecial();
                regimenEspecial.setIdRegimenEspecial(rs.getInt("idRegimenEspecial"));//Agregado mio(Kevin) para poder reutilizar este metodo

                regimenEspecial.setNombre(rs.getString("nombre"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return regimenEspecial;
    }

    public RegimenEspecial leerId(String nombre) {
        conexion = Conexion.conectar();

        RegimenEspecial regimenEspecial = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM RegimenEspecial "
                    + "WHERE borrado = 0 AND nombre = ?");
            stmt.setString(1, nombre);
            rs = stmt.executeQuery();
            if (rs.next()) {
                regimenEspecial = new RegimenEspecial();
                regimenEspecial.setIdRegimenEspecial(rs.getInt("idRegimenEspecial"));//Agregado mio(Kevin) para poder reutilizar este metodo

                regimenEspecial.setNombre(nombre);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return regimenEspecial;
    }

    public int leerUltimoRegCargado() {
        conexion = Conexion.conectar();
        ResultSet rs;
        PreparedStatement stmt;

        try {
            stmt = conexion.prepareStatement("SELECT MAX(idRegimenEspecial) "
                    + "AS id FROM RegimenEspecial");

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
            stmt = conexion.prepareStatement("SELECT COUNT(idRegimenEspecial) AS existe "
                    + "FROM RegimenEspecial "
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
