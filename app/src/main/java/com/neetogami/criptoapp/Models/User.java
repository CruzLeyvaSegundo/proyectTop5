package com.neetogami.criptoapp.Models;

/**
 * Created by segun on 18/12/2017.
 */

public class User {
    private String userId;
    private String nombre;

    public User(String userId, String name) {
        this.userId = userId;
        this.nombre = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

