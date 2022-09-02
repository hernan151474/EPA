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
public class Personal {
    private int idPersonal;
    private String cuil;
    private String apellido;
    private String nombre;
    private Date fechaNacimiento;
    private Sexo sexo;
    private EstadoCivil estadoCivil;
    private int hijos;
    private byte[] foto;
    private String telefonoCelular;
    private String email;
    private Lugar nacionalidad;
    private Domicilio domicilio;
    private String legajo;
    private Date fechaAlta;
    private List<CargoPersonal> listaCargosPersonales;
    private List<TituloPersonal> listaTitulosPersonales;

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public int getHijos() {
        return hijos;
    }

    public void setHijos(int hijos) {
        this.hijos = hijos;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Lugar getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Lugar nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public List<CargoPersonal> getListaCargosPersonales() {
        return listaCargosPersonales;
    }

    public void setListaCargosPersonales(List<CargoPersonal> listaCargosPersonales) {
        this.listaCargosPersonales = listaCargosPersonales;
    }

    public List<TituloPersonal> getListaTitulosPersonales() {
        return listaTitulosPersonales;
    }

    public void setListaTitulosPersonales(List<TituloPersonal> listaTitulosPersonales) {
        this.listaTitulosPersonales = listaTitulosPersonales;
    }
    
}
