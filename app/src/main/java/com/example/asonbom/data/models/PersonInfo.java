package com.example.asonbom.data.models;

import com.google.gson.annotations.SerializedName;

public class PersonInfo {

    public PersonInfo(String sub, String email, String nombre, String last_name, String telefono, String rango, String rol, String estacion, String iat, String exp) {
        this.sub = sub;
        this.email = email;
        this.nombre = nombre;
        this.last_name = last_name;
        this.telefono = telefono;
        this.rango = rango;
        this.rol = rol;
        this.estacion = estacion;
        this.iat = iat;
        this.exp = exp;
    }


    //"sub","email","nombre","last_name","telefono","rango","rol","estacion","iat","exp"
    @SerializedName("sub")
    private String sub ;

    @SerializedName("email")
    public String email;

    @SerializedName("nombre")
    public String nombre;

    @SerializedName("last_name")
    private String last_name ;

    @SerializedName("telefono")
    public String telefono;

    @SerializedName("rango")
    public String rango;

    @SerializedName("rol")
    public String rol;

    @SerializedName("estacion")
    private String estacion ;

    @SerializedName("iat")
    public String iat;

    @SerializedName("exp")
    public String exp;

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    public String getIat() {
        return iat;
    }

    public void setIat(String iat) {
        this.iat = iat;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }
}