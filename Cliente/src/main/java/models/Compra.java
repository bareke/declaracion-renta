package models;

import java.util.Date;

public class Compra {

    private Integer id;
    private String tipo;
    private Integer valor;
    private String lugar;
    private Date fecha;
    private String medioPago;
    private String nit;

    public Compra() {
    }

    public Compra(Integer id, String tipo, Integer valor, String lugar, Date fecha, String medioPago, String nit) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.lugar = lugar;
        this.fecha = fecha;
        this.medioPago = medioPago;
        this.nit = nit;
    }

    /**
     * @return Integer return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return String return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * 
     * @param tipo the tpo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
