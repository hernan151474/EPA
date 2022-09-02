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

/**
 *
 * @author Leonel
 */
public class CtrlCargo {
    Connection conexion;
    Cargo cargo = new Cargo();
    
    public void crearCargo(Cargo carg)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO Cargo (cargo) VALUES (?)");
            stmt.setString(1, carg.getCargo());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void modificarCargo(Cargo carg)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Cargo SET cargo=? WHERE idCargo = ?");
            stmt.setString(1, carg.getCargo());
            stmt.setInt(2, carg.getIdCargo());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void eliminarCargo(Cargo carg)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Cargo SET borrado = 1 WHERE idCargo = ?");
            stmt.setInt(1, carg.getIdCargo());
            stmt.execute();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "No se puede eliminar el cargo","Error al eliminar",ERROR_MESSAGE);
        }
        Conexion.desconectar(conexion);
    }
    
    public Cargo leerCargo(String nombreCargo)
    {
        conexion = Conexion.conectar();
        ResultSet rs;
        cargo = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT idCargo FROM Cargo WHERE cargo = ?");
            stmt.setString(1, nombreCargo);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                cargo = new Cargo();
                cargo.setIdCargo(rs.getInt("idCargo"));
            }
                    
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return cargo;
    }
    
    public List<Cargo> leerTodos()
    {
        conexion = Conexion.conectar();
        List<Cargo> lista = new ArrayList();
        cargo = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT cargo FROM Cargo WHERE borrado = 0 ORDER BY cargo");
            rs = stmt.executeQuery();
            while(rs.next())
            {
                cargo = new Cargo();
                cargo.setCargo(rs.getString("cargo"));
                lista.add(cargo);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }
}
