/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Conexion.Conexion;
import Modelo.Entidades.Documento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author Hijos
 */
public class ModeloDocumento {
    static private PreparedStatement ps;
    static private ResultSet rs;

    static public boolean ActualizarDocumento(int idDocumento, String Descripcion, String Siglas) {
        boolean band = false;
        Connection con = Conexion.getConexion();

        try {
            ps = con.prepareStatement("update documento set descripcion=? ,siglas=? where idDocumento=" + idDocumento + ";");
            ps.setString(1, Descripcion);
            ps.setString(2, Siglas);
            ps.executeUpdate();
            band = true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return band;
    }

    static public List<Documento> MostrarDocumento() {
        List<Documento> documentos = new ArrayList<Documento>();
        Connection con = Conexion.getConexion();
        try {

            ps = con.prepareStatement("select * from Documento");
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {

                int id = rs.getInt(1);
                String Descripcion = rs.getString(2);
                String Siglas = rs.getString(3);

                Documento m = new Documento(id, Descripcion, Siglas);

                documentos.add(i, m);
                i++;
            }
            con.close();
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());

        }
        return documentos;
    }

    static public boolean RegistraDocumento(Documento documento) {
        boolean band = false;
        Connection con = Conexion.getConexion();
        try {
            ps = con.prepareStatement("insert into Documento(idDocumento, descripcion, siglas) values\n"
                    + "(?,?,?);");

            ps.setInt(1, (int) documento.getIdDocumento());
            ps.setString(2, documento.getDescripcion());
            ps.setString(3, documento.getSiglas());

            ps.executeUpdate();
            band = true;
            con.close();
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());

        }
        return band;

    }

    static public boolean EliminaDocumento(String idDocumento) {
        boolean band = false;
        Connection con = Conexion.getConexion();

        try {

            PreparedStatement ps = con.prepareStatement("Delete from Documento where idDocumento=" + idDocumento + ";");
            ps.executeUpdate();

            band = true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return band;
    }

    public static Documento buscarDocumento(int idDocumento) {
        Documento documento = null;
        Connection con = Conexion.getConexion();

        try {
            PreparedStatement ps = con.prepareStatement("select * from Documento where idDocumento=" + idDocumento + ";");
            rs = ps.executeQuery();
            while (rs.next()) {

                int id = rs.getInt(1);
                String Descripcion = rs.getString(2);
                String Siglas = rs.getString(3);

                documento = new Documento(id, Descripcion, Siglas);

            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return documento;
    }
}
