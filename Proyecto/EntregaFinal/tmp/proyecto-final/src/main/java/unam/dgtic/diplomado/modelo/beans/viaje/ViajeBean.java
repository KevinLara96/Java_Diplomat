package unam.dgtic.diplomado.modelo.beans.viaje;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import unam.dgtic.diplomado.controlador.servicio.viaje.ServicioViaje;
import unam.dgtic.diplomado.modelo.entidades.viaje.TipoViajeAutobusEntity;
import unam.dgtic.diplomado.modelo.entidades.viaje.TipoViajeAvionEntity;
import unam.dgtic.diplomado.modelo.entidades.viaje.ViajeEntity;

@Named
@SessionScoped
public class ViajeBean implements Serializable {

    private ServicioViaje servicioViaje;
    private ViajeEntity viajeEntity;
    private TipoViajeAutobusEntity tipoViajeAutobusEntity;
    private TipoViajeAvionEntity tipoViajeAvionEntity;

    private Integer idViaje;
    private String origen;
    private String destino;
    private Float precio;
    private Date fecha;

    private Integer idAgencia;
    private Integer idTipoViajeAvion;
    private Integer idTipoViajeAutobus;
    private String estatus;

    /*
     * Constructores
     */
    public ViajeBean() {
    }

    /*
     * Setters & Getters
     */

    public ViajeEntity getViajeEntity() {
        return viajeEntity;
    }

    public void setViajeEntity(ViajeEntity viajeEntity) {
        this.viajeEntity = viajeEntity;
    }

    public TipoViajeAutobusEntity getTipoViajeAutobusEntity() {
        return tipoViajeAutobusEntity;
    }

    public void setTipoViajeAutobusEntity(TipoViajeAutobusEntity tipoViajeAutobusEntity) {
        this.tipoViajeAutobusEntity = tipoViajeAutobusEntity;
    }

    public TipoViajeAvionEntity getTipoViajeAvionEntity() {
        return tipoViajeAvionEntity;
    }

    public void setTipoViajeAvionEntity(TipoViajeAvionEntity tipoViajeAvionEntity) {
        this.tipoViajeAvionEntity = tipoViajeAvionEntity;
    }

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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(Integer idAgencia) {
        this.idAgencia = idAgencia;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Integer getIdTipoViajeAvion() {
        return idTipoViajeAvion;
    }

    public void setTipoViajeAvion(Integer idTipoViajeAvion) {
        this.idTipoViajeAvion = idTipoViajeAvion;
    }

    public Integer getIdTipoViajeAutobus() {
        return idTipoViajeAutobus;
    }

    public void setTipoViajeAutobus(Integer idTipoViajeAutobus) {
        this.idTipoViajeAutobus = idTipoViajeAutobus;
    }

    /*
     * Métodos Bean
     */
    public List<ViajeEntity> obtenerViajes() {
        servicioViaje = new ServicioViaje();

        return servicioViaje.obtenerViajes();
    }

    public void obtenerViaje() {
        this.servicioViaje = new ServicioViaje();

        this.viajeEntity = servicioViaje.obtenerViaje(this.idViaje);
        this.idTipoViajeAutobus = viajeEntity.getTipoViajeAutobus().getIdTipoViajeAutobus();
        this.idTipoViajeAvion = viajeEntity.getTipoViajeAvion().getIdTipoViajeAvion();
        this.idAgencia = viajeEntity.getAgencia().getIdAgencia();
    }

    public void actualizarViaje() {
        try {
            this.viajeEntity.setOrigen("Hola");
        } catch (Exception e) {
            this.estatus = "Error";
        }
    }

    public void nuevoViaje() {
        this.estatus = "Nuevo";
    }

    public void eliminarViaje() {
        this.estatus = "Eliminar";
    }
}
