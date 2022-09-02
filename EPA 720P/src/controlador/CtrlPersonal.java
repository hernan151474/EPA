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
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import modelo.CargoPersonal;
import modelo.Personal;
import modelo.TituloPersonal;

/**
 *
 * @author Leonel
 */
public class CtrlPersonal {

    Connection conexion;
    CtrlSexo ctrlSexo = new CtrlSexo();
    CtrlEstadoCivil ctrlEstadoCivil = new CtrlEstadoCivil();
    CtrlCargoPersonal ctrlCargoPersonal = new CtrlCargoPersonal();
    CtrlTituloPersonal ctrlTituloPersonal = new CtrlTituloPersonal();
    CtrlNacionalidad ctrlNacionalidad = new CtrlNacionalidad();
    CtrlDomicilio ctrlDomicilio = new CtrlDomicilio();
    Personal personal = new Personal();
    CargoPersonal cargoPersonal = new CargoPersonal();
    TituloPersonal tituloPersonal = new TituloPersonal();

    public void crearPersonal(Personal psnl) {
        java.sql.Date fecha = new java.sql.Date(psnl.getFechaNacimiento().getTime());
        java.sql.Date fecha2 = new java.sql.Date(psnl.getFechaAlta().getTime());
        conexion = Conexion.conectar();
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO Personal (cuil,apellido,nombre,fechaNacimiento,sexo,estadoCivil,hijos,foto,telefonoCelular,email,domicilio,legajo,fechaAlta) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, psnl.getCuil());
            stmt.setString(2, psnl.getApellido());
            stmt.setString(3, psnl.getNombre());
            stmt.setDate(4, fecha);
            stmt.setInt(5, psnl.getSexo().getIdSexo());
            stmt.setInt(6, psnl.getEstadoCivil().getIdEstadoCivil());
            stmt.setInt(7, psnl.getHijos());
            stmt.setBytes(8, psnl.getFoto());
            stmt.setString(9, psnl.getTelefonoCelular());
            stmt.setString(10, psnl.getEmail());
            stmt.setInt(11, psnl.getDomicilio().getIdDomicilio());
            stmt.setString(12, psnl.getLegajo());
            stmt.setDate(13, fecha2);
            stmt.execute();
            stmt = conexion.prepareStatement("SELECT MAX(idPersonal) AS id FROM Personal");

            rs = stmt.executeQuery();
            rs.next();

            psnl.setIdPersonal(rs.getInt("id"));

            for (int i = 0; i < psnl.getListaCargosPersonales().size(); i++) {
                cargoPersonal = new CargoPersonal();
                cargoPersonal.setPersonal(psnl);
                cargoPersonal.setCargo(psnl.getListaCargosPersonales().get(i).getCargo());
                cargoPersonal.setRevista(psnl.getListaCargosPersonales().get(i).getRevista());
                cargoPersonal.setDesde(psnl.getListaCargosPersonales().get(i).getDesde());
                cargoPersonal.setHasta(psnl.getListaCargosPersonales().get(i).getHasta());
                ctrlCargoPersonal.crearCargoPersonal(cargoPersonal);
            }

