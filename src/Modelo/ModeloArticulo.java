/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Conexion.Conexion;
import Modelo.Entidades.Articulo;
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
public class ModeloArticulo {

    static private PreparedStatement ps;
    static private ResultSet rs;

    static public boolean ActualizarArticulo(int idArticulo, String Descripcion, String dIngles, Medida idumCompra, Medida idumVenta, int cumCompra, double pvMayor, double pvMenor, double pCompra, double stock) {
        boolean band = false;
        Connection con = Conexion.getConexion();
        String idC = String.valueOf(idumCompra.getIdMedida());
        String idV = String.valueOf(idumVenta.getIdMedida());
        String cCompra = String.valueOf(cumCompra);
        String pMayor = String.valueOf(pvMayor);
        String pMenor = String.valueOf(pvMenor);
        String Compra = String.valueOf(pCompra);
        String stocks = String.valueOf(stock);
        try {
            ps = con.prepareStatement("update articulo set descripcion=? ,descripcionIngles=? , idUnidadMedidaCompra=? , idUnidadMedidaVenta=? , cantidadUnidadMedidaCompra=? , precioVentaMayor=?, precioVentaMenor=?, precioCompra=?, stock=? where idArticulo=" + idArticulo + ";");
            ps.setString(1, Descripcion);
            ps.setString(2, dIngles);
            ps.setString(3, idC);
            ps.setString(4, idV);
            ps.setString(5, cCompra);
            ps.setString(6, pMayor);
            ps.setString(7, pMenor);
            ps.setString(8, Compra);
            ps.setString(9, stocks);            
            ps.executeUpdate();
            band = true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return band;
    }

    static public List<Articulo> MostrarArticulo() {
        List<Articulo> articulos = new ArrayList<Articulo>();
        Connection con = Conexion.getConexion();
        Medida m1 = null;
        Medida m2 = null;
        try {

            ps = con.prepareStatement("select a.idArticulo, a.descripcion, a.descripcionIngles , m.idMedida , m.descripcion, m.siglas  , "
                    + "m2.idMedida , m2.descripcion, m2.siglas  , a.cantidadUnidadMedidaCompra , a.precioVentaMayor , a.precioVentaMenor , "
                    + "a.precioCompra , a.stock  from articulo a, medida m, medida m2"
                    + " where a.idUnidadMedidaCompra = m.idMedida and a.idUnidadMedidaVenta = m2.idMedida");
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {

                int id = rs.getInt(1);
                String Descripcion = rs.getString(2);
                String dIngles = rs.getString(3);
                int idumCompra = rs.getInt(4);
                String cdescripcion = rs.getString(5);
                String csiglas = rs.getString(6);
                m1 = new Medida(idumCompra, cdescripcion, csiglas);
                int idumVenta = rs.getInt(7);
                String vdescripcion = rs.getString(8);
                String vsiglas = rs.getString(9);
                m2 = new Medida(idumVenta, vdescripcion, vsiglas);
                        
                int cumCompra = rs.getInt(10);
                double pvMayor = rs.getDouble(11);
                double pvMenor = rs.getDouble(12);
                double pCompra = rs.getDouble(13);
                double stock = rs.getDouble(14);

                Articulo a = new Articulo(id, Descripcion, dIngles, m1, m2, cumCompra, pvMayor, pvMenor, pCompra, stock);

                articulos.add(i, a);
                i++;
            }
            con.close();
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());

        }
        return articulos;
    }

    static public boolean RegistraArticulo(Articulo articulo) {
        boolean band = false;
        Connection con = Conexion.getConexion();
        try {
            ps = con.prepareStatement("insert into articulo(idArticulo, descripcion, descripcionIngles, idUnidadMedidaCompra, "
                    + "idUnidadMedidaVenta, cantidadUnidadMedidaCompra, precioVentaMayor, precioVentaMenor, precioCompra, stock) values\n"
                    + "(?,?,?,?,?,?,?,?,?,?);");

            ps.setInt(1, (int) articulo.getIdArticulo());
            ps.setString(2, articulo.getDescripcion());
            ps.setString(3, articulo.getDescripcionIngles());
            ps.setInt(4, (int) articulo.getIdUnidadMedidaCompra().getIdMedida());
            ps.setInt(5, (int) articulo.getIdUnidadMedidaVenta().getIdMedida());
            ps.setInt(6, (int) articulo.getCantidadUnidadMedidaCompra());
            ps.setDouble(7, (double) articulo.getPrecioVentaMayor());
            ps.setDouble(8, (double) articulo.getPrecioVentaMenor());
            ps.setDouble(9, (double) articulo.getPrecioCompra());
            ps.setDouble(10, (double) articulo.getStock());            

            ps.executeUpdate();
            band = true;
            con.close();
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());

        }
        return band;

    }

    static public boolean EliminaArticulo(int fila, String idArticulo) {
        boolean band = false;
        Connection con = Conexion.getConexion();

        try {

            PreparedStatement ps = con.prepareStatement("Delete from articulo where idArticulo=" + idArticulo + ";");
            ps.executeUpdate();

            band = true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return band;
    }
    
    public static Articulo buscarArticulo(int idArticulo) {
        Articulo articulo = null;
        Connection con = Conexion.getConexion();
        Medida m1 = null;
        Medida m2 = null;
        try {
            PreparedStatement ps = con.prepareStatement("select a.idArticulo, a.descripcion, a.descripcionIngles , m.idMedida , m.descripcion, m.siglas  , " +
                    " m2.idMedida , m2.descripcion, m2.siglas  , a.cantidadUnidadMedidaCompra , a.precioVentaMayor , a.precioVentaMenor ," +
                    " a.precioCompra , a.stock  from articulo a, medida m, medida m2 " +
                    " where a.idUnidadMedidaCompra = m.idMedida and a.idUnidadMedidaVenta = m2.idMedida and a.idArticulo=" + idArticulo + ";");
            rs = ps.executeQuery();
            while (rs.next()) {

                int id = rs.getInt(1);
                String Descripcion = rs.getString(2);
                String dIngles = rs.getString(3);
                int idumCompra = rs.getInt(4);
                String cdescripcion = rs.getString(5);
                String csiglas = rs.getString(6);
                m1 = new Medida(idumCompra, cdescripcion, csiglas);
                int idumVenta = rs.getInt(7);
                String vdescripcion = rs.getString(8);
                String vsiglas = rs.getString(9);
                m2 = new Medida(idumVenta, vdescripcion, vsiglas);
                        
                int cumCompra = rs.getInt(10);
                double pvMayor = rs.getDouble(11);
                double pvMenor = rs.getDouble(12);
                double pCompra = rs.getDouble(13);
                double stock = rs.getDouble(14);

                articulo = new Articulo(id, Descripcion, dIngles, m1, m2, cumCompra, pvMayor, pvMenor, pCompra, stock);

            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return articulo;
    }
}
