/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Alumno;
import modelo.Sancion;

/**
 *
 * @author acer
 */
public class CtrlSancion {

    Connection conexion;

    public void crear(Sancion san) {
        conexion = Conexion.conectar();

        PreparedStatement stmt;
        try {
            stmt = conexion.prepareStatement("INSERT INTO Sancion (sancion, borrado) VALUES (?,?)");
            stmt.setString(1, san.getSancion());
            stmt.setBoolean(2, false);
            stmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public void modificar(Sancion san) {
        conexion = Conexion.conectar();

        PreparedStatement stmt;
        try {
            stmt = conexion.prepareStatement("UPDATE Sancion SET sancion = ? "
                    + "WHERE idSancion = ?");
            stmt.setString(1, san.getSancion());
            stmt.setInt(2, san.getIdSancion());
            stmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public void eliminar(Sancion san) {
        conexion = Conexion.conectar();

        PreparedStatement stmt;
        try {
            stmt = conexion.prepareStatement("UPDATE Sancion SET borrado = ? "
                    + "WHERE idSancion = ?");
            stmt.setBoolean(1, true);
            stmt.setInt(2, san.getIdSancion());
            stmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public List<Sancion> leerTodos() {
        conexion = Conexion.conectar();
        List<Sancion> lista = new ArrayList();
        Sancion sancion;
        ResultSet rs = null;
        PreparedStatement stmt;
        try {
            stmt = conexion.prepareStatement("SELECT * FROM sancion WHERE borrado = 0 ORDER BY sancion");
            rs = stmt.executeQuery();

            while (rs.next()) {
                sancion = new Sancion();
                sancion.setIdSancion(rs.getInt("idSancion"));
                sancion.setSancion(rs.getString("sancion"));
                lista.add(sancion);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);

        return lista;
    }
}
