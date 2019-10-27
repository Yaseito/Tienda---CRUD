/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Entidades.Articulo;
import Modelo.Entidades.Medida;
import Modelo.ModeloArticulo;
import Modelo.ModeloMedida;
import java.util.List;
import javax.swing.JOptionPane;



/**
 *
 * @author Hijos
 */
public class ControladorArticulo {
    
      public void ActualizarArticulo(int idArticulo, String Descripcion, String dIngles, String idumCompra, String idumVenta, int cumCompra, double pvMayor, double pvMenor, double pCompra, double stock) {
        Medida medida = ModeloMedida.buscarMedida(Integer.parseInt(idumCompra));
        Medida medida2 = ModeloMedida.buscarMedida(Integer.parseInt(idumVenta));  
        if (ModeloArticulo.ActualizarArticulo(idArticulo, Descripcion, dIngles, medida, medida2, cumCompra, pvMayor, pvMenor, pCompra, stock)) {
            JOptionPane.showMessageDialog(null, "Actualizacion Correcta");
        } else {
            JOptionPane.showMessageDialog(null, "Actualizacion Incorrecta");
        }
    }

    public String[][] MostrarArticulo() {
        List<Articulo> lista = null;
        String[][] articulos = null;
        Articulo articulo = null;
        try {
            lista = ModeloArticulo.MostrarArticulo();
            articulos = new String[lista.size()][10];
            for (int i = 0; i < lista.size(); i++) {
                articulo = lista.get(i);
                articulos[i][0] = Integer.toString(articulo.getIdArticulo());
                articulos[i][1] = articulo.getDescripcion();
                articulos[i][2] = articulo.getDescripcionIngles();
                articulos[i][3] = articulo.getIdUnidadMedidaCompra().getSiglas();
                articulos[i][4] = articulo.getIdUnidadMedidaVenta().getSiglas();
                articulos[i][5] = Double.toString(articulo.getCantidadUnidadMedidaCompra());
                articulos[i][6] = Double.toString(articulo.getPrecioVentaMayor());
                articulos[i][7] = Double.toString(articulo.getPrecioVentaMenor());
                articulos[i][8] = Double.toString(articulo.getPrecioCompra());
                articulos[i][9] = Double.toString(articulo.getStock());
            }
            JOptionPane.showMessageDialog(null, "Mostrar Correcto");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return articulos;

    }

    public void RegistraArticulo(int idArticulo, String Descripcion, String dIngles, String idumCompra, String idumVenta, int cumCompra, double pvMayor, double pvMenor, double pCompra, double stock) {
        Medida medida = ModeloMedida.buscarMedida(Integer.parseInt(idumCompra));
        Medida medida2 = ModeloMedida.buscarMedida(Integer.parseInt(idumVenta));
        Articulo articulo = new Articulo(idArticulo, Descripcion, Descripcion, medida, medida2, cumCompra, pvMayor, pvMenor, pCompra, stock);
        if (ModeloArticulo.RegistraArticulo(articulo)) {
            JOptionPane.showMessageDialog(null, "Registro Correcto");
        } else {
            JOptionPane.showMessageDialog(null, "Registro Incorrecto");
        }

    }

    public void EliminaArticulo(int fila, String idArticulo) {
        if (fila >= 0) {
            if (ModeloArticulo.EliminaArticulo(fila, idArticulo)) {
                JOptionPane.showMessageDialog(null, "Eliminacion Correcta");
            } else {
                JOptionPane.showMessageDialog(null, "Eliminacion Incorrecta");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fila Inexistente");
        }

    } 
}
