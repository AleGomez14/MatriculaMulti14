/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.materias.modelo;

/**
 * Nombre de la clase:Usuario
 * Fecha:1/09/2017
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Gabriela Gomez, Carlos paniagua,Ivan Deras
 */
public class Usuario {
    private int iduser;
    private int idgrupo;
    private String nombre;
    private String apellido;
    private String carnet;
    private String contra;
    private String tipo;

    public Usuario() {
    }

    public Usuario(int iduser, int idgrupo, String nombre, String apellido, String carnet, String contra, String tipo) {
        this.iduser = iduser;
        this.idgrupo = idgrupo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carnet = carnet;
        this.contra = contra;
        this.tipo = tipo;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(int idgrupo) {
        this.idgrupo = idgrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
  
}
