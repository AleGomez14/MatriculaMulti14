package com.materias.modelo;

/**
 * Nombre de la clase:Grupo
 * Fecha:1/09/2017
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Gabriela Gomez, Carlos paniagua,Ivan Deras
 */
public class Grupo {

    private int idGrupo;
    private String nombre;
    private int cupo;

    @Override
    public String toString() {
        return nombre;
    }

    public Grupo() {
    }

    public Grupo(int idGrupo, String nombre, int cupo) {
        this.idGrupo = idGrupo;
        this.nombre = nombre;
        this.cupo = cupo;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

}
