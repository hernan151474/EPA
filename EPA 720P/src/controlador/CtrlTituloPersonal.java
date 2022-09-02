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
import modelo.Nivel;
import modelo.Titulo;
import modelo.TituloPersonal;

/**
 *
 * @author Leonel
 */
public class CtrlTituloPersonal {
    Connection conexion;
    TituloPersonal tituloPersonal = new TituloPersonal();
    Titulo titulo = new Titulo();
    Nivel nivel = new Nivel();
    
    public void crearTituloPersonal(TituloPersonal ttpl)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO TituloPersonal (personal,titulo) VALUES (?,?)");
            stmt.setInt(1, ttpl.getPersonal().getIdPersonal());
            stmt.setInt(2, ttpl.getTitulo().getIdTitulo());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void modificarTituloPersonal(TituloPersonal ttpl)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE TituloPersonal SET personal=?,titulo=? WHERE idTituloPersonal = ?");
            stmt.setInt(1, ttpl.getPersonal().getIdPersonal());
            stmt.setInt(2, ttpl.getTitulo().getIdTitulo());
            stmt.setInt(3, ttpl.getIdTituloPersonal());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void eliminarTituloPersonal(TituloPersonal ttpl)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("DELETE FROM TituloPersonal WHERE idTituloPersonal = ?");
            stmt.setInt(1, ttpl.getIdTituloPersonal());
            stmt.execute();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "No se puede eliminar el titulo del personal","Error al eliminar",ERROR_MESSAGE);
        }
        Conexion.desconectar(conexion);
    }
    
    public void eliminarTitulosPersonales(int idPersonal)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("DELETE FROM TituloPersonal WHERE personal = ?");
            stmt.setInt(1, idPersonal);
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public List<TituloPersonal> leerTitulos(String cuil)
    {
        conexion = Conexion.conectar();
        List<TituloPersonal> lista = new ArrayList();
        tituloPersonal = null;
        titulo = null;
        nivel = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT Titulo.Titulo,Nivel.Nivel FROM Personal " +
            "INNER JOIN TituloPersonal ON TituloPersonal.Personal = Personal.idPersonal " +
            "INNER JOIN Titulo ON TituloPersonal.Titulo = Titulo.idTitulo " +
            "INNER JOIN Nivel ON Titulo.Nivel = Nivel.idNivel " +
            "WHERE Personal.cuil = ?");
            stmt.setString(1, cuil);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                tituloPersonal = new TituloPersonal();
                titulo = new Titulo();
                nivel = new Nivel();
                titulo.setTitulo(rs.getString("Titulo.Titulo"));
                nivel.setNivel(rs.getString("Nivel.Nivel"));
                titulo.setNivel(nivel);
                tituloPersonal.setTitulo(titulo);
                lista.add(tituloPersonal);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }
}
