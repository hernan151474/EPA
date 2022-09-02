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
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import modelo.Aula;

/**
 *
 * @author Leonel
 */
public class CtrlAula {

    Connection conexion;
    CtrlCurso ctrlCurso = new CtrlCurso();
    CtrlDivision ctrlDivision = new CtrlDivision();
    CtrlTurno ctrlTurno = new CtrlTurno();
    Aula aula = new Aula();

    public void crearAula(Aula aul) {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO Aula (curso,division,turno) VALUES (?,?,?)");
            stmt.setInt(1, aul.getCurso().getIdCurso());
            stmt.setInt(2, aul.getDivision().getIdDivision());
            stmt.setInt(3, aul.getTurno().getIdTurno());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public void modificarAula(Aula aul) {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Aula SET curso=?,division=?,turno=? WHERE idAula = ?");
            stmt.setInt(1, aul.getCurso().getIdCurso());
            stmt.setInt(2, aul.getDivision().getIdDivision());
            stmt.setInt(3, aul.getTurno().getIdTurno());
            stmt.setInt(4, aul.getIdAula());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public void eliminarAula(Aula aul) {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Aula SET borrado = 1 WHERE idAula = ?");
            stmt.setInt(1, aul.getIdAula());
            stmt.execute();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "No se puede eliminar el aula", "Error al eliminar", ERROR_MESSAGE);
        }
        Conexion.desconectar(conexion);
    }

    public Aula leerAula(int idCurso, int idDivision, int idTurno) {
        conexion = Conexion.conectar();
        ResultSet rs;
        aula = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT idAula FROM Aula WHERE curso = ? AND division = ? AND turno = ?");
            stmt.setInt(1, idCurso);
            stmt.setInt(2, idDivision);
            stmt.setInt(3, idTurno);
            rs = stmt.executeQuery();
            if (rs.next()) {
                aula = new Aula();
                aula.setIdAula(rs.getInt("idAula"));
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return aula;
    }

    public Aula existeAula(int idCurso, int idDivision) {
        conexion = Conexion.conectar();
        ResultSet rs;
        aula = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT idAula FROM Aula WHERE curso = ? AND division = ?");
            stmt.setInt(1, idCurso);
            stmt.setInt(2, idDivision);
            rs = stmt.executeQuery();
            if (rs.next()) {
                aula = new Aula();
                aula.setIdAula(rs.getInt("idAula"));
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return aula;
    }

    public Aula leerAula(int idAula) {
        conexion = Conexion.conectar();
        ResultSet rs;
        aula = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT curso,division,turno FROM Aula WHERE idAula = ?");
            stmt.setInt(1, idAula);
            rs = stmt.executeQuery();
            if (rs.next()) {
                aula = new Aula();
                aula.setIdAula(idAula);
                aula.setCurso(ctrlCurso.leerCurso(rs.getInt("curso")));
                aula.setDivision(ctrlDivision.leerDivision(rs.getInt("division")));
                aula.setTurno(ctrlTurno.leerTurno(rs.getInt("turno")));
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return aula;
    }

    public List<Aula> leerTodos() {
        conexion = Conexion.conectar();
        List<Aula> lista = new ArrayList();
        aula = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT curso,division,turno FROM Aula WHERE borrado = 0 ORDER BY curso,division");
            rs = stmt.executeQuery();
            while (rs.next()) {
                aula = new Aula();
                aula.setCurso(ctrlCurso.leerCurso(rs.getInt("curso")));
                aula.setDivision(ctrlDivision.leerDivision(rs.getInt("division")));
                aula.setTurno(ctrlTurno.leerTurno(rs.getInt("turno")));
                lista.add(aula);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }
    //---------------------

    public List<Aula> leer() {
        conexion = Conexion.conectar();
        List<Aula> lista = new ArrayList();
        aula = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM Aula WHERE borrado = 0 ORDER BY curso,division");
            rs = stmt.executeQuery();
            while (rs.next()) {
                aula = new Aula();
                aula.setIdAula(rs.getInt("idAula"));
                aula.setCurso(ctrlCurso.leerCurso(rs.getInt("curso")));
                aula.setDivision(ctrlDivision.leerDivision(rs.getInt("division")));
                aula.setTurno(ctrlTurno.leerTurno(rs.getInt("turno")));
                lista.add(aula);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }

    public List<Aula> leer(int turno) {
        conexion = Conexion.conectar();
        List<Aula> lista = new ArrayList();
        aula = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM Aula WHERE borrado = 0 AND turno = ? ORDER BY curso,division");
            stmt.setInt(1, turno);
            rs = stmt.executeQuery();
            while (rs.next()) {
                aula = new Aula();
                aula.setIdAula(rs.getInt("idAula"));
                aula.setCurso(ctrlCurso.leerCurso(rs.getInt("curso")));
                aula.setDivision(ctrlDivision.leerDivision(rs.getInt("division")));
                aula.setTurno(ctrlTurno.leerTurno(rs.getInt("turno")));
                lista.add(aula);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }
}
