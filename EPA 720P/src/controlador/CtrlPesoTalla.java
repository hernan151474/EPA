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
import javax.swing.JOptionPane;
import modelo.PesoTalla;

/**
 *
 * @author acer
 */
public class CtrlPesoTalla {

    Connection conexion;

    public void crear(PesoTalla ptl) {
        conexion = Conexion.conectar();
        java.sql.Date fechaCreacion = new java.sql.Date(ptl.getFechaCreacion().getTime());
        java.sql.Date fechaMedicion = new java.sql.Date(ptl.getFechaMedicion().getTime());
        try {

            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO PesoTalla "
                    + "(fechaMedicion, fechaCreacion, peso, talla, alumno) "
                    + "VALUES (?, ?, ?, ?, ?)");
            stmt.setDate(1, fechaMedicion);
            stmt.setDate(2, fechaCreacion);
            stmt.setFloat(3, ptl.getPeso());
            stmt.setFloat(4, ptl.getTalla());
            stmt.setInt(5, ptl.getAlumno().getIdAlumno());
            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void modificar(PesoTalla ptl) {
        conexion = Conexion.conectar();
        java.sql.Date fechaCreacion = new java.sql.Date(ptl.getFechaCreacion().getTime());
        java.sql.Date fechaMedicion = new java.sql.Date(ptl.getFechaMedicion().getTime());
        try {

            PreparedStatement stmt = conexion.prepareStatement("UPDATE PesoTalla SET "
                    + "peso = ?, talla= ?, fechaMedicion= ? "
                    + "WHERE (idPesoTalla = ?);");
            stmt.setFloat(1, ptl.getPeso());
            stmt.setFloat(2, ptl.getTalla());
            stmt.setDate(3, fechaMedicion);
            stmt.setInt(4, ptl.getIdPesoTalla());
            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public PesoTalla leerIdAlumno(int id) {
        PesoTalla pesoTalla = null;
        conexion = Conexion.conectar();
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM PesoTalla WHERE alumno = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                pesoTalla = new PesoTalla();
                pesoTalla.setFechaCreacion(rs.getDate("fechaCreacion"));
                pesoTalla.setFechaMedicion(rs.getDate("fechaMedicion"));
                pesoTalla.setPeso(rs.getFloat("peso"));
                pesoTalla.setTalla(rs.getFloat("talla"));
                pesoTalla.setIdPesoTalla(rs.getInt("idPesoTalla"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        return pesoTalla;
    }
}
