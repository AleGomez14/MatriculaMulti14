
package edu.dao;

import edu.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import edu.modelo.MateriaModelo;
/**
 * Nombre de la clase:ControladorMateria
 * Fecha:1/09/2017
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Gabriela Gomez, Carlos paniagua,Ivan Deras
 */
public class ControladorMateria extends Conexion {
    
    public List mostrar()
    {
        List listaG = new ArrayList();
        try {
            this.conectar();
            String sql="select * from materia";
            PreparedStatement pre=this.getCn().prepareCall(sql);
            ResultSet res=pre.executeQuery();
            while (res.next()) 
            {                
                 MateriaModelo m= new MateriaModelo();
                m.setIdMateri(res.getInt("idmateria"));
                m.setNombre(res.getString("nombre"));
                m.setModulos(res.getInt("modulos"));
                listaG.add(m);
            }
        } catch (Exception e) {
            System.out.println("Error en dao");
        }
        return listaG;
    }
    public boolean insertar(MateriaModelo m){
    boolean flag = false;
        try {
            this.conectar();
            String sql = "insert into materia(nombre,modulos)" +
            "values(?,?)";
            PreparedStatement pre = this.getCn().prepareStatement(sql);
            pre.setString(1, m.getNombre());
            pre.setInt(2, m.getModulos());
            pre.executeUpdate();
            flag = true;
        } catch (Exception e) {
            System.out.println("eerror en dao add");
            e.printStackTrace();
            flag=false;
        }
        return flag;
    
    }
    
    
    
    public boolean modificar(MateriaModelo m){
    boolean flag = false;
        try {
            this.conectar();
            String sql = "update materia set nombre= ?, modulos =? where idmateria = ?;";
            PreparedStatement pre = this.getCn().prepareStatement(sql);
            pre.setString(1, m.getNombre());
            pre.setInt(2, m.getModulos());
            pre.setInt(3, m.getIdMateri());
            pre.executeUpdate();
            flag = true;
        } catch (Exception e) {
            System.out.println("erroe en modi en dao");
            e.printStackTrace();
            flag=false;
        }
        return flag;
    
    }
    
    public boolean eliminar(MateriaModelo m){
    boolean flag = false;
        try {
            this.conectar();
            String sql = "delete from materia where idmateria = ?;";
            PreparedStatement pre = this.getCn().prepareStatement(sql);
            pre.setInt(1, m.getIdMateri());
            pre.executeUpdate();
            flag = true;
        } catch (Exception e) {
            System.out.println("error en dao eliminar");
            e.printStackTrace();
            flag=false;
        }
        return flag;
    
    }
    
}


