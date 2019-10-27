/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Entidades;

/**
 *
 * @author Hijos
 */
public class compraDetalle {
    private int idCompraDetalle;
    private Compra idCompra;
    private Articulo idArticulo;
    private double cantidad;

    public compraDetalle(int idCompraDetalle, Compra idCompra, Articulo idArticulo, double cantidad) {
        this.idCompraDetalle = idCompraDetalle;
        this.idCompra = idCompra;
        this.idArticulo = idArticulo;
        this.cantidad = cantidad;
    }

    public int getIdCompraDetalle() {
        return idCompraDetalle;
    }

    public void setIdCompraDetalle(int idCompraDetalle) {
        this.idCompraDetalle = idCompraDetalle;
    }

    public Compra getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Compra idCompra) {
        this.idCompra = idCompra;
    }

    public Articulo getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Articulo idArticulo) {
        this.idArticulo = idArticulo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
}
