package com.neetogami.criptoapp.Models;

import java.text.MessageFormat;

/**
 * Created by segun on 18/12/2017.
 */

public class Curso {
    private int aforoMaximo; //20
    private int alumnosInscritos; //0
    private String cursoId; //"geometria_rafael_05-01-18"
    private String estadoCurso; //"Abierto"
    private String fechaApertura; //05/01/18"
    private String nombreCurso; //"Geometria"
    private int precioInscripcion; //35
    private String profesorCurso; //"Rafael

    public Curso(int aforoMaximo, int alumnosInscritos, String cursoId, String estadoCurso, String fechaApertura, String nombreCurso, int precioInscripcion, String profesorCurso) {
        this.aforoMaximo = aforoMaximo;
        this.alumnosInscritos = alumnosInscritos;
        this.cursoId = cursoId;
        this.estadoCurso = estadoCurso;
        this.fechaApertura = fechaApertura;
        this.nombreCurso = nombreCurso;
        this.precioInscripcion = precioInscripcion;
        this.profesorCurso = profesorCurso;
    }

    public int getAforoMaximo() {
        return aforoMaximo;
    }

    public void setAforoMaximo(int aforoMaximo) {
        this.aforoMaximo = aforoMaximo;
    }

    public int getAlumnosInscritos() {
        return alumnosInscritos;
    }

    public void setAlumnosInscritos(int alumnosInscritos) {
        this.alumnosInscritos = alumnosInscritos;
    }

    public String getCursoId() {
        return cursoId;
    }

    public void setCursoId(String cursoId) {
        this.cursoId = cursoId;
    }

    public String getEstadoCurso() {
        return estadoCurso;
    }

    public void setEstadoCurso(String estadoCurso) {
        this.estadoCurso = estadoCurso;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getPrecioInscripcion() {
        return precioInscripcion;
    }

    public void setPrecioInscripcion(int precioInscripcion) {
        this.precioInscripcion = precioInscripcion;
    }

    public String getProfesorCurso() {
        return profesorCurso;
    }

    public void setProfesorCurso(String profesorCurso) {
        this.profesorCurso = profesorCurso;
    }


    public String getFlagURL() {
        return "http://cursoimplantes.com/wp-content/uploads/2016/09/icon-fecha-curso.png";
        //MessageFormat.format("http://www.geognos.com/api/en/countries/flag/{0}.png","ES");
    }

}
