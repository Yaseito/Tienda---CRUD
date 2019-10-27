/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Entidades.Cliente;
import Modelo.ModeloCliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Hijos
 */
public class ControladorCliente {

    public void ActualizarCliente(int idCliente, String rSocial, String tPersona, String nDocumento, String Direccion, String Telefono) {

        if (ModeloCliente.ActualizarCliente(idCliente, rSocial, tPersona, nDocumento, Direccion, Telefono)) {
            JOptionPane.showMessageDialog(null, "Actualizacion Correcta");
        } else {
            JOptionPane.showMessageDialog(null, "Actualizacion Incorrecta");
        }
    }

    public String[][] MostrarCliente() {
        List<Cliente> lista = null;
        String[][] clientes = null;
        Cliente cliente = null;
        try {
            lista = ModeloCliente.MostrarCliente();
            clientes = new String[lista.size()][6];
            for (int i = 0; i < lista.size(); i++) {
                cliente = lista.get(i);
                clientes[i][0] = Integer.toString(cliente.getIdCliente());
                clientes[i][1] = cliente.getRazonSocial();
                clientes[i][2] = cliente.getTipoPersona();
                clientes[i][3] = cliente.getNroDocumento();
                clientes[i][4] = cliente.getDireccion();
                clientes[i][5] = cliente.getTelefono();
            }
            JOptionPane.showMessageDialog(null, "Mostrar Correcto");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return clientes;

    }

    public void RegistraCliente(int idCliente, String rSocial, String tPersona, String nDocumento, String Direccion, String Telefono) {

        Cliente cliente = new Cliente(idCliente, rSocial, tPersona, nDocumento, Direccion, Telefono);
        if (ModeloCliente.RegistraCliente(cliente)) {
            JOptionPane.showMessageDialog(null, "Registro Correcto");
        } else {
            JOptionPane.showMessageDialog(null, "Registro Incorrecto");
        }

    }

    public void EliminaCliente(int fila, String idCliente) {
        if (fila >= 0) {
            if (ModeloCliente.EliminaCliente(idCliente)) {
                JOptionPane.showMessageDialog(null, "Eliminacion Correcta");
            } else {
                JOptionPane.showMessageDialog(null, "Eliminacion Incorrecta");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fila Inexistente");
        }

    }

}
