/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Entidades.Cliente;
import Modelo.Entidades.Proveedor;
import Modelo.ModeloCliente;
import Modelo.ModeloProveedor;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Hijos
 */
public class ControladorProveedor {
      public void ActualizarProveedor(int idProveedor, String rSocial, String tPersona, String nDocumento, String Direccion, String Telefono) {

        if (ModeloProveedor.ActualizarProveedor(idProveedor, rSocial, tPersona, nDocumento, Direccion, Telefono)) {
            JOptionPane.showMessageDialog(null, "Actualizacion Correcta");
        } else {
            JOptionPane.showMessageDialog(null, "Actualizacion Incorrecta");
        }
    }

    public String[][] MostrarProveedor() {
        List<Proveedor> lista = null;
        String[][] proveedores = null;
        Proveedor proveedor = null;
        try {
            lista = ModeloProveedor.MostrarProveedor();
            proveedores = new String[lista.size()][6];
            for (int i = 0; i < lista.size(); i++) {
                proveedor = lista.get(i);
                proveedores[i][0] = Integer.toString(proveedor.getIdProveedor());
                proveedores[i][1] = proveedor.getRazonSozial();
                proveedores[i][2] = proveedor.getTipoPersona();
                proveedores[i][3] = proveedor.getNroDocumento();
                proveedores[i][4] = proveedor.getDireccion();
                proveedores[i][5] = proveedor.getTelefono();
            }
            JOptionPane.showMessageDialog(null, "Mostrar Correcto");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return proveedores;

    }

    public void RegistraProveedor(int idProveedor, String rSocial, String tPersona, String nDocumento, String Direccion, String Telefono) {

        Proveedor proveedor = new Proveedor(idProveedor, rSocial, tPersona, nDocumento, Direccion, Telefono);
        if (ModeloProveedor.RegistraProveedor(proveedor)) {
            JOptionPane.showMessageDialog(null, "Registro Correcto");
        } else {
            JOptionPane.showMessageDialog(null, "Registro Incorrecto");
        }

    }

    public void EliminaProveedor(int fila, String idProveedor) {
        if (fila >= 0) {
            if (ModeloProveedor.EliminaProveedor(idProveedor)) {
                JOptionPane.showMessageDialog(null, "Eliminacion Correcta");
            } else {
                JOptionPane.showMessageDialog(null, "Eliminacion Incorrecta");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fila Inexistente");
        }

    } 
}
