package com.neetogami.criptoapp.Models;

/**
 * Created by segun on 18/12/2017.
 */

public class CompraUser {
    private String compraId; //neetogami@gmail.com_geometria_rafael_05-01-18"
    private String cursoId; //"geometria_rafael_05-01-18"
    private String nombreCurso;
    private String fechaCompra; // "5/12/17",
    private int precioCompra; // 35,
    private String userId; //"neetogami@gmail.com"

    public CompraUser(String compraId, String cursoId, String nombreCurso, String fechaCompra, int precioCompra, String userId) {
        this.compraId = compraId;
        this.cursoId = cursoId;
        this.nombreCurso = nombreCurso;
        this.fechaCompra = fechaCompra;
        this.precioCompra = precioCompra;
        this.userId = userId;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getCompraId() {
        return compraId;
    }

    public void setCompraId(String compraId) {
        this.compraId = compraId;
    }

    public String getCursoId() {
        return cursoId;
    }

    public void setCursoId(String cursoId) {
        this.cursoId = cursoId;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
