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
public class Articulo {
    private int idArticulo;
    private String descripcion;
    private String descripcionIngles;
    private Medida idUnidadMedidaCompra;
    private Medida idUnidadMedidaVenta;
    private int cantidadUnidadMedidaCompra;
    private double precioVentaMayor;
    private double precioVentaMenor;
    private double precioCompra;
    private double stock;

    public Articulo(int idArticulo, String descripcion, String descripcionIngles, Medida idUnidadMedidaCompra, Medida idUnidadMedidaVenta, int cantidadUnidadMedidaCompra, double precioVentaMayor, double precioVentaMenor, double precioCompra, double stock) {
        this.idArticulo = idArticulo;
        this.descripcion = descripcion;
        this.descripcionIngles = descripcionIngles;
        this.idUnidadMedidaCompra = idUnidadMedidaCompra;
        this.idUnidadMedidaVenta = idUnidadMedidaVenta;
        this.cantidadUnidadMedidaCompra = cantidadUnidadMedidaCompra;
        this.precioVentaMayor = precioVentaMayor;
        this.precioVentaMenor = precioVentaMenor;
        this.precioCompra = precioCompra;
        this.stock = stock;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcionIngles() {
        return descripcionIngles;
    }

    public void setDescripcionIngles(String descripcionIngles) {
        this.descripcionIngles = descripcionIngles;
    }

    public Medida getIdUnidadMedidaCompra() {
        return idUnidadMedidaCompra;
    }

    public void setIdUnidadMedidaCompra(Medida idUnidadMedidaCompra) {
        this.idUnidadMedidaCompra = idUnidadMedidaCompra;
    }

    public Medida getIdUnidadMedidaVenta() {
        return idUnidadMedidaVenta;
    }

    public void setIdUnidadMedidaVenta(Medida idUnidadMedidaVenta) {
        this.idUnidadMedidaVenta = idUnidadMedidaVenta;
    }

    public int getCantidadUnidadMedidaCompra() {
        return cantidadUnidadMedidaCompra;
    }

    public void setCantidadUnidadMedidaCompra(int cantidadUnidadMedidaCompra) {
        this.cantidadUnidadMedidaCompra = cantidadUnidadMedidaCompra;
    }

    public double getPrecioVentaMayor() {
        return precioVentaMayor;
    }

    public void setPrecioVentaMayor(double precioVentaMayor) {
        this.precioVentaMayor = precioVentaMayor;
    }

    public double getPrecioVentaMenor() {
        return precioVentaMenor;
    }

    public void setPrecioVentaMenor(double precioVentaMenor) {
        this.precioVentaMenor = precioVentaMenor;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }
    
}
