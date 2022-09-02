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
public class Notas {
   private int idNota;
   private AlumnoMateria alumnoMateria;
   private float nota;
   private Date fecha;

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public AlumnoMateria getAlumnoMateria() {
        return alumnoMateria;
    }

    public void setAlumnoMateria(AlumnoMateria alumnoMateria) {
        this.alumnoMateria = alumnoMateria;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
   
}
