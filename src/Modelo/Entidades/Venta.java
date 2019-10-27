/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Entidades;

import java.util.Date;

/**
 *
 * @author Hijos
 */
public class Venta {
    private int idVenta;
    private Documento idDocumento;
    private String serieDocumento;
    private String nroDocumento;
    private Date fecha;
    private Cliente idCliente;

    public Venta(int idVenta, Documento idDocumento, String serieDocumento, String nroDocumento, Date fecha, Cliente idCliente) {
        this.idVenta = idVenta;
        this.idDocumento = idDocumento;
        this.serieDocumento = serieDocumento;
        this.nroDocumento = nroDocumento;
        this.fecha = fecha;
        this.idCliente = idCliente;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Documento getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Documento idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getSerieDocumento() {
        return serieDocumento;
    }

    public void setSerieDocumento(String serieDocumento) {
        this.serieDocumento = serieDocumento;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }
    
    
}
