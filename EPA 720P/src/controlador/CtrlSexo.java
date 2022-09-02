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
import modelo.Sexo;

/**
 *
 * @author Leonel
 */
public class CtrlSexo {
    Connection conexion;
    Sexo sexo = new Sexo();
    
    public void crearSexo(Sexo sex)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO Sexo (sexo) VALUES (?)");
            stmt.setString(1, sex.getSexo());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void modificarSexo(Sexo sex)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Sexo SET sexo=? WHERE idSexo = ?");
            stmt.setString(1, sex.getSexo());
            stmt.setInt(2, sex.getIdSexo());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void eliminarSexo(Sexo sex)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Sexo SET borrado = 1 WHERE idSexo = ?");
            stmt.setInt(1, sex.getIdSexo());
            stmt.execute();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "No se puede eliminar el sexo","Error al eliminar",ERROR_MESSAGE);
        }
        Conexion.desconectar(conexion);
    }
    
    public Sexo leerSexo(String nombreSexo)
    {
        conexion = Conexion.conectar();
        ResultSet rs;
        sexo = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT idSexo FROM Sexo WHERE sexo = ?");
            stmt.setString(1, nombreSexo);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                sexo = new Sexo();
                sexo.setIdSexo(rs.getInt("idSexo"));
            }
                    
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return sexo;
    }
    
    public Sexo leerSexo(int idSexo)
    {
        conexion = Conexion.conectar();
        ResultSet rs;
        sexo = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT sexo FROM Sexo WHERE idSexo = ?");
            stmt.setInt(1, idSexo);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                sexo = new Sexo();
                sexo.setSexo(rs.getString("sexo"));
            }
                    
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return sexo;
    }
    
    public List<Sexo> leerTodos()
    {
        conexion = Conexion.conectar();
        List<Sexo> lista = new ArrayList();
        sexo = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT idSexo, sexo FROM Sexo WHERE borrado = 0 ORDER BY sexo");
            rs = stmt.executeQuery();
            while(rs.next())
            {
                sexo = new Sexo();
                sexo.setIdSexo(rs.getInt("idSexo"));//Agregado mio(Kevin) para poder reutilizar este metodo            
                sexo.setSexo(rs.getString("sexo"));
                lista.add(sexo);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }
}
