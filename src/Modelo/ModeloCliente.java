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
public class ModeloCliente {

    static private PreparedStatement ps;
    static private ResultSet rs;

    static public boolean ActualizarCliente(int idCliente, String rSocial, String tPersona, String nDocumento, String Direccion, String Telefono) {
        boolean band = false;
        Connection con = Conexion.getConexion();

        try {
            ps = con.prepareStatement("update Cliente set razonSocial=? ,tipoPersona=? , nroDocumento=? , direccion=? , telefono=? where idCliente=" + idCliente + ";");
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

    static public List<Cliente> MostrarCliente() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        Connection con = Conexion.getConexion();
        try {

            ps = con.prepareStatement("select * from cliente");
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {

                int id = rs.getInt(1);
                String rSocial = rs.getString(2);
                String tPersona = rs.getString(3);
                String nDocumento = rs.getString(4);
                String Direccion = rs.getString(5);
                String Telefono = rs.getString(6);

                Cliente c = new Cliente(id, rSocial, tPersona, nDocumento, Direccion, Telefono);

                clientes.add(i, c);
                i++;
            }
            con.close();
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());

        }
        return clientes;
    }

    static public boolean RegistraCliente(Cliente cliente) {
        boolean band = false;
        Connection con = Conexion.getConexion();
        try {
            ps = con.prepareStatement("insert into Cliente(idCliente, razonSocial, tipoPersona, nrodocumento, direccion, telefono) values\n"
                    + "(?,?,?,?,?,?);");

            ps.setInt(1, (int) cliente.getIdCliente());
            ps.setString(2, cliente.getRazonSocial());
            ps.setString(3, cliente.getTipoPersona());
            ps.setString(4, cliente.getNroDocumento());
            ps.setString(5, cliente.getDireccion());
            ps.setString(6, cliente.getTelefono());

            ps.executeUpdate();
            band = true;
            con.close();
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());

        }
        return band;

    }

    static public boolean EliminaCliente(String idCliente) {
        boolean band = false;
        Connection con = Conexion.getConexion();

        try {

            PreparedStatement ps = con.prepareStatement("Delete from Cliente where idCliente=" + idCliente + ";");
            ps.executeUpdate();

            band = true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return band;
    }

    public static Cliente buscarCliente(int idCliente) {
        Cliente cliente = null;
        Connection con = Conexion.getConexion();

        try {
            PreparedStatement ps = con.prepareStatement("select * from Cliente where idCliente=" + idCliente + ";");
            rs = ps.executeQuery();
            while (rs.next()) {

                int id = rs.getInt(1);
                String rSocial = rs.getString(2);
                String tPersona = rs.getString(3);
                String nDocumento = rs.getString(4);
                String Direccion = rs.getString(5);
                String Telefono = rs.getString(6);

                cliente = new Cliente(id, rSocial, tPersona, nDocumento, Direccion, Telefono);

            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return cliente;
    }
}
