/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import modelo.Cargo;
import modelo.CargoPersonal;
import modelo.Revista;

/**
 *
 * @author Leonel
 */
public class CtrlCargoPersonal {
    Connection conexion;
    CtrlCargo ctrlCargo = new CtrlCargo();
    CtrlRevista ctrlRevista = new CtrlRevista();
    CargoPersonal cargoPersonal = new CargoPersonal();
    Cargo cargo = new Cargo();
    Revista revista = new Revista();
    
    public void crearCargoPersonal(CargoPersonal crpl)
    {
        java.sql.Date desde = new java.sql.Date(crpl.getDesde().getTime());
        java.sql.Date hasta = new java.sql.Date(crpl.getHasta().getTime());
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO CargoPersonal (personal,revista,cargo,desde,hasta) VALUES (?,?,?,?,?)");
            stmt.setInt(1, crpl.getPersonal().getIdPersonal());
            stmt.setInt(2, crpl.getRevista().getIdRevista());
            stmt.setInt(3, crpl.getCargo().getIdCargo());
            stmt.setDate(4, desde);
            stmt.setDate(5, hasta);
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void modificarCargoPersonal(CargoPersonal crpl)
    {
        java.sql.Date desde = new java.sql.Date(crpl.getDesde().getTime());
        java.sql.Date hasta = new java.sql.Date(crpl.getHasta().getTime());
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE CargoPersonal SET personal=?,revista=?,cargo=?,desde=?,hasta=? WHERE idCargoPersonal = ?");
            stmt.setInt(1, crpl.getPersonal().getIdPersonal());
            stmt.setInt(2, crpl.getRevista().getIdRevista());
            stmt.setInt(3, crpl.getCargo().getIdCargo());
            stmt.setDate(4, desde);
            stmt.setDate(5, hasta);
            stmt.setInt(6, crpl.getIdCargoPersonal());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void eliminarCargoPersonal(CargoPersonal crpl)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("DELETE FROM CargoPersonal WHERE idCargoPersonal = ?");
            stmt.setInt(1, crpl.getIdCargoPersonal());
            stmt.execute();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "No se puede eliminar el cargo del personal","Error al eliminar",ERROR_MESSAGE);
        }
        Conexion.desconectar(conexion);
    }
    
    public void eliminarCargosPersonales(int idPersonal)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("DELETE FROM CargoPersonal WHERE personal = ?");
            stmt.setInt(1, idPersonal);
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public List<CargoPersonal> leerCargos(String cuil)
    {
        conexion = Conexion.conectar();
        List<CargoPersonal> lista = new ArrayList();
        cargoPersonal = null;
        cargo = null;
        revista = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT Cargo.Cargo,Revista.Revista,CargoPersonal.Desde,CargoPersonal.Hasta FROM Personal " +
            "INNER JOIN CargoPersonal ON CargoPersonal.Personal = Personal.idPersonal " +
            "INNER JOIN Cargo ON CargoPersonal.Cargo = Cargo.idCargo " +
            "INNER JOIN Revista ON CargoPersonal.Revista = Revista.idRevista " +
            "WHERE Personal.cuil = ?");
            stmt.setString(1, cuil);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                cargoPersonal = new CargoPersonal();
                cargo = new Cargo();
                revista = new Revista();
                cargo.setCargo(rs.getString("Cargo.cargo"));
                revista.setRevista(rs.getString("Revista.revista"));
                cargoPersonal.setCargo(cargo);
                cargoPersonal.setRevista(revista);
                cargoPersonal.setDesde(rs.getDate("CargoPersonal.Desde"));
                cargoPersonal.setHasta(rs.getDate("CargoPersonal.Hasta"));
                lista.add(cargoPersonal);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }
}
