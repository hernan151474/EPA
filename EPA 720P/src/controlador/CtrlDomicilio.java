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
import modelo.Domicilio;

/**
 *
 * @author Leonel
 */
public class CtrlDomicilio {

    Connection conexion;
    Domicilio domicilio = new Domicilio();
    CtrlLugar ctrlLugar = new CtrlLugar();

    public void crearDomicilio(Domicilio domi) {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO Domicilio (calle,numero,telefonoFijo,referencia,codPostal) VALUES (?,?,?,?,?)");
            stmt.setInt(1, domi.getCalle().getIdLugar());
            stmt.setString(2, domi.getNumero());
            stmt.setString(3, domi.getTelefonoFijo());
            stmt.setString(4, domi.getReferencia());
            stmt.setString(5, domi.getCodPostal());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public void modificarDomicilio(Domicilio domi) {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Domicilio SET calle = ?,numero = ?,telefonoFijo = ?,referencia = ?,codPostal = ? WHERE idDomicilio = ?");
            stmt.setInt(1, domi.getCalle().getIdLugar());
            stmt.setString(2, domi.getNumero());
            stmt.setString(3, domi.getTelefonoFijo());
            stmt.setString(4, domi.getReferencia());
            stmt.setString(5, domi.getCodPostal());
            stmt.setInt(6, domi.getIdDomicilio());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public Domicilio leerUltimo() {
        conexion = Conexion.conectar();
        ResultSet rs;

        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT MAX(idDomicilio) AS id FROM Domicilio");
            rs = stmt.executeQuery();
            rs.next();
            domicilio = new Domicilio();
            domicilio.setIdDomicilio(rs.getInt("id"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return domicilio;
    }

    public Domicilio leerDomicilio(int idDomicilio) {
        conexion = Conexion.conectar();
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT calle,numero,telefonoFijo,referencia,codPostal FROM Domicilio WHERE idDomicilio = ?");
            stmt.setInt(1, idDomicilio);
            rs = stmt.executeQuery();
            if (rs.next()) {
                domicilio = new Domicilio();
                domicilio.setIdDomicilio(idDomicilio);
                domicilio.setCalle(ctrlLugar.leerLugar(rs.getInt("calle")));
                domicilio.setNumero(rs.getString("numero"));
                domicilio.setTelefonoFijo(rs.getString("telefonoFijo"));
                domicilio.setReferencia(rs.getString("referencia"));
                domicilio.setCodPostal(rs.getString("codPostal"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return domicilio;
    }

    //------------------------
    public Domicilio leerId(int Id) {
        conexion = Conexion.conectar();
        ResultSet rs;
        Domicilio dom = null;
        CtrlLugar ctrlLugar = new CtrlLugar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM Domicilio WHERE idDomicilio = ?");
            stmt.setInt(1, Id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                dom = new Domicilio();
                dom.setIdDomicilio(Id);
                dom.setCalle(ctrlLugar.leerId(rs.getInt("calle")));
                dom.setNumero(rs.getString("numero"));

                dom.setTelefonoFijo(rs.getString("telefonoFijo"));
                dom.setReferencia(rs.getString("referencia"));
                dom.setCodPostal(rs.getString("codPostal"));
            }
        } catch (SQLException e) {
        }
        return dom;
    }

    public int leerUltimoRegCargado() {
        conexion = Conexion.conectar();
        ResultSet rs;
        PreparedStatement stmt;

        try {
            stmt = conexion.prepareStatement("SELECT MAX(idDomicilio) "
                    + "AS id FROM Domicilio");

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

    public boolean existeDomicilio(int id, String numero) {
        conexion = Conexion.conectar();
        try {
            ResultSet rs;
            PreparedStatement stmt = conexion.prepareStatement("SELECT * from Domicilio "
                    + "where calle= ? AND numero= ?");
            stmt.setInt(1, id);
            stmt.setString(2, numero);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return false;
    }

    //-----------------
    public void crear(Domicilio dom, boolean edificio) {
        conexion = Conexion.conectar();
        try {
            if (edificio == false) {
                PreparedStatement stmt = conexion.prepareStatement("INSERT INTO Domicilio "
                        + "(calle, numero, telefonoFijo, referencia, codPostal) "
                        + "VALUES (?,?,?,?,?)");
                stmt.setInt(1, dom.getCalle().getIdLugar());
                stmt.setString(2, dom.getNumero());
                stmt.setString(3, dom.getTelefonoFijo());
                stmt.setString(4, dom.getReferencia());
                stmt.setString(5, dom.getCodPostal());
                stmt.execute();
            } else {
                PreparedStatement stmt = conexion.prepareStatement("INSERT INTO Domicilio "
                        + "(calle, numero, referencia, codPostal) "
                        + "VALUES (?,?,?,?)");
                stmt.setInt(1, dom.getCalle().getIdLugar());
                stmt.setString(2, dom.getNumero());
                stmt.setString(3, dom.getReferencia());
                stmt.setString(4, dom.getCodPostal());
                stmt.execute();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public void modificar(Domicilio dom, boolean edificio) {
        conexion = Conexion.conectar();
        try {
            if (edificio == false) {
                PreparedStatement stmt = conexion.prepareStatement("UPDATE Domicilio SET "
                        + "numero = ?, telefonoFijo = ?, referencia = ? , codPostal= ? "
                        + "WHERE idDomicilio = ?");
                stmt.setString(1, dom.getNumero());
                stmt.setString(2, dom.getTelefonoFijo());
                stmt.setString(3, dom.getReferencia());
                stmt.setString(4, dom.getCodPostal());
                stmt.setInt(5, dom.getIdDomicilio());
                stmt.execute();
            } else {
                PreparedStatement stmt = conexion.prepareStatement("UPDATE Domicilio SET "
                        + "numero = ?, referencia = ? , codPostal= ? "
                        + "WHERE idDomicilio = ?");

                stmt.setString(1, dom.getNumero());
                stmt.setString(2, dom.getReferencia());
                stmt.setString(3, dom.getCodPostal());
                stmt.setInt(4, dom.getIdDomicilio());
                stmt.execute();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
}