            for (int i = 0; i < psnl.getListaTitulosPersonales().size(); i++) {
                tituloPersonal = new TituloPersonal();
                tituloPersonal.setPersonal(psnl);
                tituloPersonal.setTitulo(psnl.getListaTitulosPersonales().get(i).getTitulo());
                ctrlTituloPersonal.crearTituloPersonal(tituloPersonal);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public void modificarPersonal(Personal psnl) {
        java.sql.Date fecha = new java.sql.Date(psnl.getFechaNacimiento().getTime());
        java.sql.Date fecha2 = new java.sql.Date(psnl.getFechaAlta().getTime());
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Personal SET cuil=?,apellido=?,nombre=?,fechaNacimiento=?,sexo=?,estadoCivil=?,hijos=?,foto=?,telefonoCelular=?,email=?,nacionalidad=?,domicilio=?,legajo=?,fechaAlta=? WHERE idPersonal = ?");
            stmt.setString(1, psnl.getCuil());
            stmt.setString(2, psnl.getApellido());
            stmt.setString(3, psnl.getNombre());
            stmt.setDate(4, fecha);
            stmt.setInt(5, psnl.getSexo().getIdSexo());
            stmt.setInt(6, psnl.getEstadoCivil().getIdEstadoCivil());
            stmt.setInt(7, psnl.getHijos());
            stmt.setBytes(8, psnl.getFoto());
            stmt.setString(9, psnl.getTelefonoCelular());
            stmt.setString(10, psnl.getEmail());
            stmt.setInt(11, psnl.getNacionalidad().getIdLugar());
            //stmt.setInt(11, psnl.getNacionalidad().getIdNacionalidad());//modifcar
            stmt.setInt(12, psnl.getDomicilio().getIdDomicilio());
            stmt.setString(13, psnl.getLegajo());
            stmt.setDate(14, fecha2);
            stmt.setInt(15, psnl.getIdPersonal());
            stmt.execute();
            for (int i = 0; i < psnl.getListaCargosPersonales().size(); i++) {
                cargoPersonal = new CargoPersonal();
                cargoPersonal.setPersonal(psnl);
                cargoPersonal.setCargo(psnl.getListaCargosPersonales().get(i).getCargo());
                cargoPersonal.setRevista(psnl.getListaCargosPersonales().get(i).getRevista());
                cargoPersonal.setDesde(psnl.getListaCargosPersonales().get(i).getDesde());
                cargoPersonal.setHasta(psnl.getListaCargosPersonales().get(i).getHasta());
                ctrlCargoPersonal.crearCargoPersonal(cargoPersonal);
            }

            for (int i = 0; i < psnl.getListaTitulosPersonales().size(); i++) {
                tituloPersonal = new TituloPersonal();
                tituloPersonal.setPersonal(psnl);
                tituloPersonal.setTitulo(psnl.getListaTitulosPersonales().get(i).getTitulo());
                ctrlTituloPersonal.crearTituloPersonal(tituloPersonal);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public void eliminarPersonal(Personal psnl) {
        conexion = Conexion.conectar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Personal SET borrado = 1 WHERE idPersonal = ?");
            stmt.setInt(1, psnl.getIdPersonal());
            stmt.execute();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "No se puede eliminar el personal", "Error al eliminar", ERROR_MESSAGE);
        }
        Conexion.desconectar(conexion);
    }

    public Personal leerPersonal(String cuil) {
        conexion = Conexion.conectar();
        ResultSet rs;
        personal = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM Personal WHERE cuil = ?");
            stmt.setString(1, cuil);
            rs = stmt.executeQuery();
            if (rs.next()) {
                personal = new Personal();
                personal.setIdPersonal(rs.getInt("idPersonal"));
                personal.setCuil(cuil);
                personal.setApellido(rs.getString("apellido"));
                personal.setNombre(rs.getString("nombre"));
                personal.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                personal.setSexo(ctrlSexo.leerSexo(rs.getInt("sexo")));
                personal.setEstadoCivil(ctrlEstadoCivil.leerEstadoCivil(rs.getInt("estadoCivil")));
                personal.setHijos(rs.getInt("hijos"));
                personal.setFoto(rs.getBytes("foto"));
                personal.setTelefonoCelular(rs.getString("telefonoCelular"));
                personal.setEmail(rs.getString("email"));
                personal.setDomicilio(ctrlDomicilio.leerDomicilio(rs.getInt("domicilio")));
                personal.setLegajo(rs.getString("legajo"));
                personal.setFechaAlta(rs.getDate("fechaAlta"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return personal;
    }
    //---------------------------------------------------------------------------

    public Personal leerPersonal(int Id) {
        conexion = Conexion.conectar();
        ResultSet rs;
        personal = null;
        CtrlDomicilio ctrlDomicilio = new CtrlDomicilio();
        CtrlLugar ctrlLugar = new CtrlLugar();
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM Personal WHERE idPersonal = ?");
            stmt.setInt(1, Id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                personal = new Personal();
                personal.setIdPersonal(Id);
                personal.setCuil(rs.getString("cuil"));
                personal.setApellido(rs.getString("apellido"));
                personal.setNombre(rs.getString("nombre"));
                personal.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                personal.setSexo(ctrlSexo.leerSexo(rs.getInt("sexo")));
                personal.setEstadoCivil(ctrlEstadoCivil.leerEstadoCivil(rs.getInt("estadoCivil")));
                personal.setHijos(rs.getInt("hijos"));
                personal.setFoto(rs.getBytes("foto"));
                personal.setTelefonoCelular(rs.getString("telefonoCelular"));
                personal.setEmail(rs.getString("email"));
                personal.setDomicilio(ctrlDomicilio.leerId(rs.getInt("domicilio")));

                personal.setNacionalidad(ctrlLugar.leerId(rs.getInt("nacionalidad")));
                personal.setLegajo(rs.getString("legajo"));
                personal.setFechaAlta(rs.getDate("fechaAlta"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return personal;
    }
    
       //-----------------------------------------------------------------------------
    //Metodos Para Alumnos

    public void crearAlumno(Personal psnl) {
        java.sql.Date fecha = new java.sql.Date(psnl.getFechaNacimiento().getTime());
        java.sql.Date fecha2 = new java.sql.Date(psnl.getFechaAlta().getTime());
        conexion = Conexion.conectar();
        ResultSet rs;
        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO Personal "
                    + "(cuil, apellido, nombre, fechaNacimiento, sexo, "
                    + "estadoCivil, hijos, foto, telefonoCelular, email, nacionalidad, "
                    + "domicilio, legajo, fechaAlta, borrado) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, false)");
            stmt.setString(1, psnl.getCuil());
            stmt.setString(2, psnl.getApellido());
            stmt.setString(3, psnl.getNombre());
            stmt.setDate(4, fecha);
            stmt.setInt(5, psnl.getSexo().getIdSexo());
            stmt.setInt(6, psnl.getEstadoCivil().getIdEstadoCivil());
            stmt.setInt(7, psnl.getHijos());
            stmt.setBytes(8, psnl.getFoto());
            stmt.setString(9, psnl.getTelefonoCelular());
            stmt.setString(10, psnl.getEmail());
            stmt.setInt(11, psnl.getNacionalidad().getIdLugar());
            stmt.setInt(12, psnl.getDomicilio().getIdDomicilio());
            stmt.setString(13, psnl.getLegajo());
            stmt.setDate(14, fecha2);
            stmt.execute();
//------------------------------------------------------------------------------            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public int leerUltimoRegCargado() {
        conexion = Conexion.conectar();
        ResultSet rs;
        PreparedStatement stmt;
        personal = null;
        try {
            stmt = conexion.prepareStatement("SELECT MAX(idPersonal) "
                    + "AS id FROM Personal");

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


    public void modificarAlumno(Personal psnl) {
        java.sql.Date fecha = new java.sql.Date(psnl.getFechaNacimiento().getTime());
        java.sql.Date fecha2 = new java.sql.Date(psnl.getFechaAlta().getTime());
        conexion = Conexion.conectar();
        ResultSet rs;
        System.err.println(psnl.getDomicilio().getIdDomicilio());
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Personal SET "
                    + "cuil= ?, apellido= ?, nombre= ?, fechaNacimiento= ?, sexo= ?, "
                    + "estadoCivil= ?, hijos= ?, foto= ?, telefonoCelular= ?, email= ?, "
                    + "nacionalidad= ?, domicilio= ?, legajo= ? WHERE idPersonal = ?");
            stmt.setString(1, psnl.getCuil());
            stmt.setString(2, psnl.getApellido());
            stmt.setString(3, psnl.getNombre());
            stmt.setDate(4, fecha);
            stmt.setInt(5, psnl.getSexo().getIdSexo());
            stmt.setInt(6, psnl.getEstadoCivil().getIdEstadoCivil());
            stmt.setInt(7, psnl.getHijos());
            stmt.setBytes(8, psnl.getFoto());
            stmt.setString(9, psnl.getTelefonoCelular());
            stmt.setString(10, psnl.getEmail());
            stmt.setInt(11, psnl.getNacionalidad().getIdLugar());
            stmt.setInt(12, psnl.getDomicilio().getIdDomicilio());
            stmt.setString(13, psnl.getLegajo());
            stmt.setInt(14, psnl.getIdPersonal());
            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }
}
