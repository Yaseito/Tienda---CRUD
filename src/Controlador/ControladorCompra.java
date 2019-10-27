/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Entidades.Compra;
import Modelo.Entidades.Documento;
import Modelo.Entidades.Proveedor;
import Modelo.ModeloCompra;
import Modelo.ModeloDocumento;
import Modelo.ModeloProveedor;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Hijos
 */
public class ControladorCompra {

    public void ActualizarCompra(int idCompra, String idDocumento, String serieDocumento, String nDocumento, Date fecha, String idProveedor) {
        Documento d = ModeloDocumento.buscarDocumento(Integer.parseInt(idDocumento));
        Proveedor p = ModeloProveedor.buscarProveedor(Integer.parseInt(idProveedor));
        if (ModeloCompra.ActualizarCompra(idCompra, d, serieDocumento, nDocumento, fecha, p)) {
            JOptionPane.showMessageDialog(null, "Actualizacion Correcta");
        } else {
            JOptionPane.showMessageDialog(null, "Actualizacion Incorrecta");
        }
    }

    public String[][] MostrarCompra() {
        List<Compra> lista = null;
        String[][] compras = null;
        Compra compra = null;
        try {
            lista = ModeloCompra.MostrarCompra();
            compras = new String[lista.size()][6];
            for (int i = 0; i < lista.size(); i++) {
                compra = lista.get(i);
                compras[i][0] = Integer.toString(compra.getIdCompra());
                compras[i][1] = compra.getIdDocumento().getSiglas();
                compras[i][2] = compra.getSerieDocumento();
                compras[i][3] = compra.getNroDocumento();
                compras[i][4] = String.valueOf(compra.getFecha());
                compras[i][5] = compra.getIdProveedor().getNroDocumento();

            }
            JOptionPane.showMessageDialog(null, "Mostrar Correcto");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return compras;

    }

    public void RegistraCompra(int idCompra, String idDocumento, String serieDocumento, String nDocumento, Date fecha, String idProveedor) {
        Documento d = ModeloDocumento.buscarDocumento(Integer.parseInt(idDocumento));
        Proveedor p = ModeloProveedor.buscarProveedor(Integer.parseInt(idProveedor));
        Compra compra = new Compra(idCompra, d, serieDocumento, nDocumento, fecha, p);
        if (ModeloCompra.RegistraCompra(compra)) {
            JOptionPane.showMessageDialog(null, "Registro Correcto");
        } else {
            JOptionPane.showMessageDialog(null, "Registro Incorrecto");
        }

    }

    public void EliminaCompra(int fila, String idCompra) {
        if (fila >= 0) {
            if (ModeloCompra.EliminaCompra(fila, idCompra)) {
                JOptionPane.showMessageDialog(null, "Eliminacion Correcta");
            } else {
                JOptionPane.showMessageDialog(null, "Eliminacion Incorrecta");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fila Inexistente");
        }

    }
}
