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
import modelo.Hora;

/**
 *
 * @author Leonel
 */
public class CtrlHora {
    Connection conexion;
    Hora hora = new Hora();
    public void crearHora(Hora hor)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO Hora (desde,hasta) VALUES (?,?)");
            stmt.setString(1, hor.getDesde());
            stmt.setString(2, hor.getHasta());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void modificarHora(Hora hor)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Hora SET desde=?,hasta=? WHERE idHora = ?");
            stmt.setString(1, hor.getDesde());
            stmt.setString(2, hor.getHasta());
            stmt.setInt(3, hor.getIdHora());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void eliminarHora(Hora hor)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Hora SET borrado = 1 WHERE idHora = ?");
            stmt.setInt(1, hor.getIdHora());
            stmt.execute();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "No se puede eliminar la hora","Error al eliminar",ERROR_MESSAGE);
        }
        Conexion.desconectar(conexion);
    }
    
    public Hora leerHora(String desde, String hasta)
    {
        conexion = Conexion.conectar();
        ResultSet rs;
        hora = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT idHora FROM Hora WHERE desde = ? AND hasta = ?");
            stmt.setString(1, desde);
            stmt.setString(2, hasta);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                hora = new Hora();
                hora.setIdHora(rs.getInt("idHora"));
                hora.setDesde(desde);
                hora.setHasta(hasta);
            }
                    
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return hora;
    }
    
    public List<Hora> leerTodos()
    {
        conexion = Conexion.conectar();
        List<Hora> lista = new ArrayList();
        hora = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT desde,hasta FROM Hora WHERE borrado = 0 ORDER BY desde");
            rs = stmt.executeQuery();
            while(rs.next())
            {
                hora = new Hora();
                hora.setDesde(rs.getString("desde"));
                hora.setHasta(rs.getString("hasta"));
                lista.add(hora);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }
}
