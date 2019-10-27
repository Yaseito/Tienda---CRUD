/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Entidades.Medida;
import Modelo.ModeloMedida;
import java.util.List;
import javax.swing.JOptionPane;




/**
 *
 * @author Hijos
 */
public class ControladorMedida {
    public void ActualizarMedida(int idMedida, String Descripcion, String Siglas) {

        if (ModeloMedida.ActualizarMedida(idMedida, Descripcion, Siglas)) {
            JOptionPane.showMessageDialog(null, "Actualizacion Correcta");
        } else {
            JOptionPane.showMessageDialog(null, "Actualizacion Incorrecta");
        }
    }

    public String[][] MostrarMedida() {
        List<Medida> lista = null;
        String[][] medidas = null;
        Medida medida = null;
        try {
            lista = ModeloMedida.MostrarMedida();
            medidas = new String[lista.size()][3];
            for (int i = 0; i < lista.size(); i++) {
                medida = lista.get(i);
                medidas[i][0] = Integer.toString(medida.getIdMedida());
                medidas[i][1] = medida.getDescripcion();
                medidas[i][2] = medida.getSiglas();
            }
            JOptionPane.showMessageDialog(null, "Mostrar Correcto");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return medidas;

    }

    public void RegistraMedida(int idMedida, String Descripcion, String Siglas) {

        Medida medida = new Medida(idMedida, Descripcion, Siglas);
        if (ModeloMedida.RegistraMedida(medida)) {
            JOptionPane.showMessageDialog(null, "Registro Correcto");
        } else {
            JOptionPane.showMessageDialog(null, "Registro Incorrecto");
        }

    }

    public void EliminaMedida(int fila, String idMedida) {
        if (fila >= 0) {
            if (ModeloMedida.EliminaMedida(idMedida)) {
                JOptionPane.showMessageDialog(null, "Eliminacion Correcta");
            } else {
                JOptionPane.showMessageDialog(null, "Eliminacion Incorrecta");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fila Inexistente");
        }

    }
}
