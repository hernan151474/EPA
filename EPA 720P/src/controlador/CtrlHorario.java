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
import modelo.Horario;
import modelo.PersonalMateria;

/**
 *
 * @author Leonel
 */
public class CtrlHorario {
    Connection conexion;
    Horario horario = new Horario();
    PersonalMateria personalMateria = new PersonalMateria();
    Hora hora = new Hora();
    CtrlHora ctrlHora = new CtrlHora();
    CtrlMateria ctrlMateria = new CtrlMateria();
    public void crearHorario(Horario hrio)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO Horario (personalMateria,dia,hora) VALUES (?,?,?)");
            stmt.setInt(1, hrio.getPersonalMateria().getIdPersonalMateria());
            stmt.setInt(2, hrio.getDia());
            stmt.setInt(3, hrio.getHora().getIdHora());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public Boolean verificarHorario(Horario hrio,String cuil)
    {
        Boolean verificar = false;
        conexion = Conexion.conectar();
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT COUNT(*) FROM Horario \n" +
            "INNER JOIN PersonalMateria ON Horario.personalMateria = PersonalMateria.idPersonalMateria\n" +
            "INNER JOIN Personal ON PersonalMateria.personal = Personal.idPersonal\n" +
            "WHERE cuil = ? AND dia = ? AND hora = ?");
            stmt.setString(1, cuil);
            stmt.setInt(2, hrio.getDia());
            stmt.setInt(3, hrio.getHora().getIdHora());
            rs = stmt.executeQuery();
            if(rs.next())
            {
                if(rs.getInt("COUNT(*)")>0)
                {
                    System.out.println(rs.getInt("COUNT(*)"));
                    JOptionPane.showMessageDialog(null, "Horario ocupado, por favor elija otro");
                    verificar = false; 
                }else{
                    verificar = true;
                }   
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return verificar;
    }
    
    public void modificarHorario(Horario hrio)
    {
       conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Horario SET dia=?,hora=? WHERE idHorario = ?");
            stmt.setInt(1, hrio.getDia());
            stmt.setInt(2, hrio.getHora().getIdHora());
            stmt.setInt(3, hrio.getIdHorario());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion); 
    }
    
    public void eliminarHorario(Horario hrio)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("DELETE FROM Horario WHERE idHorario = ?");
            stmt.setInt(1, hrio.getIdHorario());
            stmt.execute();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "No se puede eliminar el horario","Error al eliminar",ERROR_MESSAGE);
        }
        Conexion.desconectar(conexion); 
    }
    
    public List<Horario> leerHorariosPersonal(String cuil)
    {
        conexion = Conexion.conectar();
        List<Horario> lista = new ArrayList();
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT Materia.materia,Materia.año,Horario.dia,Hora.idHora,Hora.desde,Hora.hasta FROM PersonalMateria " +
            "INNER JOIN Materia ON PersonalMateria.materia = Materia.idMateria " +
            "INNER JOIN Horario ON Horario.personalMateria = PersonalMateria.idPersonalMateria " +
            "INNER JOIN Hora ON Hora.idHora = Horario.hora " +
            "INNER JOIN Personal ON PersonalMateria.personal = Personal.idPersonal " +
            "WHERE cuil = ? ORDER BY dia,desde");
            stmt.setString(1, cuil);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                horario = new Horario();
                personalMateria = new PersonalMateria();
                hora = new Hora();
                personalMateria.setMateria(ctrlMateria.leerMateria(rs.getString("Materia.materia"), rs.getInt("Materia.año")));
                horario.setPersonalMateria(personalMateria);
                hora.setIdHora(rs.getInt("Hora.idHora"));
                //horario.setHora(hora);
                hora.setDesde(rs.getString("Hora.desde"));
                hora.setHasta(rs.getString("Hora.Hasta"));
                horario.setDia(rs.getInt("Horario.dia"));
                //horario.setHora(ctrlHora.leerHora(rs.getString("Hora.desde"), rs.getString("Hora.hasta")));
                horario.setHora(hora);
                lista.add(horario);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion); 
        return lista;
    }
    
    public List<Horario> leerHorariosMateria(String materia,int año, String cuil)
    {
        conexion = Conexion.conectar();
        List<Horario> lista = new ArrayList();
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT Horario.dia,Hora.desde,Hora.hasta FROM PersonalMateria\n" +
            "INNER JOIN Materia ON PersonalMateria.materia = Materia.idMateria\n" +
            "INNER JOIN Horario ON Horario.personalMateria = PersonalMateria.idPersonalMateria\n" +
            "INNER JOIN Hora ON Hora.idHora = Horario.hora\n" +
            "INNER JOIN Personal ON PersonalMateria.personal = Personal.idPersonal\n" +
            "WHERE Materia.materia = ? AND Materia.año = ? AND cuil = ? ORDER BY dia,desde;");
            stmt.setString(1, materia);
            stmt.setInt(2, año);
            stmt.setString(3, cuil);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                horario = new Horario();
                hora = new Hora();
                hora.setDesde(rs.getString("Hora.desde"));
                hora.setHasta(rs.getString("Hora.Hasta"));
                horario.setDia(rs.getInt("Horario.dia"));
                horario.setHora(hora);
                lista.add(horario);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion); 
        return lista;
    }
    
    public Horario leerIdHorario(int dia, int idHora)
    {
        conexion = Conexion.conectar();
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT idHorario FROM Horario WHERE dia = ? AND hora = ?");
            stmt.setInt(1, dia);
            stmt.setInt(2, idHora);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                horario = new Horario();
                horario.setIdHorario(rs.getInt("idHorario"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion); 
        return horario;
    }
}
