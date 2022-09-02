/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author acer
 */
public class AlumnoSancion {

    private int idAlumnoSancion;
    private Alumno alumno;
    private Sancion sancion;
    private int cantidad;
    private Date fecha;
    private String observacion;

    public int getIdAlumnoSancion() {
        return idAlumnoSancion;
    }

    public void setIdAlumnoSancion(int idAlumnoSancion) {
        this.idAlumnoSancion = idAlumnoSancion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Sancion getSancion() {
        return sancion;
    }

    public void setSancion(Sancion sancion) {
        this.sancion = sancion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

}
