/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.materias.controlador;

import com.materias.conexion.Conexion;
import com.materias.modelo.Inscripcion;
import com.materias.modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class ControlUsuario extends Conexion{
    
    public Usuario login(Usuario user){
        Usuario u = new Usuario();
        try {
            this.conectar();
            PreparedStatement ps = getCn().prepareStatement("select * from usuario where carnet = ? and contra = ?");
            ps.setString(1, user.getCarnet());
            ps.setString(2, user.getContra());
        ResultSet rs = ps.executeQuery();
            while (rs.next()) { 
                u.setIduser(rs.getInt("iduser"));
                if (rs.getInt("idgrupo")!= 0) {
                    u.setIdgrupo(rs.getInt("idgrupo"));
                }
                u.setNombre(rs.getString("nombre"));
                u.setCarnet(rs.getString("carnet"));
                u.setApellido(rs.getString("apellido"));
                u.setContra(rs.getString("contra"));
                u.setTipo(rs.getString("tipo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        this.desconectar();
        }
      return u;
    }
    
    public boolean inscribir(Usuario user){
    
        boolean flag=false;
        try {
            this.conectar();
            String sql="update usuario set idgrupo = ? where iduser = ? ";
            PreparedStatement pre=this.getCn().prepareStatement(sql);
            pre.setInt(1, user.getIdgrupo());
            pre.setInt(2, user.getIduser());
            pre.executeUpdate();
            flag=true; 
        } catch (Exception e) {
            System.out.println("Error en dao ins");
            e.printStackTrace();
        }
        return flag;
    
    
    }
    
    public List<Inscripcion> getIns(int iduser){
    List<Inscripcion> li =new ArrayList<>();
        try {
            this.conectar();
            String sql= "select concat(u.nombre,' ',u.apellido) as alumno, g.nombre as grupo, (select count(distinct m.nombre) from materia m inner join horario ho on m.idmateria = ho.idmateria where ho.idgrupo = g.idgrupo) as materias \n" +
"from usuario u inner join grupo g on u.idgrupo = g.idgrupo inner join horario h on h.idgrupo = g.idgrupo where u.iduser = ? group by u.nombre;";
            PreparedStatement pre = getCn().prepareStatement(sql);
            pre.setInt(1, iduser);
            ResultSet res = pre.executeQuery();
            while (res.next()) {
                Inscripcion i = new Inscripcion();
                i.setAlumno(res.getString("alumno"));
                i.setMaterias(res.getInt("materias"));
                i.setGrupo(res.getString("grupo"));
                li.add(i);
            }
            
        } catch (Exception e) {
         
            e.printStackTrace();
        }
    return li;
    }
}
