package bomberosgrupo5.vistas;

import bomberosgrupo5.accesoADatos.BrigadaData;
import bomberosgrupo5.accesoADatos.CuartelData;
import bomberosgrupo5.entidades.Brigada;
import bomberosgrupo5.entidades.Cuartel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class AgregarBrigada extends javax.swing.JInternalFrame {

    private BrigadaData briga = new BrigadaData();
    
private CuartelData cua = new CuartelData();
    

    public AgregarBrigada() {
        initComponents();
        llenarComboEspecialidades();
        llenarComboCuartel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jCBEspecialidad = new javax.swing.JComboBox<>();
        jCBCuartel = new javax.swing.JComboBox<>();

        jLabel1.setText("Nombre Brigada");

        jLabel2.setText("Seleccione la especialidad");

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Seleccione el cuartel al cual quiere pretenecer");

        jCBEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jCBCuartel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jButton2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1)
                                    .addComponent(jCBEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel3)
                        .addGap(47, 47, 47)
                        .addComponent(jCBCuartel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(517, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jCBCuartel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCBEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jButton2)))
                .addGap(204, 204, 204))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//----------------------------BOTON GUARDAR-----------------
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
           String cuartelSeleccionado = (String) jCBCuartel.getSelectedItem();

    // Obtener el ID del cuartel a partir de la cadena seleccionada
    int idCuartel = Integer.parseInt(cuartelSeleccionado.split("\\. ")[0]);

    if (briga.hayCupoParaNuevaBrigada(idCuartel)) {
        String nombreBrigada = jTextField1.getText();
        // Verificar si el nombre de la brigada es válido
        if (nombreBrigada != null && !nombreBrigada.isEmpty()) {
            // Verificar si el nombre de la brigada ya existe en ese cuartel
            if (briga.existeBrigadaConNombreEnCuartel(nombreBrigada, idCuartel)) {
                JOptionPane.showMessageDialog(null, "Ya existe una brigada con el mismo nombre en este cuartel. No se puede agregar.");
            } else {
                String especialidad = (String) jCBEspecialidad.getSelectedItem();

                // Crear y guardar la brigada
                Brigada brigada = new Brigada();
                brigada.setNombreBrig(nombreBrigada);
                brigada.setEspecialidad(especialidad);
                brigada.setIdCuartel(idCuartel);
                brigada.setLibre(true);
                brigada.setEstadoBr(true);
                briga.guardarBrigada(brigada);
                System.out.println("cargada");
                JOptionPane.showMessageDialog(null, "Brigada cargada");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El nombre de la brigada no es válido.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "El cuartel está completo. No se puede agregar más brigadas.");
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
//------------------------METODOS----------------------

    private void llenarComboEspecialidades() {
        String[] especialidades = briga.Especialidades();
        jCBEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(especialidades));
    }

    private void llenarComboCuartel() {
        List<String> nombresCuartel = cua.mostrarOpcionesYObtenerSeleccion();

        if (!nombresCuartel.isEmpty()) {
            // Limpiamos el JComboBox antes de agregar los nuevos elementos
            jCBCuartel.removeAllItems();
            for (String nombre : nombresCuartel) {
                jCBCuartel.addItem(nombre);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron cuarteles.");
        }
    }

//-------------------------------------------------------------------------

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jCBCuartel;
    private javax.swing.JComboBox<String> jCBEspecialidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
