/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.materias.vista;

import com.materias.controlador.ControlGrupo;
import com.materias.controlador.ControlHorario;
import com.materias.controlador.ControladorMateria;
import com.materias.modelo.Grupo;
import com.materias.modelo.Horario;
import com.materias.modelo.MateriaModelo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class FrmHorario extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmHorario
     */
    public FrmHorario() {
        initComponents();
        llenarG();
        llenarM();
        tableE();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();

        setClosable(true);

        jLabel1.setText("materia");

        jLabel2.setText("hora");

        jLabel3.setText("grupo");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7:00 am - 8:40 am", "9:00 am - 10:40 am", "11:00 am - 12:40 pm", "1:00 pm - 2:40 am", "3:00 pm - 4:40 pm" }));

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

        jButton1.setText("insertar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("modificar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setText("eliminar");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setText("limpiar");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jLabel4.setText("dia");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "lunes", "martes", "miercoles", "jueves", "viernes" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(55, 55, 55))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(47, 47, 47))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4))
                                        .addGap(49, 49, 49)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        asignar();
        ControlHorario ch = new ControlHorario();
        ch.agregar(horario);
        tableE();
        limpiar();
        JOptionPane.showMessageDialog(this, "exito!","agregar",1);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        int op = JOptionPane.showConfirmDialog(this, "desea modificar?","modificar",JOptionPane.YES_NO_OPTION,1);
        if (op == 0) {
            asignar();
        ControlHorario ch = new ControlHorario();
        ch.modificar(horario);
        tableE();
        limpiar();
        JOptionPane.showMessageDialog(this, "exito!","modificar",1);
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row= jTable1.getSelectedRow();
        horario = (Horario) jTable1.getValueAt(row, 0);
        for (int i = 0; i < lg.size(); i++) {
            if (lg.get(i).getNombre().equals(horario.getGrupo())) {
                jComboBox1.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < lm.size(); i++) {
            if (lm.get(i).getNombre().equals(horario.getMateria())) {
                jComboBox2.setSelectedIndex(i);
            }
        }
        
        jComboBox3.setSelectedItem(horario.getHora());
        jComboBox4.setSelectedItem(horario.getDia());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
         int op = JOptionPane.showConfirmDialog(this, "desea eliminar?","eliminar",JOptionPane.YES_NO_OPTION,1);
        if (op == 0) {
            asignar();
        ControlHorario ch = new ControlHorario();
        ch.eliminar(horario);
        tableE();
        limpiar();
        JOptionPane.showMessageDialog(this, "exito!","eliminar",1);
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_jButton4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
List<Grupo>lg = new ArrayList<>();
public void llenarG(){

    try {
        ControlGrupo cg = new ControlGrupo();
        lg = cg.mostrar();
        Grupo[] g = new Grupo[lg.size()];
        for (int i = 0; i < lg.size(); i++) {
            g[i] = lg.get(i);
        }
        DefaultComboBoxModel dc= new DefaultComboBoxModel(g);
        this.jComboBox1.setModel(dc);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
List<MateriaModelo>lm = new ArrayList<>();
public void llenarM(){

    try {
        ControladorMateria cg = new ControladorMateria();
        lm = cg.mostrar();
        MateriaModelo[] g = new MateriaModelo[lm.size()];
        for (int i = 0; i < lm.size(); i++) {
            g[i] = lm.get(i);
        }
        DefaultComboBoxModel dc= new DefaultComboBoxModel(g);
        this.jComboBox2.setModel(dc);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
Horario horario = new Horario();
public void asignar(){
    
    Grupo grupo = (Grupo) jComboBox1.getSelectedItem();
    MateriaModelo materia = (MateriaModelo) jComboBox2.getSelectedItem();
    horario.setIdgrupo(grupo.getIdGrupo());
    horario.setIdmateria(materia.getIdMateri());
    horario.setHora(jComboBox3.getSelectedItem().toString());
    horario.setDia(jComboBox4.getSelectedItem().toString());
}
public void limpiar(){
    horario = new Horario();
jComboBox1.setSelectedIndex(0);
jComboBox2.setSelectedIndex(0);
jComboBox3.setSelectedIndex(0);
jComboBox4.setSelectedIndex(0);
}
public void tableE(){
String[] columnas = {"materia","grupo","hora","dia"};
Object[] obj = new Object[4];
DefaultTableModel dtm = new DefaultTableModel(null,columnas);
ControlHorario ch = new ControlHorario();
List<Horario> lh = ch.mostrar();
    for (Horario h : lh) {
        obj[0] = h;
        obj[1] = h.getGrupo();
        obj[2] = h.getHora();
        obj[3] = h.getDia();
        dtm.addRow(obj);
    }
    jTable1.setModel(dtm);
}
}
