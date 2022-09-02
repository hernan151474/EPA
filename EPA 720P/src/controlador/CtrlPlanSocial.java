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
import modelo.PlanSocial;

/**
 *
 * @author acer
 */
public class CtrlPlanSocial {

    Connection conexion;
    PlanEstudio planEstudio = new PlanEstudio();

    public List<PlanSocial> leerTodos() {
        conexion = Conexion.conectar();
        List<PlanSocial> lista = new ArrayList();
        PlanSocial planSocial = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM PlanSocial ORDER BY nombre");
            rs = stmt.executeQuery();
            while (rs.next()) {
                planSocial = new PlanSocial();
                planSocial.setIdPlanSocial(rs.getInt("idPlanSocial"));
                planSocial.setNombre(rs.getString("nombre"));
                lista.add(planSocial);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }

    public PlanSocial leerID(String nombre) {
        conexion = Conexion.conectar();
        PlanSocial planSocial = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT idPlanSocial FROM PlanSocial "
                    + "WHERE nombre = ? ");
            stmt.setString(1, nombre);
            rs = stmt.executeQuery();
            if (rs.next()) {
                planSocial = new PlanSocial();
                planSocial.setIdPlanSocial(rs.getInt("idPlanSocial"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return planSocial;
    }

    public PlanSocial leerID(int id) {
        conexion = Conexion.conectar();
        PlanSocial planSocial = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM PlanSocial "
                    + "WHERE idPlanSocial = ? ");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                planSocial = new PlanSocial();
                planSocial.setIdPlanSocial(rs.getInt("idPlanSocial"));
                planSocial.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return planSocial;
    }

    public List<PlanSocial> leerPlanAlumno(int idAlumno) {
        conexion = Conexion.conectar();
        PlanSocial planSocial = null;
        ResultSet rs;
        List<PlanSocial> lista = new ArrayList();
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM PlanSocialAlumno INNER JOIN PlanSocial"
                    + " ON PlanSocialAlumno.planSocial = PlanSocial.idPlanSocial"
                    + " WHERE PlanSocialAlumno.alumno = ? ORDER BY nombre");
            stmt.setInt(1, idAlumno);
            rs = stmt.executeQuery();
            while (rs.next()) {
                planSocial = new PlanSocial();
                planSocial = leerID(rs.getInt("PlanSocialAlumno.planSocial"));
                lista.add(planSocial);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }

    //---------------------
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
