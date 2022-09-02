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
import modelo.Alumno;
import modelo.Personal;

/**
 *
 * @author acer
 */
public class CtrlAlumno {

    Connection conexion;

    public void crear(Alumno alm) {
        conexion = Conexion.conectar();

        PreparedStatement stmt;
        try {
            stmt = conexion.prepareStatement("INSERT INTO Alumno "
                    + "(personal, estado, localidad, "
                    + "interCulturalidad, regimenEspecial, transporte, servicioAlimentarioEscolar, "
                    + "desayunoMeriendaCompleta, desayuno, comedorSimple, cena, "
                    + "almuerzo, merienda, docenteIntegrador, nivelTutor, discapacidad, "
                    + "ceguera, sordera, motoraPuraIntelectual, hipoacusia, neuromotora, "
                    + "trastornoEspectroAutista, disminucionVisual, otroDiscapacidad) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)");
            stmt.setInt(1, alm.getPersonal().getIdPersonal());
            stmt.setInt(2, alm.getEstado().getIdEstado());
            stmt.setInt(3, alm.getLocalidad().getIdLugar());
            stmt.setInt(4, alm.getInterCulturalidad().getIdCargoPersonal());
            stmt.setInt(5, alm.getRegimenEspecial().getIdRegimenEspecial());
            stmt.setInt(6, alm.getTransporte());
            stmt.setInt(7, alm.getServicioAlimentarioEscolar());
            stmt.setBoolean(8, alm.isDesayunoMeriendaCompleta());
            stmt.setBoolean(9, alm.isDesayuno());
            stmt.setBoolean(10, alm.isComedorSimple());
            stmt.setBoolean(11, alm.isCena());
            stmt.setBoolean(12, alm.isAlmuerzo());
            stmt.setBoolean(13, alm.isMerienda());
            stmt.setInt(14, alm.getDocenteIntegrador());
            stmt.setInt(15, alm.getNivelTutor());
            stmt.setInt(16, alm.getDiscapacidad());
            stmt.setBoolean(17, alm.isCeguera());
            stmt.setBoolean(18, alm.isSordera());
            stmt.setBoolean(19, alm.isMotoraPuraIntelectual());
            stmt.setBoolean(20, alm.isHipoacusia());
            stmt.setBoolean(21, alm.isNeuromotora());
            stmt.setBoolean(22, alm.isTrastornoEspectroAutista());
            stmt.setBoolean(23, alm.isDisminucionVisual());
            stmt.setString(24, alm.getOtroDiscapacidad());

            stmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public void modificar(Alumno alm) {
        conexion = Conexion.conectar();

        PreparedStatement stmt;
        try {
            stmt = conexion.prepareStatement("UPDATE Alumno SET "
                    + "personal  = ?, estado  = ?, localidad  = ?, "
                    + "interCulturalidad  = ?, regimenEspecial  = ?, transporte  = ?, servicioAlimentarioEscolar  = ?, "
                    + "desayunoMeriendaCompleta  = ?, desayuno  = ?, comedorSimple  = ?, cena  = ?, "
                    + "almuerzo  = ?, merienda  = ?, docenteIntegrador  = ?, nivelTutor  = ?, discapacidad  = ?, "
                    + "ceguera  = ?, sordera  = ?, motoraPuraIntelectual  = ?, hipoacusia  = ?, neuromotora  = ?, "
                    + "trastornoEspectroAutista  = ?, disminucionVisual  = ?, otroDiscapacidad = ?"
                    + "WHERE idAlumno = ?");
            stmt.setInt(1, alm.getPersonal().getIdPersonal());
            stmt.setInt(2, alm.getEstado().getIdEstado());
            stmt.setInt(3, alm.getLocalidad().getIdLugar());
            stmt.setInt(4, alm.getInterCulturalidad().getIdCargoPersonal());
            stmt.setInt(5, alm.getRegimenEspecial().getIdRegimenEspecial());
            stmt.setInt(6, alm.getTransporte());
            stmt.setInt(7, alm.getServicioAlimentarioEscolar());
            stmt.setBoolean(8, alm.isDesayunoMeriendaCompleta());
            stmt.setBoolean(9, alm.isDesayuno());
            stmt.setBoolean(10, alm.isComedorSimple());
            stmt.setBoolean(11, alm.isCena());
            stmt.setBoolean(12, alm.isAlmuerzo());
            stmt.setBoolean(13, alm.isMerienda());
            stmt.setInt(14, alm.getDocenteIntegrador());
            stmt.setInt(15, alm.getNivelTutor());
            stmt.setInt(16, alm.getDiscapacidad());
            stmt.setBoolean(17, alm.isCeguera());
            stmt.setBoolean(18, alm.isSordera());
            stmt.setBoolean(19, alm.isMotoraPuraIntelectual());
            stmt.setBoolean(20, alm.isHipoacusia());
            stmt.setBoolean(21, alm.isNeuromotora());
            stmt.setBoolean(22, alm.isTrastornoEspectroAutista());
            stmt.setBoolean(23, alm.isDisminucionVisual());
            stmt.setString(24, alm.getOtroDiscapacidad());
            stmt.setInt(25, alm.getIdAlumno());
            stmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public void eliminar(int idAlumno) {
        conexion = Conexion.conectar();

        PreparedStatement stmt;
        try {
            stmt = conexion.prepareStatement("DELETE FROM Alumno WHERE idAlumno = ?");
            stmt.setInt(1, idAlumno);
            stmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
    }

    public Alumno leer(String cuil) {
        Alumno alm = null;
        Personal prl = null;
        conexion = Conexion.conectar();

        PreparedStatement stmt;
        ResultSet rs = null;
        CtrlPersonal ctrlPersonal = new CtrlPersonal();
        CtrlLugar ctrlLugar = new CtrlLugar();
        CtrlComunidad ctrlComunidad = new CtrlComunidad();
        CtrlRegimenEspecial ctrlRegimenEspecial = new CtrlRegimenEspecial();
        CtrlEstado ctrlEstado = new CtrlEstado();

        try {
            stmt = conexion.prepareStatement("SELECT * FROM Alumno "
                    + "INNER JOIN epa.Personal ON Alumno.personal = Personal.idPersonal "
                    + "WHERE Personal.cuil = ?");
            stmt.setString(1, cuil);
            rs = stmt.executeQuery();
            if (rs.next()) {
                alm = new Alumno();
                prl = new Personal();
                prl = ctrlPersonal.leerPersonal(rs.getInt("Personal.idPersonal"));
                alm.setIdAlumno(rs.getInt("Alumno.idAlumno"));
                alm.setPersonal(prl);
                alm.setEstado(ctrlEstado.leer(rs.getInt("Alumno.estado")));
                alm.setLocalidad(ctrlLugar.leerId(rs.getInt("Alumno.localidad")));
                alm.setInterCulturalidad(ctrlComunidad.leerId(rs.getInt("Alumno.interCulturalidad")));
                alm.setRegimenEspecial(ctrlRegimenEspecial.leerId(rs.getInt("Alumno.regimenEspecial")));
                alm.setTransporte(rs.getInt("Alumno.transporte"));
                alm.setServicioAlimentarioEscolar(rs.getInt("Alumno.servicioAlimentarioEscolar"));
                alm.setDesayunoMeriendaCompleta(rs.getBoolean("Alumno.desayunoMeriendaCompleta"));
                alm.setDesayuno(rs.getBoolean("Alumno.desayuno"));
                alm.setComedorSimple(rs.getBoolean("Alumno.comedorSimple"));
                alm.setCena(rs.getBoolean("Alumno.cena"));
                alm.setAlmuerzo(rs.getBoolean("Alumno.almuerzo"));
                alm.setMerienda(rs.getBoolean("Alumno.merienda"));
                alm.setDocenteIntegrador(rs.getInt("Alumno.docenteIntegrador"));
                alm.setNivelTutor(rs.getInt("Alumno.nivelTutor"));
                alm.setDiscapacidad(rs.getInt("Alumno.discapacidad"));
                alm.setCeguera(rs.getBoolean("Alumno.ceguera"));
                alm.setSordera(rs.getBoolean("Alumno.sordera"));
                alm.setMotoraPuraIntelectual(rs.getBoolean("Alumno.motoraPuraIntelectual"));
                alm.setHipoacusia(rs.getBoolean("Alumno.hipoacusia"));
                alm.setNeuromotora(rs.getBoolean("Alumno.neuromotora"));
                alm.setTrastornoEspectroAutista(rs.getBoolean("Alumno.trastornoEspectroAutista"));
                alm.setDisminucionVisual(rs.getBoolean("Alumno.disminucionVisual"));
                if (rs.getString("Alumno.otroDiscapacidad") == null) {
                    alm.setOtroDiscapacidad("");
                } else {
                    alm.setOtroDiscapacidad(rs.getString("Alumno.otroDiscapacidad"));
                }

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return alm;
    }

    public Alumno leer(int id) {
        Alumno alm = null;
        Personal prl = null;
        conexion = Conexion.conectar();

        PreparedStatement stmt;
        ResultSet rs = null;
        try {
            stmt = conexion.prepareStatement("SELECT * FROM Alumno "
                    + "INNER JOIN epa.Personal ON Alumno.personal = Personal.idPersonal "
                    + "WHERE Alumno.idAlumno = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                alm = new Alumno();
                prl = new Personal();
                prl.setLegajo(rs.getString("Personal.legajo"));
                prl.setIdPersonal(rs.getInt("Personal.idPersonal"));
                prl.setApellido(rs.getString("Personal.apellido"));
                prl.setNombre(rs.getString("Personal.nombre"));
//                prl.setDomicilio(rs.getString("Personal.domicilio"));//No funciona aun
                alm.setIdAlumno(rs.getInt("Alumno.idAlumno"));
                alm.setPersonal(prl);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return alm;
    }

    public int leerUltimoRegCargado() {
        conexion = Conexion.conectar();
        ResultSet rs;
        PreparedStatement stmt;

        try {
            stmt = conexion.prepareStatement("SELECT MAX(idAlumno) "
                    + "AS id FROM Alumno");

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

    public List<Alumno> leerTodos() {
        Alumno alm = null;
        Personal prl = null;
        List<Alumno> lista = new ArrayList();
        conexion = Conexion.conectar();

        PreparedStatement stmt;
        ResultSet rs = null;
        CtrlPersonal ctrlPersonal = new CtrlPersonal();
        CtrlLugar ctrlLugar = new CtrlLugar();
        CtrlComunidad ctrlComunidad = new CtrlComunidad();
        CtrlRegimenEspecial ctrlRegimenEspecial = new CtrlRegimenEspecial();
        CtrlEstado ctrlEstado = new CtrlEstado();

        try {
            stmt = conexion.prepareStatement("SELECT * FROM Alumno "
                    + "INNER JOIN epa.Personal ON Alumno.personal = Personal.idPersonal "
                    + "ORDER BY personal.apellido");

            rs = stmt.executeQuery();
            while (rs.next()) {
                alm = new Alumno();
                prl = new Personal();
                prl = ctrlPersonal.leerPersonal(rs.getInt("Personal.idPersonal"));

                alm.setIdAlumno(rs.getInt("Alumno.idAlumno"));

                alm.setPersonal(prl);
                alm.setEstado(ctrlEstado.leer(rs.getInt("Alumno.estado")));
                alm.setLocalidad(ctrlLugar.leerId(rs.getInt("Alumno.localidad")));
                alm.setInterCulturalidad(ctrlComunidad.leerId(rs.getInt("Alumno.interCulturalidad")));
                alm.setRegimenEspecial(ctrlRegimenEspecial.leerId(rs.getInt("Alumno.regimenEspecial")));
                alm.setTransporte(rs.getInt("Alumno.transporte"));
                alm.setServicioAlimentarioEscolar(rs.getInt("Alumno.servicioAlimentarioEscolar"));
                alm.setDesayunoMeriendaCompleta(rs.getBoolean("Alumno.desayunoMeriendaCompleta"));
                alm.setDesayuno(rs.getBoolean("Alumno.desayuno"));
                alm.setComedorSimple(rs.getBoolean("Alumno.comedorSimple"));
                alm.setCena(rs.getBoolean("Alumno.cena"));
                alm.setAlmuerzo(rs.getBoolean("Alumno.almuerzo"));
                alm.setMerienda(rs.getBoolean("Alumno.merienda"));
                alm.setDocenteIntegrador(rs.getInt("Alumno.docenteIntegrador"));
                alm.setNivelTutor(rs.getInt("Alumno.nivelTutor"));
                alm.setDiscapacidad(rs.getInt("Alumno.discapacidad"));
                alm.setCeguera(rs.getBoolean("Alumno.ceguera"));
                alm.setSordera(rs.getBoolean("Alumno.sordera"));
                alm.setMotoraPuraIntelectual(rs.getBoolean("Alumno.motoraPuraIntelectual"));
                alm.setHipoacusia(rs.getBoolean("Alumno.hipoacusia"));
                alm.setNeuromotora(rs.getBoolean("Alumno.neuromotora"));
                alm.setTrastornoEspectroAutista(rs.getBoolean("Alumno.trastornoEspectroAutista"));
                alm.setDisminucionVisual(rs.getBoolean("Alumno.disminucionVisual"));
                if (rs.getString("Alumno.otroDiscapacidad") == null) {
                    alm.setOtroDiscapacidad("");
                } else {
                    alm.setOtroDiscapacidad(rs.getString("Alumno.otroDiscapacidad"));
                }
                lista.add(alm);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }

    public List<Alumno> leerTodos(String buscar, int codigo) {
        Alumno alm = null;
        Personal prl = null;
        List<Alumno> lista = new ArrayList();
        conexion = Conexion.conectar();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        CtrlPersonal ctrlPersonal = new CtrlPersonal();
        CtrlLugar ctrlLugar = new CtrlLugar();
        CtrlComunidad ctrlComunidad = new CtrlComunidad();
        CtrlRegimenEspecial ctrlRegimenEspecial = new CtrlRegimenEspecial();
        CtrlEstado ctrlEstado = new CtrlEstado();

        try {

            switch (codigo) {
                case 0: {
                    stmt = conexion.prepareStatement("SELECT * FROM Alumno "
                    + "INNER JOIN epa.Personal ON Alumno.personal = Personal.idPersonal "
                    + "WHERE personal.legajo like '" + buscar + "%' "
                    + "ORDER BY personal.apellido");
                    break;
                }
                case 1: {
                    stmt = conexion.prepareStatement("SELECT * FROM Alumno "
                    + "INNER JOIN epa.Personal ON Alumno.personal = Personal.idPersonal "
                    + "WHERE personal.cuil like '" + buscar + "%' "
                    + "ORDER BY personal.apellido");
                    break;
                }
                case 2: {
                    stmt = conexion.prepareStatement("SELECT * FROM Alumno "
                    + "INNER JOIN epa.Personal ON Alumno.personal = Personal.idPersonal "
                    + "WHERE personal.apellido like '" + buscar + "%' "
                    + "ORDER BY personal.apellido");
                    break;
                }
            }
            

            rs = stmt.executeQuery();
            while (rs.next()) {
                alm = new Alumno();
                prl = new Personal();
                prl = ctrlPersonal.leerPersonal(rs.getInt("Personal.idPersonal"));

                alm.setIdAlumno(rs.getInt("Alumno.idAlumno"));

                alm.setPersonal(prl);
                alm.setEstado(ctrlEstado.leer(rs.getInt("Alumno.estado")));
                alm.setLocalidad(ctrlLugar.leerId(rs.getInt("Alumno.localidad")));
                alm.setInterCulturalidad(ctrlComunidad.leerId(rs.getInt("Alumno.interCulturalidad")));
                alm.setRegimenEspecial(ctrlRegimenEspecial.leerId(rs.getInt("Alumno.regimenEspecial")));
                alm.setTransporte(rs.getInt("Alumno.transporte"));
                alm.setServicioAlimentarioEscolar(rs.getInt("Alumno.servicioAlimentarioEscolar"));
                alm.setDesayunoMeriendaCompleta(rs.getBoolean("Alumno.desayunoMeriendaCompleta"));
                alm.setDesayuno(rs.getBoolean("Alumno.desayuno"));
                alm.setComedorSimple(rs.getBoolean("Alumno.comedorSimple"));
                alm.setCena(rs.getBoolean("Alumno.cena"));
                alm.setAlmuerzo(rs.getBoolean("Alumno.almuerzo"));
                alm.setMerienda(rs.getBoolean("Alumno.merienda"));
                alm.setDocenteIntegrador(rs.getInt("Alumno.docenteIntegrador"));
                alm.setNivelTutor(rs.getInt("Alumno.nivelTutor"));
                alm.setDiscapacidad(rs.getInt("Alumno.discapacidad"));
                alm.setCeguera(rs.getBoolean("Alumno.ceguera"));
                alm.setSordera(rs.getBoolean("Alumno.sordera"));
                alm.setMotoraPuraIntelectual(rs.getBoolean("Alumno.motoraPuraIntelectual"));
                alm.setHipoacusia(rs.getBoolean("Alumno.hipoacusia"));
                alm.setNeuromotora(rs.getBoolean("Alumno.neuromotora"));
                alm.setTrastornoEspectroAutista(rs.getBoolean("Alumno.trastornoEspectroAutista"));
                alm.setDisminucionVisual(rs.getBoolean("Alumno.disminucionVisual"));
                if (rs.getString("Alumno.otroDiscapacidad") == null) {
                    alm.setOtroDiscapacidad("");
                } else {
                    alm.setOtroDiscapacidad(rs.getString("Alumno.otroDiscapacidad"));
                }
                lista.add(alm);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        Conexion.desconectar(conexion);
        return lista;
    }
    
    //-------------------------------------------------------------------------
    
}
