/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Leonel
 */
public class PersonalMateria {
    private int idPersonalMateria;
    private Personal personal;
    private Materia materia;
    private Caracter caracter;
    private Aula aula;
    private Date desde;
    private Date hasta;
    private String cupof;
    private String observaciones;
    private List<Horario> listaHorarios;

    public int getIdPersonalMateria() {
        return idPersonalMateria;
    }

    public void setIdPersonalMateria(int PersonalMateria) {
        this.idPersonalMateria = PersonalMateria;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Caracter getCaracter() {
        return caracter;
    }

    public void setCaracter(Caracter caracter) {
        this.caracter = caracter;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    public String getCupof() {
        return cupof;
    }

    public void setCupof(String cupof) {
        this.cupof = cupof;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<Horario> getListaHorarios() {
        return listaHorarios;
    }

    public void setListaHorarios(List<Horario> listaHorarios) {
        this.listaHorarios = listaHorarios;
    }
            
}
