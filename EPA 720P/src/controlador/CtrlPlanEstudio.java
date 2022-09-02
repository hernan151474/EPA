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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.PlanEstudio;

/**
 *
 * @author Leonel
 */
public class CtrlPlanEstudio {

    Connection conexion;
    PlanEstudio planEstudio = new PlanEstudio();

    public List<PlanEstudio> leerTodos() {
        conexion = Conexion.conectar();
        List<PlanEstudio> lista = new ArrayList();
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT titulo FROM PlanEstudio");
            rs = stmt.executeQuery();
            while (rs.next()) {
                planEstudio = new PlanEstudio();
                planEstudio.setTitulo(rs.getString("titulo"));
                lista.add(planEstudio);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }

    public PlanEstudio leerPlanEstudio(String titulo) {
        conexion = Conexion.conectar();
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT idPlanEstudio FROM PlanEstudio WHERE titulo = ?");
            stmt.setString(1, titulo);
            rs = stmt.executeQuery();
            if (rs.next()) {
                planEstudio = new PlanEstudio();
                planEstudio.setIdPlanEstudio(rs.getInt("idPlanEstudio"));
                planEstudio.setTitulo(titulo);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return planEstudio;
    }

    public PlanEstudio leerPlanEstudio(int idPlanEstudio) {
        conexion = Conexion.conectar();
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT titulo FROM PlanEstudio WHERE idPlanEstudio = ?");
            stmt.setInt(1, idPlanEstudio);
            rs = stmt.executeQuery();
            if (rs.next()) {
                planEstudio = new PlanEstudio();
                planEstudio.setIdPlanEstudio(idPlanEstudio);
                planEstudio.setTitulo(rs.getString("titulo"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return planEstudio;
    }

//------------------------------------
    public void crear(PlanEstudio ple) {
        conexion = Conexion.conectar();
        java.sql.Date desde = new Date(ple.getVigenciaDesde().getTime());

        PreparedStatement stmt = null;
        try {

            if (ple.getVigenciaHasta() == null && ple.getResolucion() != null) {
                stmt = conexion.prepareStatement("INSERT INTO PlanEstudio (vigenciaDesde,resolucion, titulo, borrado) VALUES (?,?,?,?)");
                stmt.setDate(1, desde);
                stmt.setString(2, ple.getResolucion());
                stmt.setString(3, ple.getTitulo());
                stmt.setBoolean(4, false);
            } else if (ple.getVigenciaHasta() != null && ple.getResolucion() == null) {
                java.sql.Date hasta = new Date(ple.getVigenciaHasta().getTime());
                stmt = conexion.prepareStatement("INSERT INTO PlanEstudio (vigenciaDesde,vigenciaHasta, titulo, borrado) VALUES (?,?,?,?)");
                stmt.setDate(1, desde);
                stmt.setDate(2, hasta);
                stmt.setString(3, ple.getTitulo());
                stmt.setBoolean(4, false);
            } else {
                java.sql.Date hasta = new Date(ple.getVigenciaHasta().getTime());
                stmt = conexion.prepareStatement("INSERT INTO PlanEstudio (vigenciaDesde,vigenciaHasta,resolucion, titulo, borrado) VALUES (?,?,?,?,?)");
                stmt.setDate(1, desde);
                stmt.setDate(2, hasta);
                stmt.setString(3, ple.getResolucion());
                stmt.setString(4, ple.getTitulo());
                stmt.setBoolean(5, false);
            }

            stmt.execute();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public void modificar(PlanEstudio ple) {
        conexion = Conexion.conectar();
        java.sql.Date desde = new Date(ple.getVigenciaDesde().getTime());
        PreparedStatement stmt = null;
        try {
            if (ple.getVigenciaHasta() == null && ple.getResolucion() != null) {
                stmt = conexion.prepareStatement("UPDATE PlanEstudio SET vigenciaDesde=?,resolucion=?, titulo=? "
                        + "WHERE idPlanEstudio= ?");
                stmt.setDate(1, desde);
                stmt.setString(2, ple.getResolucion());
                stmt.setString(3, ple.getTitulo());
                stmt.setInt(4, ple.getIdPlanEstudio());
            } else if (ple.getVigenciaHasta() != null && ple.getResolucion() == null) {
                java.sql.Date hasta = new Date(ple.getVigenciaHasta().getTime());
                stmt = conexion.prepareStatement("UPDATE PlanEstudio SET vigenciaDesde=?,vigenciaHasta=?, titulo=? "
                        + "WHERE idPlanEstudio= ?");
                stmt.setDate(1, desde);
                stmt.setDate(2, hasta);
                stmt.setString(3, ple.getTitulo());
                stmt.setInt(4, ple.getIdPlanEstudio());
            } else {
                java.sql.Date hasta = new Date(ple.getVigenciaHasta().getTime());
                stmt = conexion.prepareStatement("UPDATE  PlanEstudio SET vigenciaDesde= ?, vigenciaHasta=?, resolucion= ?, titulo= ? "
                        + "WHERE idPlanEstudio= ?");
                stmt.setDate(1, desde);
                stmt.setDate(2, hasta);
                stmt.setString(3, ple.getResolucion());
                stmt.setString(4, ple.getTitulo());
                stmt.setInt(5, ple.getIdPlanEstudio());
            }

            stmt.execute();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public void eliminar(PlanEstudio ple) {
        conexion = Conexion.conectar();
        PreparedStatement stmt = null;
        try {
            stmt = conexion.prepareStatement("UPDATE  PlanEstudio SET borrado = ? "
                    + "WHERE idPlanEstudio= ?");
            stmt.setBoolean(1, true);
            stmt.setInt(2, ple.getIdPlanEstudio());

            stmt.execute();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public List<PlanEstudio> leer() {
        conexion = Conexion.conectar();
        List<PlanEstudio> lista = new ArrayList();
        ResultSet rs;

        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM PlanEstudio WHERE borrado =0 ORDER BY titulo");
            rs = stmt.executeQuery();
            while (rs.next()) {
                planEstudio = new PlanEstudio();
                planEstudio.setIdPlanEstudio(rs.getInt("idPlanEstudio"));
                planEstudio.setTitulo(rs.getString("titulo"));
                planEstudio.setResolucion(rs.getString("resolucion"));
                planEstudio.setVigenciaDesde(rs.getDate("vigenciaDesde"));
                planEstudio.setVigenciaHasta(rs.getDate("vigenciaHasta"));
                lista.add(planEstudio);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }
}
