/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.materias.modelo;

/**
 *
 * @author pc
 */
public class Inscripcion {
    private String alumno;
    private int materias;
    private String grupo;

    public Inscripcion() {
    }

    public Inscripcion(String alumno, int materias, String grupo) {
        this.alumno = alumno;
        this.materias = materias;
        this.grupo = grupo;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public int getMaterias() {
        return materias;
    }

    public void setMaterias(int materias) {
        this.materias = materias;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    
    
}
