/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.vista;

import edu.dao.ControlGrupo;
import edu.modelo.Grupo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Nombre de la clase:FrmGrupo
 * Fecha:1/09/2017
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Gabriela Gomez, Carlos paniagua,Ivan Deras
 */
public class FrmGrupo extends javax.swing.JInternalFrame {
            private  ControlGrupo cg=new ControlGrupo();
            private Grupo g= new Grupo();
    /**
     * Creates new form FrmGrupo
     */
    public FrmGrupo() {
        initComponents();
        TablaE();
    }
    
     public void TablaE(){
    String[] columnas = {"Nombre","Cupo"};
    Object[] obj = new Object[3];
    DefaultTableModel dtm = new DefaultTableModel(null,columnas);
    List<Grupo> lg = new ArrayList<Grupo>();
        try {
            lg = cg.mostrar();
            for (Grupo g : lg) {
                obj[0] = g; 
                obj[1] = g.getCupo();
                
                dtm.addRow(obj); 
            }
            this.jTbMostrar.setModel(dtm); 
        } catch (Exception e) {
            
            System.out.println("erro");
        }
    
    }

    public void llenar()
    {
        g.setNombre(jCmGrupo.getSelectedItem().toString());
        g.setCupo(Integer.parseInt(this.jSpCupo.getValue().toString()));     
    }
    
    public void add()
    {
        try {
            llenar();
            if (cg.agregar(g)) 
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
                if (cg.modificar(g)) {
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
                if (cg.eliminar(g)) {
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
        jSpCupo.setValue(10);
        jCmGrupo.setSelectedIndex(0);
     }
     
        public void click(){
       try {
          limpiar();
           int index = jTbMostrar.getSelectedRow(); 
           g = (Grupo) jTbMostrar.getValueAt(index, 0); 
           this.jCmGrupo.setSelectedItem(g.getNombre());
           this.jSpCupo.setValue(g.getCupo());
           
           
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
        jTbMostrar = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSpCupo = new javax.swing.JSpinner();
        jbtnAgregar = new javax.swing.JButton();
        jBtnModificar = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();
        jBtnLimpiar = new javax.swing.JButton();
        jCmGrupo = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jTbMostrar.setModel(new javax.swing.table.DefaultTableModel(
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
        jTbMostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTbMostrarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTbMostrar);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Gestionar Grupo");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nombre de Grupo");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Cupo");

        jSpCupo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jSpCupo.setModel(new javax.swing.SpinnerNumberModel(10, 10, 40, 1));

        jbtnAgregar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/guardar.png"))); // NOI18N
        jbtnAgregar.setText("Agregar");
        jbtnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnAgregarMouseClicked(evt);
            }
        });

        jBtnModificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/modificar.png"))); // NOI18N
        jBtnModificar.setText("Modificar");
        jBtnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnModificarMouseClicked(evt);
            }
        });

        jBtnEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/eliminar.png"))); // NOI18N
        jBtnEliminar.setText("Eliminar");
        jBtnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnEliminarMouseClicked(evt);
            }
        });

        jBtnLimpiar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBtnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/mostrar.png"))); // NOI18N
        jBtnLimpiar.setText("Limpiar");

        jCmGrupo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jCmGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--seleccione--", "Sis01A", "Sis01B", "Sis06A", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(32, 32, 32)
                                .addComponent(jCmGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(119, 119, 119)
                                .addComponent(jSpCupo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbtnAgregar)
                                .addGap(12, 12, 12)
                                .addComponent(jBtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtnLimpiar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel1)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jCmGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jSpCupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnEliminar)
                            .addComponent(jbtnAgregar)
                            .addComponent(jBtnModificar)
                            .addComponent(jBtnLimpiar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnAgregarMouseClicked
            add();
    }//GEN-LAST:event_jbtnAgregarMouseClicked

    private void jTbMostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbMostrarMouseClicked
       click();
    }//GEN-LAST:event_jTbMostrarMouseClicked

    private void jBtnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnModificarMouseClicked
       modificar();

    }//GEN-LAST:event_jBtnModificarMouseClicked

    private void jBtnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnEliminarMouseClicked
       eliminar();
    }//GEN-LAST:event_jBtnEliminarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JButton jBtnLimpiar;
    private javax.swing.JButton jBtnModificar;
    private javax.swing.JComboBox<String> jCmGrupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpCupo;
    private javax.swing.JTable jTbMostrar;
    private javax.swing.JButton jbtnAgregar;
    // End of variables declaration//GEN-END:variables
}
