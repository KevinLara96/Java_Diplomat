package unam.dgtic.diplomado.core;

import java.io.Serializable;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class ViajeBean implements Serializable {

    private static final long serialVersionUID = -7258677398121565610L;

    private Integer idViaje;
    private String origen;
    private String destino;
    private Float precio;
    private Integer distancia;
    private String fecha;

    private AgenciaBean agenciaBean;

    public Integer getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(Integer idViaje) {
        this.idViaje = idViaje;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public AgenciaBean getAgenciaBean() {
        return agenciaBean;
    }

    public void setAgenciaBean(AgenciaBean agenciaBean) {
        this.agenciaBean = agenciaBean;
    }

}
