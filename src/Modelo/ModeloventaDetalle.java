/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Conexion.Conexion;
import Modelo.Entidades.Articulo;
import Modelo.Entidades.Cliente;
import Modelo.Entidades.Documento;
import Modelo.Entidades.Medida;
import Modelo.Entidades.Venta;
import Modelo.Entidades.ventaDetalle;
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
public class ModeloventaDetalle {
        static private PreparedStatement ps;
    static private ResultSet rs;
/*
    static public boolean ActualizarcompraDetalle(int idcompraDetalle, Compra idCompra, Articulo idArticulo, String cantidad) {
        boolean band = false;
        Connection con = Conexion.getConexion();
        String idC = String.valueOf(idCompra.getIdCompra());
        String idA = String.valueOf(idArticulo.getIdArticulo());
        try {
            ps = con.prepareStatement("update compraDetalle set idCompra=? ,idArticulo=? , cantidad=? where idCompraDetalle=" + idcompraDetalle + ";");
            ps.setString(1, idC);
            ps.setString(2, idA);
            ps.setString(3, cantidad);        
            ps.executeUpdate();
            band = true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return band;
    }
*/
    static public List<ventaDetalle> MostrarcompraDetalle() {
        List<ventaDetalle> compraDetalles = new ArrayList<ventaDetalle>();
        Connection con = Conexion.getConexion();
        Venta c = null;
        Articulo a = null;
        Medida m = null;
        Medida m2 = null;
        Cliente p = null;
        Documento d = null;
        try {

            ps = con.prepareStatement("select m.idMedida, m.descripcion, m.siglas, "
                    + "m2.idMedida, m2.descripcion, m2.siglas, "
                    + "a.idArticulo, a.descripcion, a.descripcionIngles, a.cantidadUnidadMedidaCompra, a.precioVentaMayor, a.precioVentaMenor, a.precioCompra, a.stock, "
                    +"p.idCliente, p.razonSocial, p.tipoPersona, p.nrodocumento, p.direccion , p.telefono, "
                    + "d.idDocumento, d.descripcion, d.siglas, "
                    + "c.idVenta , c.serieDocumento  , c.nroDocumento  ,c.fecha, "
                    +"cd.idVentaDetalle, cd.cantidad"
                    + " from venta c, articulo a, ventaDetalle cd, cliente p, documento d, medida m, medida m2"
                    + " where cd.idVenta = c.idVenta and cd.idArticulo = a.idArticulo and m.idMedida= a.idUnidadMedidaCompra and m2.idMedida= a.idUnidadMedidaVenta and c.idDocumento=d.idDocumento and p.idCliente=c.idCliente");
            rs = ps.executeQuery(); 
            int i = 0;
            while (rs.next()) {

                int idMedidac = rs.getInt(1);
                String mdescripcionc = rs.getString(2);
                String msiglasc = rs.getString(3);
                m = new Medida(idMedidac, mdescripcionc, msiglasc);
                
                int idMedidav = rs.getInt(4);
                String mdescripcionv = rs.getString(5);
                String msiglasv = rs.getString(6);
                m2 = new Medida(idMedidav, mdescripcionv, msiglasv);
                
                int idArticulo = rs.getInt(7);
                String descripcion = rs.getString(8);
                String descripcionIngles = rs.getString(9);
                int cantidadUnidadMedidaCompra = rs.getInt(10);
                double precioVentaMayor = rs.getDouble(11);
                double precioVentaMenor = rs.getDouble(12);
                double precioCompra = rs.getDouble(13);
                double stock = rs.getDouble(14);
                a = new Articulo(idArticulo, descripcion, descripcionIngles, m, m2, cantidadUnidadMedidaCompra, precioVentaMayor, precioVentaMenor, precioCompra, stock);
                
                int idProveedor = rs.getInt(15);
                String razonSocial = rs.getString(16);
                String tipoPersona = rs.getString(17);
                String nrodocumento = rs.getString(18);
                String direccion = rs.getString(19);
                String telefono = rs.getString(20);
                p = new Cliente(idProveedor, razonSocial, tipoPersona, nrodocumento, direccion, telefono);
                
                int idDocumento = rs.getInt(21);
                String descripciond = rs.getString(22);
                String siglasd = rs.getString(23);
                d = new Documento(idDocumento, descripciond, siglasd);
                
                int idCompra = rs.getInt(24);
                String serieDocumentoc = rs.getString(25);
                String nroDocumentoc = rs.getString(26);
                Date fecha = rs.getDate(27);
                c = new Venta(idCompra, d, serieDocumentoc, nroDocumentoc, fecha, p);
                
                int idCompraDetalle = rs.getInt(28);
                double cantidad = rs.getDouble(29);

                ventaDetalle cd = new ventaDetalle(idCompraDetalle, c, a, cantidad);
                        
                compraDetalles.add(i, cd);
                i++;
            }
            con.close();
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());

        }
        return compraDetalles;
    }

    static public boolean RegistracompraDetalle(ventaDetalle compraD) {
        boolean band = false;
        Connection con = Conexion.getConexion();
        try {
            ps = con.prepareStatement("insert into ventaDetalle(idVentaDetalle, idVenta, idArticulo, cantidad) values\n"
                    + "(?,?,?,?);");

            ps.setInt(1, (int) compraD.getIdVentaDetalle());
            ps.setInt(2, (int) compraD.getIdVenta().getIdVenta());
            ps.setInt(3, (int) compraD.getIdArticulo().getIdArticulo());
            ps.setDouble(4, compraD.getCantidad());         

            ps.executeUpdate();
            
            band = true;
            con.close();
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());

        }
        return band;

    }

    static public boolean EliminacompraDetalle(int fila, String idcompraDetalle) {
        boolean band = false;
        Connection con = Conexion.getConexion();

        try {

            PreparedStatement ps = con.prepareStatement("Delete from venta where idVenta=" + idcompraDetalle + ";");
            ps.executeUpdate();

            band = true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return band;
    }
    /*
    public static Compra buscarcompraDetalle(int idCompra) {
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
    }*/
}


