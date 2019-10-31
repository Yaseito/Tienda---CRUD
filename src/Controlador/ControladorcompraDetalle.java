/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Entidades.Articulo;
import Modelo.Entidades.Compra;
import Modelo.Entidades.compraDetalle;
import Modelo.ModeloArticulo;
import Modelo.ModeloCompra;
import Modelo.ModelocompraDetalle;
import java.util.List;
import javax.swing.JOptionPane;



/**
 *
 * @author Hijos
 */
public class ControladorcompraDetalle {
    /*
   public void ActualizarCompra(int idCompra, String idDocumento, String serieDocumento, String nDocumento, Date fecha, String idProveedor) {
        Documento d = ModeloDocumento.buscarDocumento(Integer.parseInt(idDocumento));
        Proveedor p = ModeloProveedor.buscarProveedor(Integer.parseInt(idProveedor));
        if (ModeloCompra.ActualizarCompra(idCompra, d, serieDocumento, nDocumento, fecha, p)) {
            JOptionPane.showMessageDialog(null, "Actualizacion Correcta");
        } else {
            JOptionPane.showMessageDialog(null, "Actualizacion Incorrecta");
        }
    }
*/
    public String[][] MostrarcompraDetalle() {
        List<compraDetalle> lista = null;
        String[][] compraDetalles = null;
        compraDetalle compraDetalle = null;
        try {
            lista = ModelocompraDetalle.MostrarcompraDetalle();
            compraDetalles = new String[lista.size()][4];
            for (int i = 0; i < lista.size(); i++) {
                compraDetalle = lista.get(i);
                compraDetalles[i][0] = Integer.toString(compraDetalle.getIdCompraDetalle());
                compraDetalles[i][1] = compraDetalle.getIdCompra().getNroDocumento();
                compraDetalles[i][2] = compraDetalle.getIdArticulo().getDescripcion();
                compraDetalles[i][3] = Double.toString(compraDetalle.getCantidad());
            }
            JOptionPane.showMessageDialog(null, "Mostrar Correcto");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return compraDetalles;

    }

    public void RegistraCompra(int idcompraDetalle, String idCompra, String idArticulo, double cantidad) {
        Compra c = ModeloCompra.buscarCompra(Integer.parseInt(idCompra));
        Articulo a = ModeloArticulo.buscarArticulo(Integer.parseInt(idArticulo));
        compraDetalle dcompra = new compraDetalle(idcompraDetalle, c, a, cantidad);
        if (ModelocompraDetalle.RegistracompraDetalle(dcompra)) {
            JOptionPane.showMessageDialog(null, "Registro Correcto");
        } else {
            JOptionPane.showMessageDialog(null, "Registro Incorrecto");
        }

    }

    public void EliminaCompra(int fila, String idCompra) {
        if (fila >= 0) {
            if (ModelocompraDetalle.EliminacompraDetalle(fila, idCompra)) {
                JOptionPane.showMessageDialog(null, "Eliminacion Correcta");
            } else {
                JOptionPane.showMessageDialog(null, "Eliminacion Incorrecta");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fila Inexistente");
        }

    }
}
