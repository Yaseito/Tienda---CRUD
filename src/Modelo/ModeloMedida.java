/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Conexion.Conexion;
import Modelo.Entidades.Cliente;
import Modelo.Entidades.Medida;
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
public class ModeloMedida {

    static private PreparedStatement ps;
    static private ResultSet rs;

    static public boolean ActualizarMedida(int idMedida, String Descripcion, String Siglas) {
        boolean band = false;
        Connection con = Conexion.getConexion();

        try {
            ps = con.prepareStatement("update Medida set descripcion=? ,siglas=? where idMedida=" + idMedida + ";");
            ps.setString(1, Descripcion);
            ps.setString(2, Siglas);
            ps.executeUpdate();
            band = true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return band;
    }

    static public List<Medida> MostrarMedida() {
        List<Medida> medidas = new ArrayList<Medida>();
        Connection con = Conexion.getConexion();
        try {

            ps = con.prepareStatement("select * from Medida");
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {

                int id = rs.getInt(1);
                String Descripcion = rs.getString(2);
                String Siglas = rs.getString(3);

                Medida m = new Medida(id, Descripcion, Siglas);

                medidas.add(i, m);
                i++;
            }
            con.close();
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());

        }
        return medidas;
    }

    static public boolean RegistraMedida(Medida medida) {
        boolean band = false;
        Connection con = Conexion.getConexion();
        try {
            ps = con.prepareStatement("insert into medida(idMedida, descripcion, siglas) values\n"
                    + "(?,?,?);");

            ps.setInt(1, (int) medida.getIdMedida());
            ps.setString(2, medida.getDescripcion());
            ps.setString(3, medida.getSiglas());

            ps.executeUpdate();
            band = true;
            con.close();
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());

        }
        return band;

    }

    static public boolean EliminaMedida(String idMedida) {
        boolean band = false;
        Connection con = Conexion.getConexion();

        try {

            PreparedStatement ps = con.prepareStatement("Delete from Medida where idMedida=" + idMedida + ";");
            ps.executeUpdate();

            band = true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return band;
    }

    public static Medida buscarMedida(int idMedida) {
        Medida medida = null;
        Connection con = Conexion.getConexion();

        try {
            PreparedStatement ps = con.prepareStatement("select * from Medida where idMedida=" + idMedida + ";");
            rs = ps.executeQuery();
            while (rs.next()) {

                int id = rs.getInt(1);
                String Descripcion = rs.getString(2);
                String Siglas = rs.getString(3);

                medida = new Medida(id, Descripcion, Siglas);

            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return medida;
    }
}
