/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorDocumento;

/**
 *
 * @author Hijos
 */
public class FrmDocumento extends javax.swing.JFrame {

    ControladorDocumento cnt = null;

    /**
     * Creates new form FrmDocumento
     */
    public FrmDocumento() {
        initComponents();
        cnt = new ControladorDocumento();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMedida = new javax.swing.JTable();
        txtid = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtSiglas = new javax.swing.JTextField();
        btnRegistra = new javax.swing.JButton();
        btnModifica = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        btnElimina = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Documento");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));

        tblMedida.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblMedida);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 44, 900, 93));
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 80, -1));

        jLabel5.setText("ID Documento:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel7.setText("Siglas:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel8.setText("Descripción:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, -1, -1));
        getContentPane().add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 460, -1));
        getContentPane().add(txtSiglas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 60, -1));

        btnRegistra.setText("Registrar");
        btnRegistra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistraActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistra, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, -1));

        btnModifica.setText("Modificar");
        btnModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificaActionPerformed(evt);
            }
        });
        getContentPane().add(btnModifica, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, -1, -1));

        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, -1, -1));

        btnElimina.setText("Eliminar");
        btnElimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminaActionPerformed(evt);
            }
        });
        getContentPane().add(btnElimina, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 270, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistraActionPerformed
        int id = 0;
        String descripcion = null;
        String siglas = null;

        id = Integer.parseInt(txtid.getText());
        descripcion = String.valueOf(txtDescripcion.getText());
        siglas = String.valueOf(txtSiglas.getText());

        cnt.RegistraDocumento(id, descripcion, siglas);

        limpiar();
    }//GEN-LAST:event_btnRegistraActionPerformed

    private void btnModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificaActionPerformed
        int id;
        String descripcion, siglas;
        id = Integer.parseInt(txtid.getText());
        siglas = txtSiglas.getText();
        descripcion = txtDescripcion.getText();

        cnt.ActualizarDocumento(id, descripcion, siglas);

        limpiar();
    }//GEN-LAST:event_btnModificaActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        tblMedida.setModel(new javax.swing.table.DefaultTableModel(
                cnt.MostrarDocumento(),
                new String[]{
                    "ID Medida", "Descripción", "Siglas"
                }
        ));
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnEliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaActionPerformed
        int fila = tblMedida.getSelectedRow();
        String idMedida = tblMedida.getValueAt(fila, 0).toString();
        cnt.EliminaDocumento(fila, idMedida);
    }//GEN-LAST:event_btnEliminaActionPerformed
    public void limpiar() {
        txtid.setText("");
        txtDescripcion.setText("");
        txtSiglas.setText("");
    }

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
            java.util.logging.Logger.getLogger(FrmDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDocumento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnElimina;
    private javax.swing.JButton btnModifica;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnRegistra;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblMedida;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtSiglas;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}