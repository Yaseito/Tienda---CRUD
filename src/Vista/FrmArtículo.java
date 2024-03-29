/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorArticulo;

/**
 *
 * @author Hijos
 */
public class FrmArtículo extends javax.swing.JFrame {

    ControladorArticulo cnt;

    /**
     * Creates new form FrmArtículo
     */
    public FrmArtículo() {
        initComponents();
        cnt = new ControladorArticulo();
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
        tblArticulo = new javax.swing.JTable();
        txtid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtidumCompra = new javax.swing.JTextField();
        txtdIngles = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtpvMenor = new javax.swing.JTextField();
        btnRegistra = new javax.swing.JButton();
        btnModifica = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        btnElimina = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtidumVenta = new javax.swing.JTextField();
        txtcumCompra = new javax.swing.JTextField();
        txtpvMayor = new javax.swing.JTextField();
        txtpCompra = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        cmbArticulo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Artículo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        tblArticulo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblArticulo);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 44, 900, 93));
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 80, -1));

        jLabel2.setText("ID Artículo:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel3.setText("Descripción:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel4.setText("Descripción Inglés:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel5.setText("Id Unidad Compra:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel6.setText("ID Unidad Venta:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jLabel7.setText("Cantidad Unidad Compra:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, -1, -1));
        getContentPane().add(txtidumCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 70, -1));
        getContentPane().add(txtdIngles, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 300, -1));
        getContentPane().add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 300, -1));
        getContentPane().add(txtpvMenor, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, 80, -1));

        btnRegistra.setText("Registrar");
        btnRegistra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistraActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistra, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, -1, -1));

        btnModifica.setText("Modificar");
        btnModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificaActionPerformed(evt);
            }
        });
        getContentPane().add(btnModifica, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, -1, -1));

        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, -1, -1));

        btnElimina.setText("Eliminar");
        btnElimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminaActionPerformed(evt);
            }
        });
        getContentPane().add(btnElimina, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 340, -1, -1));

        jLabel8.setText("Precio Venta Mayor:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, -1, -1));

        jLabel9.setText("Precio Venta Menor:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, -1, -1));

        jLabel10.setText("Precio Compra:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, -1, -1));

        jLabel11.setText("Stock:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, -1, -1));
        getContentPane().add(txtidumVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 70, -1));
        getContentPane().add(txtcumCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 170, 80, -1));
        getContentPane().add(txtpvMayor, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 200, 80, -1));

        txtpCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpCompraActionPerformed(evt);
            }
        });
        getContentPane().add(txtpCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 260, 80, -1));
        getContentPane().add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 290, 80, -1));

        cmbArticulo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistraActionPerformed
        int id = 0;
        String descripcion = null;
        String descripcionIngles = null;
        String idUnidadMedidaCompra = null;
        String idUnidadMedidaVenta = null;
        int cantidadUnidadMedidaCompra = 0;
        double precioVentaMayor = 0.0;
        double precioVentaMenor = 0.0;
        double precioCompra = 0.0;
        double stock = 0.0;

        id = Integer.parseInt(txtid.getText());
        descripcion = String.valueOf(txtDescripcion.getText());
        descripcionIngles = String.valueOf(txtdIngles.getText());
        idUnidadMedidaCompra = String.valueOf(txtidumCompra.getText());
        idUnidadMedidaVenta = String.valueOf(txtidumVenta.getText());
        cantidadUnidadMedidaCompra = Integer.parseInt(txtcumCompra.getText());
        precioVentaMayor = Double.parseDouble(txtpvMayor.getText());
        precioVentaMenor = Double.parseDouble(txtpvMenor.getText());
        precioCompra = Double.parseDouble(txtpCompra.getText());
        stock = Double.parseDouble(txtStock.getText());

        cnt.RegistraArticulo(id, descripcion, descripcionIngles,
                idUnidadMedidaCompra,
                idUnidadMedidaVenta, cantidadUnidadMedidaCompra, precioVentaMayor,
                 precioVentaMenor, precioCompra, stock);

        limpiar();
    }//GEN-LAST:event_btnRegistraActionPerformed

    private void btnModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificaActionPerformed
        int id, cantidadUnidadMedidaCompra;
        String descripcion, descripcionIngles, idUnidadMedidaCompra, idUnidadMedidaVenta;
        double precioVentaMayor,precioVentaMenor,precioCompra,stock;

        id = Integer.parseInt(txtid.getText());
        descripcion = txtDescripcion.getText();
        descripcionIngles = txtdIngles.getText();
        idUnidadMedidaCompra = txtidumCompra.getText();
        idUnidadMedidaVenta = txtidumVenta.getText();
        cantidadUnidadMedidaCompra = Integer.parseInt(txtcumCompra.getText());
        precioVentaMayor = Double.parseDouble(txtpvMayor.getText());
        precioVentaMenor = Double.parseDouble(txtpvMenor.getText());
        precioCompra = Double.parseDouble(txtpCompra.getText());
        stock = Double.parseDouble(txtStock.getText());
        
        cnt.ActualizarArticulo(id, descripcion, descripcionIngles, idUnidadMedidaCompra, idUnidadMedidaVenta, cantidadUnidadMedidaCompra, precioVentaMayor, precioVentaMenor, precioCompra, stock);

        limpiar();
    }//GEN-LAST:event_btnModificaActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        tblArticulo.setModel(new javax.swing.table.DefaultTableModel(
                cnt.MostrarArticulo(),
                new String[]{
                    "ID Articulo", "Descripcion", "D Ingles", "Medida Compra", "Medida Venta", "Cantidad MedidaCompra", "Precio Venta Mayor"
                        , "Precio Venta Menor", "Precio Compra", "Stock"
                }
        ));
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnEliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaActionPerformed

        int fila = tblArticulo.getSelectedRow();
        String idArticulo = tblArticulo.getValueAt(fila, 0).toString();
        cnt.EliminaArticulo(fila, idArticulo);
    }//GEN-LAST:event_btnEliminaActionPerformed

    private void txtpCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpCompraActionPerformed
    
    public void limpiar() {
        txtid.setText("");
        txtDescripcion.setText("");
        txtdIngles.setText("");
        txtStock.setText("");
        txtcumCompra.setText("");
        txtidumCompra.setText("");
        txtidumVenta.setText("");
        txtpCompra.setText("");
        txtpvMayor.setText("");
        txtpvMenor.setText("");
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
            java.util.logging.Logger.getLogger(FrmArtículo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmArtículo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmArtículo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmArtículo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmArtículo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnElimina;
    private javax.swing.JButton btnModifica;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnRegistra;
    private javax.swing.JComboBox<String> cmbArticulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblArticulo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtcumCompra;
    private javax.swing.JTextField txtdIngles;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtidumCompra;
    private javax.swing.JTextField txtidumVenta;
    private javax.swing.JTextField txtpCompra;
    private javax.swing.JTextField txtpvMayor;
    private javax.swing.JTextField txtpvMenor;
    // End of variables declaration//GEN-END:variables
}
