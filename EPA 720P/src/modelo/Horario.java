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
public class Horario {
    private int idHorario;
    private PersonalMateria personalMateria;
    private Hora hora;
    private int dia;

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public PersonalMateria getPersonalMateria() {
        return personalMateria;
    }

    public void setPersonalMateria(PersonalMateria personalMateria) {
        this.personalMateria = personalMateria;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
    
}
