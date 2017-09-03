
package com.materias.modelo;

/**
 *
 * @author pc
 */
public class MateriaModelo {
    private int idMateri;
    private String nombre;
    private int modulos;
    
    public String toString()
    {
        return nombre;
    }

    public MateriaModelo() {
    }

    public MateriaModelo(int idMateri, String nombre, int modulos) {
        this.idMateri = idMateri;
        this.nombre = nombre;
        this.modulos = modulos;
    }

    public int getIdMateri() {
        return idMateri;
    }

    public void setIdMateri(int idMateri) {
        this.idMateri = idMateri;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getModulos() {
        return modulos;
    }

    public void setModulos(int modulos) {
        this.modulos = modulos;
    }
    
    
    
}
