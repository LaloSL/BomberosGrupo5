/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberosgrupo5.vistas;

import bomberosgrupo5.accesoADatos.BomberoData;
import bomberosgrupo5.entidades.Bombero;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Joaco
 */
public class ModificarBombero extends javax.swing.JInternalFrame {

    private BomberoData bomb = new BomberoData();

    /**
     * Creates new form ModificarCuartel
     */
    public ModificarBombero() {
        initComponents();
        llenarComboBrigada();
        llenarComboEspecialidades();
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
        jCBrigada = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTDni = new javax.swing.JTextField();
        jBGuardar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCBombero = new javax.swing.JComboBox<>();
        jTDni1 = new javax.swing.JTextField();
        jTDni2 = new javax.swing.JTextField();
        jTDni3 = new javax.swing.JTextField();
        jTDni4 = new javax.swing.JTextField();

        setMaximizable(true);

        jLabel1.setText("Seleccione la brigada");

        jCBrigada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCBrigadaMouseClicked(evt);
            }
        });
        jCBrigada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBrigadaActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre:");

        jBGuardar.setText("Guardar Cambios");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jLabel8.setText("Grupo Sanguineo:");

        jLabel4.setText("Fecha Nacimiento");

        jLabel5.setText("DNI:");

        jLabel6.setText("Nro Telefono");

        jLabel2.setText("Seleccione Bombero");

        jCBombero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCBomberoMouseClicked(evt);
            }
        });
        jCBombero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBomberoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(jCBrigada, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(jCBombero, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jTDni, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jTDni4, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6)
                        .addGap(52, 52, 52)
                        .addComponent(jTDni3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jBGuardar)
                        .addGap(249, 249, 249)
                        .addComponent(jBSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTDni2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jTDni1))))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1))
                    .addComponent(jCBrigada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2))
                    .addComponent(jCBombero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5))
                    .addComponent(jTDni2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel3))
                    .addComponent(jTDni1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel8))
                    .addComponent(jTDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4))
                    .addComponent(jTDni4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel6))
                    .addComponent(jTDni3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBGuardar)
                    .addComponent(jBSalir))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCBrigadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBrigadaMouseClicked

//        String cuartelSeleccionado = (String) jCCuartel.getSelectedItem();
//
//        if (cuartelSeleccionado != null) {
//
//            int idCuartel = Integer.parseInt(cuartelSeleccionado.split("\\. ")[0]);
//            Cuartel cuartel = cua.buscarCuartelPorId(idCuartel);
//
//            if (cuartel != null) {
//                jTNombre.setText(cuartel.getNombreCuartel());
//                jTDireccion.setText(cuartel.getDireccion());
////                int coordX = Integer.parseInt(title)
//                jTlongitud.setText(Integer.toString(cuartel.getCoordX()));
//                jTLatitud.setText(Integer.toString(cuartel.getCoordY()));
//                jTTelefono.setText(cuartel.getTelefono());
//                jTCorreo.setText(cuartel.getCorreo());
//
//            }

    }//GEN-LAST:event_jCBrigadaMouseClicked

    private void jCBrigadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBrigadaActionPerformed
        String bomberoSelec = (String) jCBombero.getSelectedItem();
        
        if (bomberoSelec != null) {

            int idBombero = Integer.parseInt(bomberoSelec.split("\\. ")[0]);
            Bombero bombero = bomb.buscarBrigadaPorId(idBombero);

            if (brigada != null) {
                jTDni.setText(brigada.getNombreBrig());
//                jTDireccion.setText(cuartel.getDireccion());
////                int coordX = Integer.parseInt(title)
//                jTlongitud.setText(Integer.toString(cuartel.getCoordX()));
//                jTLatitud.setText(Integer.toString(cuartel.getCoordY()));
//                jTTelefono.setText(cuartel.getTelefono());
//                jTCorreo.setText(cuartel.getCorreo());

            }
        }
        
        
    }//GEN-LAST:event_jCBrigadaActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed

        String brigadaSelec = (String) jCBrigada.getSelectedItem();

        if (brigadaSelec != null) {

            int idBrigada = Integer.parseInt(brigadaSelec.split("\\. ")[0]);

            String nuevoNombre = jTDni.getText();
            String nuevaEspecialidad = (String) jCEspecialidad.getSelectedItem();
            
            //Brigada BrigadaActualizada = new Brigada (nuevoNombre, nuevaEspecialidad);
            briga.modificarBrigada(idBrigada, nuevoNombre, nuevaEspecialidad);
            //JOptionPane.showMessageDialog(null, "Brigada Modificada");


    }//GEN-LAST:event_jBGuardarActionPerformed
    }
    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jCBomberoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBomberoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBomberoMouseClicked

    private void jCBomberoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBomberoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBomberoActionPerformed

    

    

    
        private void llenarComboBrigada() {
        List<String> nombresBrigada = briga.mostrarOpciones();

        if (!nombresBrigada.isEmpty()) {
            // Limpiamos el JComboBox antes de agregar los nuevos elementos
            jCBrigada.removeAllItems();
            for (String nombre : nombresBrigada) {
                jCBrigada.addItem(nombre);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron brigadas");
        }
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox<String> jCBombero;
    private javax.swing.JComboBox<String> jCBrigada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTDni;
    private javax.swing.JTextField jTDni1;
    private javax.swing.JTextField jTDni2;
    private javax.swing.JTextField jTDni3;
    private javax.swing.JTextField jTDni4;
    // End of variables declaration//GEN-END:variables
}
