/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.materias.controlador;

import com.materias.conexion.Conexion;
import com.materias.modelo.Grupo;
import com.materias.modelo.Horario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Nombre de la clase:ControlHorario
 * Fecha:1/09/2017
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Gabriela Gomez, Carlos paniagua,Ivan Deras
 */
public class ControlHorario extends Conexion{
      public List mostrar()
    {
        List listaG = new ArrayList();
        try {
            this.conectar();
            String sql="select idhorario,h.idgrupo,h.idmateria,dia,hora,g.nombre as grupo,m.nombre as materia from horario h inner join grupo g on h.idgrupo = g.idgrupo inner join materia m on m.idmateria= h.idmateria";
            PreparedStatement pre=this.getCn().prepareCall(sql);
            ResultSet res=pre.executeQuery();
            while (res.next()) 
            {                
                Horario g= new Horario();
               g.setIdhorario(res.getInt("idhorario"));
               g.setIdgrupo(res.getInt("idgrupo"));
               g.setIdmateria(res.getInt("idmateria"));
               g.setHora(res.getString("hora"));
               g.setMateria(res.getString("materia"));
               g.setDia(res.getString("dia"));
               g.setGrupo(res.getString("grupo"));
                listaG.add(g);
            }
        } catch (Exception e) {
            System.out.println("Error en dao");
        }
        return listaG;
    }
      
      public List mostrar(int idgrupo
      )
    {
        List listaG = new ArrayList();
        try {
            this.conectar();
            String sql="select idhorario,h.idgrupo,h.idmateria,dia,hora,g.nombre as grupo,m.nombre as materia from horario h inner join grupo g on h.idgrupo = g.idgrupo inner join materia m on m.idmateria= h.idmateria where h.idgrupo = ?";
            PreparedStatement pre=this.getCn().prepareStatement(sql);
            pre.setInt(1, idgrupo);
            ResultSet res=pre.executeQuery();
            while (res.next()) 
            {                
                Horario g= new Horario();
               g.setIdhorario(res.getInt("idhorario"));
               g.setIdgrupo(res.getInt("idgrupo"));
               g.setIdmateria(res.getInt("idmateria"));
               g.setHora(res.getString("hora"));
               g.setMateria(res.getString("materia"));
               g.setDia(res.getString("dia"));
               g.setGrupo(res.getString("grupo"));
                listaG.add(g);
            }
        } catch (Exception e) {
            System.out.println("Error en dao");
            e.printStackTrace();
        }
        return listaG;
    }
         public boolean agregar(Horario g)
    {
        boolean flag=false;
        try {
            this.conectar();
            String sql="insert into horario (idgrupo,idmateria,hora,dia)"
                    + "values(?,?,?,?)";
            PreparedStatement pre=this.getCn().prepareStatement(sql);
            pre.setInt(1, g.getIdgrupo());
            pre.setInt(2, g.getIdmateria());
            pre.setString(3, g.getHora());
            pre.setString(4, g.getDia());
            pre.executeUpdate();
            flag=true; 
        } catch (Exception e) {
            System.out.println("Error en dao add");
            e.printStackTrace();
        }
        return flag;
    }
          public boolean modificar(Horario g){
    boolean flag = false;
        try {
            this.conectar();
            String sql = "update horario set idgrupo= ?, idmateria = ?, dia= ?, hora=?"
                    + " where idhorario = ?;";
            PreparedStatement pre = this.getCn().prepareStatement(sql);
            
            pre.setInt(1, g.getIdgrupo());
            pre.setInt(2, g.getIdmateria());
            pre.setString(3, g.getDia());
            pre.setString(4, g.getHora());
            pre.setInt(5, g.getIdhorario());
            pre.executeUpdate();
            flag = true;
        } catch (Exception e) {
            System.out.println("error en dao modificar");
            e.printStackTrace();
            flag=false;
        }
        return flag;
    
    }
          
          public boolean eliminar(Horario g){
    boolean flag = false;
        try {
            this.conectar();
            String sql = "delete from horario where idhorario = ?;";
            PreparedStatement pre = this.getCn().prepareStatement(sql);
            pre.setInt(1, g.getIdhorario());
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
