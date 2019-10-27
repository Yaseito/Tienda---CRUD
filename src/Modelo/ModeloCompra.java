/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Conexion.Conexion;
import Modelo.Entidades.Articulo;
import Modelo.Entidades.Compra;
import Modelo.Entidades.Documento;
import Modelo.Entidades.Medida;
import Modelo.Entidades.Proveedor;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;



/**
 *
 * @author Hijos
 */
public class ModeloCompra {
    static private PreparedStatement ps;
    static private ResultSet rs;

    static public boolean ActualizarCompra(int idCompra, Documento idDocumento, String serieDocumento, String nDocumento, Date fecha, Proveedor idProveedor) {
        boolean band = false;
        Connection con = Conexion.getConexion();
        String idD = String.valueOf(idDocumento.getIdDocumento());
        String idP = String.valueOf(idProveedor.getIdProveedor());
        String cfecha = String.valueOf(fecha);
        try {
            ps = con.prepareStatement("update compra set idDocumento=? ,serieDocumento=? , nroDocumento=? , fecha=? , idProveedor=? where idCompra=" + idCompra + ";");
            ps.setString(1, idD);
            ps.setString(2, serieDocumento);
            ps.setString(3, nDocumento);
            ps.setString(4, cfecha);
            ps.setString(5, idP);         
            ps.executeUpdate();
            band = true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return band;
    }

    static public List<Compra> MostrarCompra() {
        List<Compra> compras = new ArrayList<Compra>();
        Connection con = Conexion.getConexion();
        Documento d = null;
        Proveedor p = null;
        try {

            ps = con.prepareStatement("select c.idCompra, d.idDocumento, d.descripcion, d.siglas, c.serieDocumento , "
                    + "c.nroDocumento , c.fecha, p.idProveedor  , p.razonSocial  ,p.tipoPersona  ,p.nrodocumento  ,p.direccion  ,p.telefono "
                    + " from compra c, documento d, proveedor p"
                    + " where c.idDocumento = d.idDocumento and c.idProveedor = p.idProveedor");
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {

                int id = rs.getInt(1);
                int idumCompra = rs.getInt(2);
                String cdescripcion = rs.getString(3);
                String csiglas = rs.getString(4);
                d = new Documento(idumCompra, cdescripcion, csiglas);
                String sDocumento = rs.getString(5);
                String nDocumento = rs.getString(6);
                Date fecha = rs.getDate(7);
                int idumVenta = rs.getInt(8);
                String razonSocial = rs.getString(9);
                String tipoPersona = rs.getString(10);
                String numeroDocumento = rs.getString(11);
                String direccion = rs.getString(12);
                String telefono = rs.getString(13);
                p = new Proveedor(idumVenta, razonSocial, tipoPersona, numeroDocumento, direccion, telefono);

                Compra c = new Compra(id, d, sDocumento, nDocumento, fecha, p);

                compras.add(i, c);
                i++;
            }
            con.close();
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());

        }
        return compras;
    }

    static public boolean RegistraCompra(Compra articulo) {
        boolean band = false;
        Connection con = Conexion.getConexion();
        try {
            ps = con.prepareStatement("insert into compra(idCompra, idDocumento, serieDocumento, nroDocumento, "
                    + "fecha, idProveedor) values\n"
                    + "(?,?,?,?,?,?);");

            ps.setInt(1, (int) articulo.getIdCompra());
            ps.setInt(2, (int) articulo.getIdDocumento().getIdDocumento());
            ps.setString(3, articulo.getSerieDocumento());
            ps.setString(4, articulo.getNroDocumento());
            ps.setDate(5, (java.sql.Date) articulo.getFecha());
            ps.setInt(6, (int) articulo.getIdProveedor().getIdProveedor());          

            ps.executeUpdate();
            band = true;
            con.close();
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());

        }
        return band;

    }

    static public boolean EliminaCompra(int fila, String idCompra) {
        boolean band = false;
        Connection con = Conexion.getConexion();

        try {

            PreparedStatement ps = con.prepareStatement("Delete from compra where idCompra=" + idCompra + ";");
            ps.executeUpdate();

            band = true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return band;
    }
    
    public static Compra buscarCompra(int idCompra) {
        Compra compra = null;
        Connection con = Conexion.getConexion();
        Documento d = null;
        Proveedor p = null;
        try {
            PreparedStatement ps = con.prepareStatement("\"select c.idCompra, d.idDocumento, d.descripcion, d.siglas, c.serieDocumento , "
                    + "c.nroDocumento , c.fecha, p.idProveedor  , p.razonSocial  ,p.tipoPersona  ,p.nrodocumento  ,p.direccion  ,p.telefono "
                    + " from compra c, documento d, proveedor p"
                    + " where c.idDocumento = d.idDocumento and c.idProveedor = p.idProveedor and idCompra=" + idCompra + ";");
            rs = ps.executeQuery();
            while (rs.next()) {

                int id = rs.getInt(1);
                int idumCompra = rs.getInt(2);
                String cdescripcion = rs.getString(3);
                String csiglas = rs.getString(4);
                d = new Documento(idumCompra, cdescripcion, csiglas);
                String sDocumento = rs.getString(5);
                String nDocumento = rs.getString(6);
                Date fecha = rs.getDate(7);
                int idumVenta = rs.getInt(8);
                String razonSocial = rs.getString(9);
                String tipoPersona = rs.getString(10);
                String numeroDocumento = rs.getString(11);
                String direccion = rs.getString(12);
                String telefono = rs.getString(13);
                p = new Proveedor(idumVenta, razonSocial, tipoPersona, numeroDocumento, direccion, telefono);

                compra = new Compra(id, d, sDocumento, nDocumento, fecha, p);

            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return compra;
    }
}

