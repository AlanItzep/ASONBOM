package com.example.asonbom.data.responses;

import com.google.gson.annotations.SerializedName;

public class CreateEmResponse {
    @SerializedName("titulo")
    public String titulo = "Test 1 - Desde App Android directo, sin conectar clases";
    @SerializedName("detalles")
    public String detalles = "Escribiendo directamente la peticion en el codigo";
    @SerializedName("fecha")
    public String fecha = "2020-07-31";
    @SerializedName("hora")
    public String hora = "13:29:33";
    @SerializedName("idusuario")
    public String idusuario = "7";
    @SerializedName("idtipo")
    public String idtipo = "2";
    @SerializedName("long")
    public String longg = "2.15899";
    @SerializedName("lat")
    public String lat = "41.3887";

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(String idtipo) {
        this.idtipo = idtipo;
    }

    public String getLongg() {
        return longg;
    }

    public void setLongg(String longg) {
        this.longg = longg;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
}
