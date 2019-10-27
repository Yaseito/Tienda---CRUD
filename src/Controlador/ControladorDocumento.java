/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Entidades.Documento;
import Modelo.Entidades.Medida;
import Modelo.ModeloDocumento;
import Modelo.ModeloMedida;
import java.util.List;
import javax.swing.JOptionPane;



/**
 *
 * @author Hijos
 */
public class ControladorDocumento {
        public void ActualizarDocumento(int idMedida, String Descripcion, String Siglas) {

        if (ModeloDocumento.ActualizarDocumento(idMedida, Descripcion, Siglas)) {
            JOptionPane.showMessageDialog(null, "Actualizacion Correcta");
        } else {
            JOptionPane.showMessageDialog(null, "Actualizacion Incorrecta");
        }
    }

    public String[][] MostrarDocumento() {
        List<Documento> lista = null;
        String[][] medidas = null;
        Documento medida = null;
        try {
            lista = ModeloDocumento.MostrarDocumento();
            medidas = new String[lista.size()][3];
            for (int i = 0; i < lista.size(); i++) {
                medida = lista.get(i);
                medidas[i][0] = Integer.toString(medida.getIdDocumento());
                medidas[i][1] = medida.getDescripcion();
                medidas[i][2] = medida.getSiglas();
            }
            JOptionPane.showMessageDialog(null, "Mostrar Correcto");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return medidas;

    }

    public void RegistraDocumento(int idMedida, String Descripcion, String Siglas) {

        Documento medida = new Documento(idMedida, Descripcion, Siglas);
        if (ModeloDocumento.RegistraDocumento(medida)) {
            JOptionPane.showMessageDialog(null, "Registro Correcto");
        } else {
            JOptionPane.showMessageDialog(null, "Registro Incorrecto");
        }

    }

    public void EliminaDocumento(int fila, String idMedida) {
        if (fila >= 0) {
            if (ModeloDocumento.EliminaDocumento(idMedida)) {
                JOptionPane.showMessageDialog(null, "Eliminacion Correcta");
            } else {
                JOptionPane.showMessageDialog(null, "Eliminacion Incorrecta");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fila Inexistente");
        }

    }
}
