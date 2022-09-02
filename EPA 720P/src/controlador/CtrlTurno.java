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
import modelo.Turno;

/**
 *
 * @author Leonel
 */
public class CtrlTurno {

    Connection conexion;
    Turno turno = new Turno();

    public void crearTurno(Turno turn) {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO Turno (turno) VALUES (?)");
            stmt.setString(1, turn.getTurno());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public void modificarTurno(Turno turn) {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Turno SET turno=? WHERE idTurno = ?");
            stmt.setString(1, turn.getTurno());
            stmt.setInt(2, turn.getIdTurno());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public void eliminarTurno(Turno turn) {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Turno SET borrado = 1 WHERE idTurno = ?");
            stmt.setInt(1, turn.getIdTurno());
            stmt.execute();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "No se puede eliminar el turno", "Error al eliminar", ERROR_MESSAGE);
        }
        Conexion.desconectar(conexion);
    }

    public Turno leerTurno(String nombreTurno) {
        conexion = Conexion.conectar();
        ResultSet rs;
        turno = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT idTurno FROM Turno WHERE turno = ?");
            stmt.setString(1, nombreTurno);
            rs = stmt.executeQuery();
            if (rs.next()) {
                turno = new Turno();
                turno.setIdTurno(rs.getInt("idTurno"));
                turno.setTurno(nombreTurno);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return turno;
    }

    public Turno leerTurno(int idTurno) {
        conexion = Conexion.conectar();
        ResultSet rs;
        turno = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT turno FROM Turno WHERE idTurno = ?");
            stmt.setInt(1, idTurno);
            rs = stmt.executeQuery();
            if (rs.next()) {
                turno = new Turno();
                turno.setTurno(rs.getString("turno"));
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return turno;
    }

    public List<Turno> leerTodos() {
        conexion = Conexion.conectar();
        List<Turno> lista = new ArrayList();
        turno = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT turno FROM Turno WHERE borrado = 0");
            rs = stmt.executeQuery();
            while (rs.next()) {
                turno = new Turno();
                turno.setTurno(rs.getString("turno"));
                lista.add(turno);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }

    //------------------------------------
    public List<Turno> leerTurno() {
        conexion = Conexion.conectar();
        List<Turno> lista = new ArrayList();
        turno = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM Turno WHERE borrado = 0");
            rs = stmt.executeQuery();
            while (rs.next()) {
                turno = new Turno();
                turno.setIdTurno(rs.getInt("idTurno"));
                turno.setTurno(rs.getString("turno"));
                lista.add(turno);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }
}
