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
public class Proveedor {

    private int idProveedor;
    private String razonSozial;
    private String tipoPersona;
    private String nroDocumento;
    private String direccion;
    private String telefono;

    public Proveedor(int idProveedor, String razonSozial, String tipoPersona, String nroDocumento, String direccion, String telefono) {
        this.idProveedor = idProveedor;
        this.razonSozial = razonSozial;
        this.tipoPersona = tipoPersona;
        this.nroDocumento = nroDocumento;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getRazonSozial() {
        return razonSozial;
    }

    public void setRazonSozial(String razonSozial) {
        this.razonSozial = razonSozial;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
