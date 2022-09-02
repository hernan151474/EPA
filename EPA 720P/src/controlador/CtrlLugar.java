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
import modelo.Lugar;

/**
 *
 * @author Leonel
 */
public class CtrlLugar {

    Connection conexion;
    Lugar lugar = new Lugar();

    public Lugar leerLugar(int idLugar) {
        conexion = Conexion.conectar();
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT nombre,nivel,de FROM Lugar WHERE idLugar = ?");
            stmt.setInt(1, idLugar);
            rs = stmt.executeQuery();
            if (rs.next()) {
                lugar = new Lugar();
                lugar.setNombre(rs.getString("nombre"));
                lugar.setNivel(rs.getInt("nivel"));
                lugar.setDe(rs.getInt("de"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        return lugar;
    }

    public Lugar leerLugar(String nombreLugar) {
        conexion = Conexion.conectar();
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT idLugar FROM Lugar WHERE nombre = ?");
            stmt.setString(1, nombreLugar);
            rs = stmt.executeQuery();
            if (rs.next()) {
                lugar = new Lugar();
                lugar.setIdLugar(rs.getInt("idLugar"));
                lugar.setNombre(nombreLugar);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        return lugar;
    }

    public List<String> leerTodos(int nvl) {
        conexion = Conexion.conectar();
        List<String> lista = new ArrayList();
        ResultSet rs;

        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT nombre FROM Lugar WHERE nivel = ? ORDER BY nombre");
            stmt.setInt(1, nvl);

            rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(rs.getString("nombre"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al LEER Lugares", "ERROR!!!...", ERROR_MESSAGE);
        }
        Conexion.desconectar(conexion);
        return lista;
    }

    public List<String> leerTodosDe(Lugar lgr) {
        conexion = Conexion.conectar();
        List<String> lista = new ArrayList();
        ResultSet rs;

        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT nombre FROM Lugar WHERE de = ?");
            stmt.setInt(1, lgr.getIdLugar());

            rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(rs.getString("nombre"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al LEER Lugares", "ERROR!!!...", ERROR_MESSAGE);
        }
        Conexion.desconectar(conexion);
        return lista;
    }
//------------------------------------------------------------------------------

    public List<Lugar> leerTodoNacionalidad() {
        conexion = Conexion.conectar();
        List<Lugar> lista = new ArrayList();
        Lugar localidad = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM Lugar WHERE borrado = 0 AND nivel = 6 ORDER BY nombre");
            rs = stmt.executeQuery();
            while (rs.next()) {
                localidad = new Lugar();
                localidad.setIdLugar(rs.getInt("idLugar"));//Agregado mio(Kevin) para poder reutilizar este metodo

                localidad.setNombre(rs.getString("nombre"));
                lista.add(localidad);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }

    public List<Lugar> leerTodoLocalidad() {
        conexion = Conexion.conectar();
        List<Lugar> lista = new ArrayList();
        Lugar localidad = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM Lugar WHERE borrado = 0 AND nivel = 3 ORDER BY nombre");
            rs = stmt.executeQuery();
            while (rs.next()) {
                localidad = new Lugar();
                localidad.setIdLugar(rs.getInt("idLugar"));//Agregado mio(Kevin) para poder reutilizar este metodo

                localidad.setNombre(rs.getString("nombre"));
                lista.add(localidad);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }

    public List<Lugar> leerTodoBarrio(int de) {
        conexion = Conexion.conectar();
        List<Lugar> lista = new ArrayList();
        Lugar barrio = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM Lugar WHERE borrado = 0 AND nivel = 2 AND de = ? ORDER BY nombre");
            stmt.setInt(1, de);
            rs = stmt.executeQuery();
            while (rs.next()) {
                barrio = new Lugar();
                barrio.setIdLugar(rs.getInt("idLugar"));//Agregado mio(Kevin) para poder reutilizar este metodo

                barrio.setNombre(rs.getString("nombre"));
                lista.add(barrio);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }

    public List<Lugar> leerTodoCalle(int de) {
        conexion = Conexion.conectar();
        List<Lugar> lista = new ArrayList();
        Lugar calle = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM Lugar WHERE borrado = 0 AND nivel = 1 AND de = ? ORDER BY nombre");
            stmt.setInt(1, de);
            rs = stmt.executeQuery();
            while (rs.next()) {
                calle = new Lugar();
                calle.setIdLugar(rs.getInt("idLugar"));//Agregado mio(Kevin) para poder reutilizar este metodo

                calle.setNombre(rs.getString("nombre"));
                lista.add(calle);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }

    public Lugar leerId(int de) {
        conexion = Conexion.conectar();
        Lugar calle = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM Lugar WHERE borrado = 0 AND idLugar = ?");
            stmt.setInt(1, de);
            rs = stmt.executeQuery();
            while (rs.next()) {
                calle = new Lugar();
                calle.setIdLugar(de);//Agregado mio(Kevin) para poder reutilizar este metodo

                calle.setNombre(rs.getString("nombre"));
                calle.setNivel(rs.getInt("nivel"));
                calle.setDe(rs.getInt("de"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return calle;
    }

    public Lugar leerNacionalidad() {
        conexion = Conexion.conectar();
        Lugar localidad = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM Lugar WHERE borrado = 0 AND nivel = 6 ORDER BY nombre");
            rs = stmt.executeQuery();
            while (rs.next()) {
                localidad = new Lugar();
                localidad.setIdLugar(rs.getInt("idLugar"));//Agregado mio(Kevin) para poder reutilizar este metodo

                localidad.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return localidad;
    }

    public String extraerNombre(int id) {
        conexion = Conexion.conectar();

        ResultSet rs;
        String nombre = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM Lugar WHERE borrado = 0 AND idLugar = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                nombre = rs.getString("nombre");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return nombre;
    }

}
