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
import modelo.Edificio;

/**
 *
 * @author Leonel
 */
public class CtrlEdificio {
    Connection conexion;
    Edificio edificio = new Edificio();
    
    public void crearEdificio(Edificio edif)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO Edificio (domicilio,telefonoFijo,torre,piso,dpto) VALUES (?,?,?,?,?)");
            stmt.setInt(1, edif.getDomicilio().getIdDomicilio());
            stmt.setString(2, edif.getTelefonoFijo());
            stmt.setString(3, edif.getTorre());
            stmt.setString(4, edif.getPiso());
            stmt.setString(5, edif.getDpto());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void modificarEdificio(Edificio edif)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Edificio SET telefonoFijo = ?,torre = ?,piso = ?,dpto = ? WHERE idEdificio = ?");
            stmt.setString(1, edif.getTelefonoFijo());
            stmt.setString(2, edif.getTorre());
            stmt.setString(3, edif.getPiso());
            stmt.setString(4, edif.getDpto());
            stmt.setInt(5, edif.getIdEdificio());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public Edificio leerUltimo()
    {
        conexion = Conexion.conectar();
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT MAX(idEdificio) AS id FROM Edificio");
            rs = stmt.executeQuery();
            rs.next();
            edificio = new Edificio();
            edificio.setIdEdificio(rs.getInt("id"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return edificio;
    }
    
    public Edificio leerEdificio(int idDomicilio)
    {
        conexion = Conexion.conectar();
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT telefonoFijo,torre,piso,dpto FROM Edificio WHERE domicilio = ?");
            stmt.setInt(1, idDomicilio);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                edificio = new Edificio();
                edificio.setTelefonoFijo(rs.getString("telefonoFijo"));
                edificio.setTorre(rs.getString("torre"));
                edificio.setPiso(rs.getString("piso"));
                edificio.setDpto(rs.getString("dpto"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return edificio;
    }
    
    //--------------------------------------------------------------------------
    public void crear(Edificio ed) {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO Edificio "
                    + "(domicilio, torre, piso, dpto, telefonoFijo, borrado) "
                    + "VALUES (?,?,?,?,?, false)");
            stmt.setInt(1, ed.getDomicilio().getIdDomicilio());
            stmt.setString(2, ed.getTorre());
            stmt.setString(3, ed.getPiso());
            stmt.setString(4, ed.getDpto());
            stmt.setString(5, ed.getTelefonoFijo());
            stmt.execute();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void modificar(Edificio ed) {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE  Edificio SET "
                    + "domicilio = ?, torre = ?, piso = ?, dpto = ?, telefonoFijo = ? "
                    + "WHERE idEdificio = ?");
            stmt.setInt(1, ed.getDomicilio().getIdDomicilio());
            stmt.setString(2, ed.getTorre());
            stmt.setString(3, ed.getPiso());
            stmt.setString(4, ed.getDpto());
            stmt.setString(5, ed.getTelefonoFijo());
            stmt.setInt(6, ed.getIdEdificio());
            stmt.execute();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public Edificio leerIdDomicilio(int IdDomi) {
        conexion = Conexion.conectar();
        ResultSet rs = null;
        Edificio edificio = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM Edificio "
                    + "WHERE domicilio = ?");
            stmt.setInt(1, IdDomi);
            rs = stmt.executeQuery();
            if (rs.next()) {
                edificio = new Edificio();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        return edificio;
    }
}
