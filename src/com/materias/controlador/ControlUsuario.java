/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.materias.controlador;

import com.materias.conexion.Conexion;
import com.materias.modelo.Usuario;
import java.sql.*;

/**
 *
 * @author pc
 */
public class ControlUsuario extends Conexion{
    
    public String login(Usuario user){
        String nivel = "";
        try {
            this.conectar();
            PreparedStatement ps = getCn().prepareStatement("select tipo from usuario where carnet = ? and contra = ?");
            ps.setString(1, user.getCarnet());
            ps.setString(2, user.getContra());
        ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                nivel = rs.getString("tipo");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        this.desconectar();
        }
      return nivel;
    }
}
