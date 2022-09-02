/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author acer
 */
public class RegimenEspecial {

    private int idRegimenEspecial;
    private String nombre;
    private boolean borrado;

    public int getIdRegimenEspecial() {
        return idRegimenEspecial;
    }

    public void setIdRegimenEspecial(int idRegimenEspecial) {
        this.idRegimenEspecial = idRegimenEspecial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }   
}
