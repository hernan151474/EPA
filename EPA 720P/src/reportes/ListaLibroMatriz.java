/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

/**
 *
 * @author acer
 */
public class ListaLibroMatriz {

    private int anioCurso;
    private String espacioCurricular;
    private float nota;
    private String condicion;

    private String mes;
    private int anio;

    public ListaLibroMatriz(int anioCurso, String espacioCurricular, float nota, String condicion, String mes, int anio) {
        this.anioCurso = anioCurso;
        this.espacioCurricular = espacioCurricular;
        this.nota = nota;
        this.condicion = condicion;
        this.mes = mes;
        this.anio = anio;
    }

    public int getAnioCurso() {
        return anioCurso;
    }

    public void setAnioCurso(int anioCurso) {
        this.anioCurso = anioCurso;
    }

    public String getEspacioCurricular() {
        return espacioCurricular;
    }

    public void setEspacioCurricular(String espacioCurricular) {
        this.espacioCurricular = espacioCurricular;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

}
