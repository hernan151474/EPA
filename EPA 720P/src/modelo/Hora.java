/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Time;

/**
 *
 * @author Leonel
 */
public class Hora {
    private int idHora;
    private String desde;
    private String hasta;

    public int getIdHora() {
        return idHora;
    }

    public void setIdHora(int idHoras) {
        this.idHora = idHoras;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }
    
}
