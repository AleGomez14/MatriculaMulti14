
package com.materias.controlador;

import com.materias.conexion.Conexion;
import com.materias.modelo.Grupo;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;



/**
 * Nombre de la clase:ControlGrupo
 * Fecha:1/09/2017
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Gabriela Gomez, Carlos paniagua,Ivan Deras
 */
public class ControlGrupo extends Conexion{
    public List mostrar()
    {
        List listaG = new ArrayList();
        try {
            this.conectar();
            String sql="select * from grupo";
            PreparedStatement pre=this.getCn().prepareCall(sql);
            ResultSet res=pre.executeQuery();
            while (res.next()) 
            {                
                Grupo g= new Grupo();
                g.setIdGrupo(res.getInt("idgrupo"));
                g.setNombre(res.getString("nombre"));
                g.setCupo(res.getInt("cupo"));
                listaG.add(g);
            }
        } catch (Exception e) {
            System.out.println("Error en dao");
        }
        return listaG;
    }
    
    public boolean agregar(Grupo g)
    {
        boolean flag=false;
        try {
            this.conectar();
            String sql="insert into grupo (nombre,cupo)"
                    + "values(?,?)";
            PreparedStatement pre=this.getCn().prepareStatement(sql);
            pre.setString(1, g.getNombre());
            pre.setInt(2, g.getCupo());
            pre.executeUpdate();
            flag=true; 
        } catch (Exception e) {
            System.out.println("Error en dao add");
        }
        return flag;
    }
    public boolean modificar(Grupo g){
    boolean flag = false;
        try {
            this.conectar();
            String sql = "update grupo set nombre= ?, cupo = ?"
                    + " where idgrupo = ?;";
            PreparedStatement pre = this.getCn().prepareStatement(sql);
            pre.setString(1, g.getNombre());
            pre.setInt(2, g.getCupo());
            pre.setInt(3, g.getIdGrupo());
            pre.executeUpdate();
            flag = true;
        } catch (Exception e) {
            System.out.println("error en dao modificar");
            e.printStackTrace();
            flag=false;
        }
        return flag;
    
    }
    
    public boolean eliminar(Grupo g){
    boolean flag = false;
        try {
            this.conectar();
            String sql = "delete from grupo where idgrupo = ?;";
            PreparedStatement pre = this.getCn().prepareStatement(sql);
            pre.setInt(1, g.getIdGrupo());
            pre.executeUpdate();
            flag = true;
        } catch (Exception e) {
            System.out.println("error en delete dao");
            e.printStackTrace();
            flag=false;
        }
        return flag;
    
    }
    
    
}
