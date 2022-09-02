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
public class PlanSocialAlumno {

    private int idPlanSocialAlumno;
    private Alumno alumno;
    private PlanSocial planSocial;

    public int getIdPlanSocialAlumno() {
        return idPlanSocialAlumno;
    }

    public void setIdPlanSocialAlumno(int idPlanSocialAlumno) {
        this.idPlanSocialAlumno = idPlanSocialAlumno;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public PlanSocial getPlanSocial() {
        return planSocial;
    }

    public void setPlanSocial(PlanSocial planSocial) {
        this.planSocial = planSocial;
    }

}
