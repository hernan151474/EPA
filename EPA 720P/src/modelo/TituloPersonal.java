/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Leonel
 */
public class TituloPersonal {
    private int idTituloPersonal;
    private Personal personal;
    private Titulo titulo;

    public int getIdTituloPersonal() {
        return idTituloPersonal;
    }

    public void setIdTituloPersonal(int idTituloPersonal) {
        this.idTituloPersonal = idTituloPersonal;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }
    
}
