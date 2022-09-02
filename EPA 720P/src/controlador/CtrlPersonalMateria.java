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
import modelo.Aula;
import modelo.Curso;
import modelo.Division;
import modelo.Horario;
import modelo.PersonalMateria;
import modelo.Turno;

/**
 *
 * @author Leonel
 */
public class CtrlPersonalMateria {
    Connection conexion;
    CtrlMateria ctrlMateria = new CtrlMateria();
    CtrlAula ctrlAula = new CtrlAula();
    CtrlCaracter ctrlCaracter = new CtrlCaracter();
    CtrlHorario ctrlHorario = new CtrlHorario();
    PersonalMateria personalMateria = new PersonalMateria();
    Aula aula = new Aula();
    Curso curso = new Curso();
    Division division = new Division();
    Turno turno = new Turno();
    Horario horario = new Horario();
    Boolean crear = true;
    
    public void crearPersonalMateria(PersonalMateria psmt)
    {
        java.sql.Date desde = new java.sql.Date(psmt.getDesde().getTime());
        java.sql.Date hasta = new java.sql.Date(psmt.getHasta().getTime());
        conexion = Conexion.conectar();
        ResultSet rs;
        
        try {
            if(crear == true)
            {
                PreparedStatement stmt = conexion.prepareStatement("INSERT INTO PersonalMateria (personal,materia,caracter,aula,desde,hasta,cupof,observaciones) VALUES (?,?,?,?,?,?,?,?)");
                stmt.setInt(1, psmt.getPersonal().getIdPersonal());
                stmt.setInt(2, psmt.getMateria().getIdMateria());
                stmt.setInt(3, psmt.getCaracter().getIdCaracter());
                stmt.setInt(4, psmt.getAula().getIdAula());
                stmt.setDate(5, desde);
                stmt.setDate(6, hasta);
                stmt.setString(7, psmt.getCupof());
                stmt.setString(8, psmt.getObservaciones());
                stmt.execute();
            }
            
            PreparedStatement stmt = conexion.prepareStatement("SELECT MAX(idPersonalMateria) AS id FROM PersonalMateria");
            rs = stmt.executeQuery();
            rs.next();
            psmt.setIdPersonalMateria(rs.getInt("id"));
            for(int i = 0; psmt.getListaHorarios()!=null && i<psmt.getListaHorarios().size(); i++)
		{
                    horario = new Horario();
                    horario.setPersonalMateria(psmt);
                    horario.setDia(psmt.getListaHorarios().get(i).getDia());
                    horario.setHora(psmt.getListaHorarios().get(i).getHora());
                    Boolean verificar = false;
                    verificar = ctrlHorario.verificarHorario(horario,psmt.getPersonal().getCuil());
                    if(verificar == true)
                    {
                        ctrlHorario.crearHorario(horario);
                        vista.PersonalMateriaHorarioPersonal.limpiar = true;
                    }else{
                        vista.PersonalMateriaHorarioPersonal.limpiar = false;
                        crear = false;
                    }
		}
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void modificarPersonalMateria(PersonalMateria psmt)
    {
        java.sql.Date desde = new java.sql.Date(psmt.getDesde().getTime());
        java.sql.Date hasta = new java.sql.Date(psmt.getHasta().getTime());
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE PersonalMateria SET personal=?,materia=?,caracter=?,aula=?,desde=?,hasta=?,cupof=?,observaciones=? WHERE idPersonalMateria = ?");
            stmt.setInt(1, psmt.getPersonal().getIdPersonal());
            stmt.setInt(2, psmt.getMateria().getIdMateria());
            stmt.setInt(3, psmt.getCaracter().getIdCaracter());
            stmt.setInt(4, psmt.getAula().getIdAula());
            stmt.setDate(5, desde);
            stmt.setDate(6, hasta);
            stmt.setString(7, psmt.getCupof());
            stmt.setString(8, psmt.getObservaciones());
            stmt.setInt(9, psmt.getIdPersonalMateria());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void modificarAulaPersonalMateria(PersonalMateria psmt, int idAula)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE PersonalMateria SET aula=? WHERE idPersonalMateria = ?");
            stmt.setInt(1, idAula);
            stmt.setInt(2, psmt.getIdPersonalMateria());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void modificarMateria(PersonalMateria psmt)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE PersonalMateria SET materia=?, caracter=? WHERE idPersonalMateria = ?");
            stmt.setInt(1, psmt.getMateria().getIdMateria());
            stmt.setInt(2, psmt.getCaracter().getIdCaracter());
            stmt.setInt(3, psmt.getIdPersonalMateria());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void modificarInfoMateria(PersonalMateria psmt)
    {
        java.sql.Date desde = new java.sql.Date(psmt.getDesde().getTime());
        java.sql.Date hasta = new java.sql.Date(psmt.getHasta().getTime());
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE PersonalMateria SET desde=?, hasta=?, cupof=?, observaciones=? WHERE idPersonalMateria = ?");
            stmt.setDate(1, desde);
            stmt.setDate(2, hasta);
            stmt.setString(3, psmt.getCupof());
            stmt.setString(4, psmt.getObservaciones());
            stmt.setInt(5, psmt.getIdPersonalMateria());
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
    
    public void eliminarPersonalMateria(PersonalMateria psmt)
    {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("DELETE FROM Horario WHERE personalMateria = ?");
            stmt.setInt(1, psmt.getIdPersonalMateria());
            stmt.execute();
            stmt = conexion.prepareStatement("DELETE FROM PersonalMateria WHERE idPersonalMateria = ?");
            stmt.setInt(1, psmt.getIdPersonalMateria());
            stmt.execute();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "No se puede eliminar el registro","Error al eliminar",ERROR_MESSAGE);
        }
        Conexion.desconectar(conexion); 
    }
    
    public PersonalMateria leerPersonalMateria(int idPersonal, int idMateria)
    {
        conexion = Conexion.conectar();
        ResultSet rs;
        personalMateria = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT idPersonalMateria FROM PersonalMateria WHERE personal = ? AND materia = ?");
            stmt.setInt(1, idPersonal);
            stmt.setInt(2, idMateria);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                personalMateria = new PersonalMateria();
                personalMateria.setIdPersonalMateria(rs.getInt("idPersonalMateria"));
            }       
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return personalMateria;
    }
    
    public int leerPersonalMateria(String cuil, String materia,int horas)
    {
        conexion = Conexion.conectar();
        ResultSet rs;
        personalMateria = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT idPersonalMateria FROM PersonalMateria " +
            "INNER JOIN Personal ON PersonalMateria.personal = Personal.idPersonal " +
            "INNER JOIN Materia ON PersonalMateria.materia = Materia.idMateria " +
            "WHERE cuil = ? AND Materia.materia = ?");
            stmt.setString(1, cuil);
            stmt.setString(2, materia);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                personalMateria = new PersonalMateria();
                personalMateria.setIdPersonalMateria(rs.getInt("idPersonalMateria"));
                stmt = conexion.prepareStatement("SELECT count(*) FROM horario WHERE personalMateria = ?");
                stmt.setInt(1, personalMateria.getIdPersonalMateria());
                rs = stmt.executeQuery();
                if(rs.next())
                {
                   horas = rs.getInt("count(*)"); 
                }
            }       
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return horas;
    }
    
    public List<PersonalMateria> leerPersonalMateria(String cuil)
    {
        conexion = Conexion.conectar();
        List<PersonalMateria> lista = new ArrayList();
        personalMateria = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT Materia.materia, Materia.año FROM PersonalMateria " +
            "INNER JOIN Materia ON PersonalMateria.materia=idMateria " +
            "INNER JOIN Personal ON personal=idPersonal " +
            "WHERE cuil = ?");
            stmt.setString(1, cuil);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                personalMateria = new PersonalMateria();
                personalMateria.setMateria(ctrlMateria.leerMateria(rs.getString("Materia.materia"), rs.getInt("Materia.año")));
                lista.add(personalMateria);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }
    
    public List<PersonalMateria> leerEspacioCurricular(String cuil)
    {
        conexion = Conexion.conectar();
        List<PersonalMateria> lista = new ArrayList();
        personalMateria = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT PersonalMateria.cupof,Materia.materia,Materia.año,Curso.curso,Division.division,Turno.turno,Caracter.caracter,PersonalMateria.observaciones FROM PersonalMateria " +
            "INNER JOIN Aula ON PersonalMateria.aula = Aula.idAula " +
            "INNER JOIN Personal ON PersonalMateria.personal = Personal.idPersonal " +
            "INNER JOIN Materia ON PersonalMateria.materia = Materia.idMateria " +
            "INNER JOIN Curso ON Aula.curso = Curso.idCurso " +
            "INNER JOIN Division ON Aula.division = Division.idDivision " +
            "INNER JOIN Turno ON Aula.turno = Turno.idTurno " +
            "INNER JOIN Caracter ON PersonalMateria.caracter = Caracter.idCaracter " +
            "WHERE cuil = ?");
            stmt.setString(1, cuil);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                personalMateria = new PersonalMateria();
                personalMateria.setCupof(rs.getString("PersonalMateria.cupof"));
                personalMateria.setMateria(ctrlMateria.leerMateria(rs.getString("Materia.materia"), rs.getInt("Materia.año")));
                aula = new Aula();
                curso = new Curso();
                division = new Division();
                turno = new Turno();
                curso.setCurso(rs.getString("Curso.curso"));
                division.setDivision(rs.getString("Division.division"));
                turno.setTurno(rs.getString("Turno.turno"));
                aula.setCurso(curso);
                aula.setDivision(division);
                aula.setTurno(turno);
                personalMateria.setAula(aula);
                personalMateria.setCaracter(ctrlCaracter.leerCaracter(rs.getString("Caracter.caracter")));
                personalMateria.setObservaciones(rs.getString("PersonalMateria.observaciones"));
                lista.add(personalMateria);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }
    
    public List<PersonalMateria> leerAulasDeMateria(String cuil,String materia)
    {
        conexion = Conexion.conectar();
        List<PersonalMateria> lista = new ArrayList();
        personalMateria = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT aula FROM PersonalMateria " +
            "INNER JOIN Materia ON PersonalMateria.materia = Materia.idMateria " +
            "INNER JOIN Personal ON PersonalMateria.personal = Personal.idPersonal " +
            "WHERE cuil = ? AND Materia.materia = ?");
            stmt.setString(1, cuil);
            stmt.setString(2, materia);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                personalMateria = new PersonalMateria();
                personalMateria.setAula(ctrlAula.leerAula(rs.getInt("aula")));
                lista.add(personalMateria);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }
    
    public PersonalMateria leerAulaDeMateria(String cuil,String materia, int idAula)
    {
        conexion = Conexion.conectar();
        personalMateria = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT idPersonalMateria FROM PersonalMateria " +
            "INNER JOIN Materia ON PersonalMateria.materia = Materia.idMateria " +
            "INNER JOIN Personal ON PersonalMateria.personal = Personal.idPersonal " +
            "WHERE cuil = ? AND Materia.materia = ? AND aula = ?");
            stmt.setString(1, cuil);
            stmt.setString(2, materia);
            stmt.setInt(3, idAula);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                personalMateria = new PersonalMateria();
                personalMateria.setIdPersonalMateria(rs.getInt("idPersonalMateria"));
                
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return personalMateria;
    }
    
    public PersonalMateria leerInfoMateria(String cuil, String materia)
    {
        conexion = Conexion.conectar();
        personalMateria = null;
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT idPersonalMateria,Materia.materia,Materia.año,Caracter.caracter,desde,hasta,cupof,observaciones FROM PersonalMateria " +
            "INNER JOIN Materia ON PersonalMateria.materia = Materia.idMateria " +
            "INNER JOIN Caracter ON PersonalMateria.caracter = Caracter.idCaracter " +
            "INNER JOIN Personal ON PersonalMateria.personal = Personal.idPersonal " +
            "WHERE cuil = ? AND Materia.materia = ?");
            stmt.setString(1, cuil);
            stmt.setString(2, materia);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                personalMateria = new PersonalMateria();
                personalMateria.setIdPersonalMateria(rs.getInt("idPersonalMateria"));
                personalMateria.setMateria(ctrlMateria.leerMateria(rs.getString("Materia.materia"), rs.getInt("Materia.año")));
                personalMateria.setCaracter(ctrlCaracter.leerCaracter(rs.getString("Caracter.caracter")));
                personalMateria.setDesde(rs.getDate("desde"));
                personalMateria.setHasta(rs.getDate("hasta"));
                personalMateria.setCupof(rs.getString("cupof"));
                personalMateria.setObservaciones(rs.getString("observaciones"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return personalMateria;
    }
}
