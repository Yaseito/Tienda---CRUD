/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Conexion.Conexion;
import Modelo.Entidades.Cliente;
import Modelo.Entidades.Proveedor;
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
public class ModeloProveedor {

    static private PreparedStatement ps;
    static private ResultSet rs;

    static public boolean ActualizarProveedor(int idProveedor, String rSocial, String tPersona, String nDocumento, String Direccion, String Telefono) {
        boolean band = false;
        Connection con = Conexion.getConexion();

        try {
            ps = con.prepareStatement("update proveedor set razonSocial=? ,tipoPersona=? , nroDocumento=? , direccion=? , telefono=? where idProveedor=" + idProveedor + ";");
            ps.setString(1, rSocial);
            ps.setString(2, tPersona);
            ps.setString(3, nDocumento);
            ps.setString(4, Direccion);
            ps.setString(5, Telefono);
            ps.executeUpdate();
            band = true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return band;
    }

    static public List<Proveedor> MostrarProveedor() {
        List<Proveedor> clientes = new ArrayList<Proveedor>();
        Connection con = Conexion.getConexion();
        try {

            ps = con.prepareStatement("select * from Proveedor");
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {

                int id = rs.getInt(1);
                String rSocial = rs.getString(2);
                String tPersona = rs.getString(3);
                String nDocumento = rs.getString(4);
                String Direccion = rs.getString(5);
                String Telefono = rs.getString(6);

                Proveedor p = new Proveedor(id, rSocial, tPersona, nDocumento, Direccion, Telefono);

                clientes.add(i, p);
                i++;
            }
            con.close();
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());

        }
        return clientes;
    }

    static public boolean RegistraProveedor(Proveedor proveedor) {
        boolean band = false;
        Connection con = Conexion.getConexion();
        try {
            ps = con.prepareStatement("insert into Proveedor(idProveedor, razonSocial, tipoPersona, nrodocumento, direccion, telefono) values\n"
                    + "(?,?,?,?,?,?);");

            ps.setInt(1, (int) proveedor.getIdProveedor());
            ps.setString(2, proveedor.getRazonSozial());//Cambiar por Social
            ps.setString(3, proveedor.getTipoPersona());
            ps.setString(4, proveedor.getNroDocumento());
            ps.setString(5, proveedor.getDireccion());
            ps.setString(6, proveedor.getTelefono());

            ps.executeUpdate();
            band = true;
            con.close();
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());

        }
        return band;

    }

    static public boolean EliminaProveedor(String idProveedor) {
        boolean band = false;
        Connection con = Conexion.getConexion();

        try {

            PreparedStatement ps = con.prepareStatement("Delete from Proveedor where idProveedor=" + idProveedor + ";");
            ps.executeUpdate();

            band = true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return band;
    }
    
    public static Proveedor buscarProveedor(int idProveedor) {
        Proveedor proveedor = null;
        Connection con = Conexion.getConexion();

        try {
            PreparedStatement ps = con.prepareStatement("select * from proveedor where idProveedor=" + idProveedor + ";");
            rs = ps.executeQuery();
            while (rs.next()) {

                int id = rs.getInt(1);
                String rSocial = rs.getString(2);
                String tPersona = rs.getString(3);
                String nDocumento = rs.getString(4);
                String Direccion = rs.getString(5);
                String Telefono = rs.getString(6);

                proveedor = new Proveedor(id, rSocial, tPersona, nDocumento, Direccion, Telefono);

            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return proveedor;
    }
}
