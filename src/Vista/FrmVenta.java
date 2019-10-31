/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorVenta;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hijos
 */
public class FrmVenta extends javax.swing.JFrame {
    ControladorVenta cnt;
    SimpleDateFormat formato;
    /**
     * Creates new form FrmVenta
     */
    public FrmVenta() {
        initComponents();
        cnt = new ControladorVenta();
        formato = new SimpleDateFormat("YYYY-MM-DD");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCompra = new javax.swing.JTable();
        txtid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtsdocumento = new javax.swing.JTextField();
        txtidd = new javax.swing.JTextField();
        txtidp = new javax.swing.JTextField();
        btnRegistra = new javax.swing.JButton();
        btnModifica = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        btnElimina = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtndocumento = new javax.swing.JTextField();
        txtfecha = new javax.swing.JTextField();
        btndetalle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Venta");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        tblCompra.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblCompra);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 44, 900, 93));
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 80, -1));

        jLabel2.setText("ID Venta:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel3.setText("ID Documento:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel4.setText("Serie Documento:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel7.setText("Número Documento:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, -1, -1));
        getContentPane().add(txtsdocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 80, -1));
        getContentPane().add(txtidd, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 80, -1));
        getContentPane().add(txtidp, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, 80, -1));

        btnRegistra.setText("Registrar");
        btnRegistra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistraActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistra, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, -1));

        btnModifica.setText("Modificar");
        btnModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificaActionPerformed(evt);
            }
        });
        getContentPane().add(btnModifica, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, -1, -1));

        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, -1, -1));

        btnElimina.setText("Eliminar");
        btnElimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminaActionPerformed(evt);
            }
        });
        getContentPane().add(btnElimina, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 290, -1, -1));

        jLabel8.setText("Fecha:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, -1, -1));

        jLabel9.setText("ID Cliente:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, -1, -1));
        getContentPane().add(txtndocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 170, 80, -1));
        getContentPane().add(txtfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 200, 80, -1));

        btndetalle.setText("Detalle");
        btndetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndetalleActionPerformed(evt);
            }
        });
        getContentPane().add(btndetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 210, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistraActionPerformed
        int id = 0;
        String idDocumento = null;
        String serieDocumento = null;
        String numeroDocumento = null;
        Date fecha = null;
        String idProveedor = null;
        String date = txtfecha.getText();

        id = Integer.parseInt(txtid.getText());
        idDocumento = String.valueOf(txtidd.getText());
        serieDocumento = String.valueOf(txtsdocumento.getText());
        numeroDocumento = String.valueOf(txtndocumento.getText());
        try {
            fecha = formato.parse(date);
        } catch (ParseException ex) {
            //Logger.getLogger(FrmCompra.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
        idProveedor = String.valueOf(txtidp.getText());
        java.util.Date utilStartDate = fecha;
        java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());

        cnt.RegistraCompra(id, idDocumento, serieDocumento, numeroDocumento, sqlStartDate, idProveedor);

        limpiar();
    }//GEN-LAST:event_btnRegistraActionPerformed

    private void btnModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificaActionPerformed
        int id;
        String idDocumento, serieDocumento, numeroDocumento, idProveedor;
        Date fecha = null;
        String date = txtfecha.getText();

        id = Integer.parseInt(txtid.getText());
        idDocumento = String.valueOf(txtidd.getText());
        serieDocumento = String.valueOf(txtsdocumento.getText());
        numeroDocumento = String.valueOf(txtndocumento.getText());
        try {
            fecha = formato.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(FrmCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        idProveedor = String.valueOf(txtidp.getText());
        java.util.Date utilStartDate = fecha;
        java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());

        cnt.ActualizarCompra(id, idDocumento, serieDocumento, numeroDocumento, sqlStartDate, idProveedor);

        limpiar();
    }//GEN-LAST:event_btnModificaActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        tblCompra.setModel(new javax.swing.table.DefaultTableModel(
            cnt.MostrarCompra(),
            new String[]{
                "ID Compra", "Doumento", "Serie Documento", "Número Documento", "Fecha", "Proveedor"
            }
        ));
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnEliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaActionPerformed

        int fila = tblCompra.getSelectedRow();
        String idCompra = tblCompra.getValueAt(fila, 0).toString();
        cnt.EliminaCompra(fila, idCompra);
    }//GEN-LAST:event_btnEliminaActionPerformed

    private void btndetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndetalleActionPerformed
        FrmDetalleVenta dc = new FrmDetalleVenta();
        dc.setVisible(true);
    }//GEN-LAST:event_btndetalleActionPerformed
public void limpiar() {
        txtid.setText("");
        txtidd.setText("");
        txtsdocumento.setText("");
        txtndocumento.setText("");
        txtfecha.setText("");
        txtidp.setText("");
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
            java.util.logging.Logger.getLogger(FrmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnElimina;
    private javax.swing.JButton btnModifica;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnRegistra;
    private javax.swing.JButton btndetalle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCompra;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtidd;
    private javax.swing.JTextField txtidp;
    private javax.swing.JTextField txtndocumento;
    private javax.swing.JTextField txtsdocumento;
    // End of variables declaration//GEN-END:variables
}
