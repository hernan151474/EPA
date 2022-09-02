/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Leonel
 */
public class CargoPersonal {
    private int idCargoPersonal;
    private Personal personal;
    private Cargo cargo;
    private Revista revista;
    private Date desde;
    private Date hasta;

    public int getIdCargoPersonal() {
        return idCargoPersonal;
    }

    public void setIdCargoPersonal(int idCargoPersonal) {
        this.idCargoPersonal = idCargoPersonal;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Revista getRevista() {
        return revista;
    }

    public void setRevista(Revista revista) {
        this.revista = revista;
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
    
}
