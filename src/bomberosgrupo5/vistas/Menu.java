/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberosgrupo5.vistas;

import java.awt.Color;

/**
 *
 * @author Asus
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(700, 700);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMModificarCuartel = new javax.swing.JMenuItem();
        jMEliminarCuartel = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMModificarBrigada = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMEliminarBrigada = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMAgregarBombero = new javax.swing.JMenuItem();
        jMModificarBombero = new javax.swing.JMenuItem();
        jMEliminarBombero = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMAgregarSiniestro = new javax.swing.JMenuItem();
        jMModificarSiniestro = new javax.swing.JMenuItem();
        jMEliminarSiniestro = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        jMenu1.setText("Cuartel");

        jMenuItem1.setText("Agregar Cuartel");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMModificarCuartel.setText("Modificar Cuartel");
        jMModificarCuartel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMModificarCuartelActionPerformed(evt);
            }
        });
        jMenu1.add(jMModificarCuartel);

        jMEliminarCuartel.setText("Eliminar Cuartel");
        jMEliminarCuartel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMEliminarCuartelActionPerformed(evt);
            }
        });
        jMenu1.add(jMEliminarCuartel);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Brigada");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMModificarBrigada.setText("Agregar Brigada");
        jMModificarBrigada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMAgregarBrigada(evt);
            }
        });
        jMenu2.add(jMModificarBrigada);

        jMenuItem4.setText("Modificar Brigada");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMEliminarBrigada.setText("Eliminar Brigada");
        jMEliminarBrigada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMEliminarBrigadaActionPerformed(evt);
            }
        });
        jMenu2.add(jMEliminarBrigada);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Bombero");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMAgregarBombero.setText("Agregar Bombero");
        jMAgregarBombero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMAgregarBomberoActionPerformed(evt);
            }
        });
        jMenu3.add(jMAgregarBombero);

        jMModificarBombero.setText("Modificar Bombero");
        jMModificarBombero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMModificarBomberoActionPerformed(evt);
            }
        });
        jMenu3.add(jMModificarBombero);

        jMEliminarBombero.setText("Eliminar Bombero");
        jMEliminarBombero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMEliminarBomberoActionPerformed(evt);
            }
        });
        jMenu3.add(jMEliminarBombero);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Siniestro");

        jMAgregarSiniestro.setText("Agregar Siniestro");
        jMAgregarSiniestro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMAgregarSiniestroActionPerformed(evt);
            }
        });
        jMenu4.add(jMAgregarSiniestro);

        jMModificarSiniestro.setText("Modificar Siniestro");
        jMModificarSiniestro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMModificarSiniestroActionPerformed(evt);
            }
        });
        jMenu4.add(jMModificarSiniestro);

        jMEliminarSiniestro.setText("Eliminar Siniestro");
        jMEliminarSiniestro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMEliminarSiniestroActionPerformed(evt);
            }
        });
        jMenu4.add(jMEliminarSiniestro);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Listar");

        jMenuItem2.setText("Brigadas Libres");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem2);

        jMenuItem3.setText("Brigadas Asignadas");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Consultar");

        jMenuItem5.setText("Bomberos/Brigada");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem5);

        jMenuItem6.setText("Brigadas/Cuartel");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem6);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Distancia");

        jMenuItem7.setText("Distancia entre dos puntos");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem7);

        jMenuItem8.setText("Distancia cuarteles");
        jMenu7.add(jMenuItem8);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        AgregarCuartel cua = new AgregarCuartel();
        cua.setVisible(true);
        cua.getContentPane().setBackground(new Color(86, 167, 132));
        escritorio.add(cua);

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed

    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMAgregarBrigada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMAgregarBrigada
        escritorio.removeAll();
        escritorio.repaint();
        AgregarBrigada bri = new AgregarBrigada();
        bri.setVisible(true);
        bri.getContentPane().setBackground(new Color(86, 167, 132));
        escritorio.add(bri);
    }//GEN-LAST:event_jMAgregarBrigada

    private void jMAgregarBomberoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMAgregarBomberoActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        AgregarBombero bomb = new AgregarBombero();
        bomb.setVisible(true);
        bomb.getContentPane().setBackground(new Color(86, 167, 132));
        escritorio.add(bomb);
    }//GEN-LAST:event_jMAgregarBomberoActionPerformed

    private void jMModificarCuartelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMModificarCuartelActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        ModificarCuartel cua = new ModificarCuartel();
        cua.setVisible(true);
        cua.getContentPane().setBackground(new Color(86, 167, 132));
        escritorio.add(cua);

//        

    }//GEN-LAST:event_jMModificarCuartelActionPerformed

    private void jMAgregarSiniestroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMAgregarSiniestroActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        AgregarSiniestro sin = new AgregarSiniestro();
        sin.setVisible(true);
        sin.getContentPane().setBackground(new Color(86, 167, 132));
        escritorio.add(sin);
    }//GEN-LAST:event_jMAgregarSiniestroActionPerformed

    private void jMEliminarBrigadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMEliminarBrigadaActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        EliminarBrigada eliB = new EliminarBrigada();
        eliB.setVisible(true);
        eliB.getContentPane().setBackground(new Color(86, 167, 132));
        escritorio.add(eliB);
    }//GEN-LAST:event_jMEliminarBrigadaActionPerformed


    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed

    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMEliminarBomberoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMEliminarBomberoActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        EliminarBombero eliBo = new EliminarBombero();
        eliBo.setVisible(true);
        eliBo.getContentPane().setBackground(new Color(86, 167, 132));
        escritorio.add(eliBo);
    }//GEN-LAST:event_jMEliminarBomberoActionPerformed

    private void jMEliminarSiniestroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMEliminarSiniestroActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        EliminarSiniestro esin = new EliminarSiniestro();
        esin.setVisible(true);
        esin.getContentPane().setBackground(new Color(86, 167, 132));
        escritorio.add(esin);
    }//GEN-LAST:event_jMEliminarSiniestroActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        ModificarBrigada eliB = new ModificarBrigada();
        eliB.setVisible(true);
        eliB.getContentPane().setBackground(new Color(86, 167, 132));
        escritorio.add(eliB);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMModificarBomberoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMModificarBomberoActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        ModificarBombero eliB = new ModificarBombero();
        eliB.setVisible(true);
        eliB.getContentPane().setBackground(new Color(86, 167, 132));
        escritorio.add(eliB);
    }//GEN-LAST:event_jMModificarBomberoActionPerformed

    private void jMEliminarCuartelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMEliminarCuartelActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        EliminarCuartel cua = new EliminarCuartel();
        cua.setVisible(true);
        cua.getContentPane().setBackground(new Color(86, 167, 132));
        escritorio.add(cua);

    }//GEN-LAST:event_jMEliminarCuartelActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        BrigadasLibres bl = new BrigadasLibres();
        bl.setVisible(true);
        bl.getContentPane().setBackground(new Color(86, 167, 132));
        escritorio.add(bl);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        BrigadasOcupadas bo = new BrigadasOcupadas();
        bo.setVisible(true);
        bo.getContentPane().setBackground(new Color(86, 167, 132));
        escritorio.add(bo);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        BomberosBrigada bB = new BomberosBrigada();
        bB.setVisible(true);
        bB.getContentPane().setBackground(new Color(86, 167, 132));
        escritorio.add(bB);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        BrigadasCuartel bC = new BrigadasCuartel();
        bC.setVisible(true);
        bC.getContentPane().setBackground(new Color(86, 167, 132));
        escritorio.add(bC);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMModificarSiniestroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMModificarSiniestroActionPerformed
       escritorio.removeAll();
        escritorio.repaint();
        ModificarSiniestro sin = new ModificarSiniestro();
        sin.setVisible(true);
        sin.getContentPane().setBackground(new Color(86, 167, 132));
        escritorio.add(sin);
    }//GEN-LAST:event_jMModificarSiniestroActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        DistanciaDosPuntos ddp = new DistanciaDosPuntos();
        ddp.setVisible(true);
       ddp.getContentPane().setBackground(new Color(86, 167, 132));
        escritorio.add(ddp);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem jMAgregarBombero;
    private javax.swing.JMenuItem jMAgregarSiniestro;
    private javax.swing.JMenuItem jMEliminarBombero;
    private javax.swing.JMenuItem jMEliminarBrigada;
    private javax.swing.JMenuItem jMEliminarCuartel;
    private javax.swing.JMenuItem jMEliminarSiniestro;
    private javax.swing.JMenuItem jMModificarBombero;
    private javax.swing.JMenuItem jMModificarBrigada;
    private javax.swing.JMenuItem jMModificarCuartel;
    private javax.swing.JMenuItem jMModificarSiniestro;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    // End of variables declaration//GEN-END:variables
}
