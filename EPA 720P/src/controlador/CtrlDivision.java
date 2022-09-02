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
import modelo.Division;

/**
 *
 * @author Leonel
 */
public class CtrlDivision {
    Connection conexion;
    Division division = new Division();
    public void crearDivision(Division dvsn)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO Division (division) VALUES (?)");
            stmt.setString(1, dvsn.getDivision());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void modificarDivision(Division dvsn)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Division SET division=? WHERE idDivision = ?");
            stmt.setString(1, dvsn.getDivision());
            stmt.setInt(2, dvsn.getIdDivision());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void eliminarDivision(Division dvsn)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Division SET borrado = 1 WHERE idDivision = ?");
            stmt.setInt(1, dvsn.getIdDivision());
            stmt.execute();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "No se puede eliminar la division","Error al eliminar",ERROR_MESSAGE);
        }
        Conexion.desconectar(conexion);
    }
    
    public Division leerDivision(String nombreDivision)
    {
        conexion = Conexion.conectar();
        ResultSet rs;
        division = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT idDivision FROM Division WHERE division = ?");
            stmt.setString(1, nombreDivision);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                division = new Division();
                division.setIdDivision(rs.getInt("idDivision"));
            }
                    
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return division;
    }
    
    public Division leerDivision(int idDivision)
    {
        conexion = Conexion.conectar();
        ResultSet rs;
        division = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT division FROM Division WHERE idDivision = ?");
            stmt.setInt(1, idDivision);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                division = new Division();
                division.setDivision(rs.getString("division"));
            }
                    
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return division;
    }
    
    public List<Division> leerTodos()
    {
        conexion = Conexion.conectar();
        List<Division> lista = new ArrayList();
        division = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT division FROM Division WHERE borrado = 0 ORDER BY division");
            rs = stmt.executeQuery();
            while(rs.next())
            {
                division = new Division();
                division.setDivision(rs.getString("division"));
                lista.add(division);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }
}
