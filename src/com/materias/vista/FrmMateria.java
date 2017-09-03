/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.materias.vista;

import com.materias.controlador.ControladorMateria;
import com.materias.modelo.Grupo;
import com.materias.modelo.MateriaModelo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Nombre de la clase:Materias
 * Fecha:1/09/2017
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Gabriela Gomez, Carlos paniagua,Ivan Deras
 */
public class FrmMateria extends javax.swing.JInternalFrame {
            private  ControladorMateria cm=new ControladorMateria();
            private MateriaModelo m= new MateriaModelo();
    /**
     * Creates new form FrmMateria
     */
    public FrmMateria() {
        initComponents();
        TablaE();
    }
 public void TablaE(){
    String[] columnas = {"Nombre","Modulos"};
    Object[] obj = new Object[3];
    DefaultTableModel dtm = new DefaultTableModel(null,columnas);
    List<MateriaModelo> lm = new ArrayList<MateriaModelo>();
        try {
            lm = cm.mostrar();
            for (MateriaModelo g : lm) {
                obj[0] = g; 
                obj[1] = g.getModulos();
                
                dtm.addRow(obj); 
            }
            this.jTable1.setModel(dtm); 
        } catch (Exception e) {
            
            System.out.println("erro");
        }
    
    }

    public void llenar()
    {
        m.setNombre(jComboBox1.getSelectedItem().toString());
        m.setModulos(Integer.parseInt(this.jSpinner1.getValue().toString()));     
    }
    
     public void add()
    {
        try {
            llenar();
            if (cm.insertar(m)) 
            {
                JOptionPane.showMessageDialog(this,"Dato Guardado ","Correcto",JOptionPane.INFORMATION_MESSAGE);
                TablaE();
            }else
                JOptionPane.showMessageDialog(this,"Error ","Fail",JOptionPane.ERROR);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error ","Fail",JOptionPane.ERROR);
        }
    }
     public void modificar(){
       try {
           int op = JOptionPane.showConfirmDialog(this, "Desea Modificar","Exito!",JOptionPane.YES_NO_OPTION,1);
           if (op ==0) {
               llenar();
                if (cm.modificar(m)) {
               JOptionPane.showMessageDialog(this, "Datos Modificados","Exito!",1);
              TablaE();
               limpiar();
           }else{
               JOptionPane.showMessageDialog(this, "Ocurrio un problema!","Error!",0);
           }
           }
       } catch (Exception e) {
           System.out.println("error en modificar vista");
           e.printStackTrace();
       }
       }
    public void eliminar(){
          try {
           int op = JOptionPane.showConfirmDialog(this, "Desea eliminar?","Exito!",JOptionPane.YES_NO_OPTION,1);
           if (op ==0) {
               llenar();
                if (cm.eliminar(m)) {
               JOptionPane.showMessageDialog(this, "Dato Eliminado","Exito!",1);
               TablaE();
               limpiar();
           }else{
               JOptionPane.showMessageDialog(this, "Ocurrio un problema","Error!",0);
           }
           }
       } catch (Exception e) {
           System.out.println("error en vista delete");
           e.printStackTrace();
       }
   
   }
     public void limpiar()
     {
        jSpinner1.setValue(10);
        jComboBox1.setSelectedIndex(0);
     }
     
        public void click(){
       try {
          limpiar();
           int index = jTable1.getSelectedRow(); 
           m = (MateriaModelo) jTable1.getValueAt(index, 0); 
           this.jComboBox1.setSelectedItem(m.getNombre());
           this.jSpinner1.setValue(m.getModulos());
           
           
       } catch (Exception e) {
           System.out.println("error");
           
       }}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Gestionar Materias");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombre de la Materia");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Modulo");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--seleccione--", "Desarrollo de Logica de programacion (tec)", "Analisis de Diseño de Sistemas (tec)", "Configuracion de Harwared (tec)", "Ingles Basico I (basica)", "Comunicacion Oral y Escrita(basica)" }));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/guardar.png"))); // NOI18N
        jButton1.setText("Agregar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/modificar.png"))); // NOI18N
        jButton2.setText("Modificar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/eliminar.png"))); // NOI18N
        jButton3.setText("Eliminar");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/mostrar.png"))); // NOI18N
        jButton4.setText("Limpiar");

        jSpinner1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 2, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel1)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton3)
                        .addComponent(jButton4)))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        add();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
      modificar();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        eliminar();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       click();
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
