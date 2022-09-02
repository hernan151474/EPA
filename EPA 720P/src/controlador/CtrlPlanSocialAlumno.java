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
import modelo.PlanSocialAlumno;

/**
 *
 * @author acer
 */
public class CtrlPlanSocialAlumno {

    Connection conexion;

    public void crear(PlanSocialAlumno pla) {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO PlanSocialAlumno (alumno, planSocial) "
                    + "VALUES (?, ?)");
            stmt.setInt(1, pla.getAlumno().getIdAlumno());
            stmt.setInt(2, pla.getPlanSocial().getIdPlanSocial());

            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public void eliminar(PlanSocialAlumno pla) {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("DELETE FROM PlanSocialAlumno "
                    + "WHERE alumno = ? AND planSocial = ?");
            stmt.setInt(1, pla.getAlumno().getIdAlumno());
            stmt.setInt(2, pla.getPlanSocial().getIdPlanSocial());
            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public boolean existePlanAlum(String nombre, int idAlumno) {
        conexion = Conexion.conectar();
        ResultSet rs = null;
        try {

            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM PlanSocialAlumno "
                    + "INNER JOIN PlanSocial ON PlanSocialAlumno.planSocial = PlanSocial.idPlanSocial "
                    + "WHERE PlanSocial.borrado = 0 AND PlanSocialAlumno.alumno = ? AND PlanSocial.nombre = ?");
            stmt.setInt(1, idAlumno);
            stmt.setString(2, nombre);

            rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return false;
    }
}
