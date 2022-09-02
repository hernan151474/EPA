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
public class PlanSocial implements Comparable<PlanSocial>{

    private int idPlanSocial;
    private String nombre;
    private boolean borrado;

    public int getIdPlanSocial() {
        return idPlanSocial;
    }

    public void setIdPlanSocial(int idPlanSocial) {
        this.idPlanSocial = idPlanSocial;
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

    @Override
    public int compareTo(PlanSocial t) {
        return nombre.compareTo(t.getNombre());
    }

}
