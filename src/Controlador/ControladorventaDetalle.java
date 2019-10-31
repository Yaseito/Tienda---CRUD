/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Entidades.Articulo;
import Modelo.Entidades.Venta;
import Modelo.Entidades.ventaDetalle;
import Modelo.ModeloArticulo;
import Modelo.ModeloVenta;
import Modelo.ModeloventaDetalle;
import java.util.List;
import javax.swing.JOptionPane;



/**
 *
 * @author Hijos
 */
public class ControladorventaDetalle {
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
        List<ventaDetalle> lista = null;
        String[][] compraDetalles = null;
        ventaDetalle compraDetalle = null;
        try {
            lista = ModeloventaDetalle.MostrarcompraDetalle();
            compraDetalles = new String[lista.size()][4];
            for (int i = 0; i < lista.size(); i++) {
                compraDetalle = lista.get(i);
                compraDetalles[i][0] = Integer.toString(compraDetalle.getIdVentaDetalle());
                compraDetalles[i][1] = compraDetalle.getIdVenta().getNroDocumento();
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
        Venta c = ModeloVenta.buscarVenta(Integer.parseInt(idCompra));
        Articulo a = ModeloArticulo.buscarArticulo(Integer.parseInt(idArticulo));
        ventaDetalle dcompra = new ventaDetalle(idcompraDetalle, c, a, cantidad);
        if (ModeloventaDetalle.RegistracompraDetalle(dcompra)) {
            JOptionPane.showMessageDialog(null, "Registro Correcto");
        } else {
            JOptionPane.showMessageDialog(null, "Registro Incorrecto");
        }

    }

    public void EliminaCompra(int fila, String idCompra) {
        if (fila >= 0) {
            if (ModeloventaDetalle.EliminacompraDetalle(fila, idCompra)) {
                JOptionPane.showMessageDialog(null, "Eliminacion Correcta");
            } else {
                JOptionPane.showMessageDialog(null, "Eliminacion Incorrecta");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fila Inexistente");
        }

    }
}
