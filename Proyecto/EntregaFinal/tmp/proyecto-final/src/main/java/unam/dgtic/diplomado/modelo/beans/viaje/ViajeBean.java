package unam.dgtic.diplomado.modelo.beans.viaje;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import unam.dgtic.diplomado.controlador.servicio.agencia.ServicioAgencia;
import unam.dgtic.diplomado.controlador.servicio.viaje.ServicioTipoViajeAutobus;
import unam.dgtic.diplomado.controlador.servicio.viaje.ServicioTipoViajeAvion;
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
    private String fecha;

    private Integer tipoAuto;
    private Integer tipoAvion;
    private Integer idAgencia;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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

    public Integer getTipoAuto() {
        return tipoAuto;
    }

    public void setTipoAuto(Integer tipoAuto) {
        this.tipoAuto = tipoAuto;
    }

    public Integer getTipoAvion() {
        return tipoAvion;
    }

    public void setTipoAvion(Integer tipoAvion) {
        this.tipoAvion = tipoAvion;
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
        this.tipoAuto = viajeEntity.getTipoViajeAutobus().getIdTipoViajeAutobus();
        this.tipoAvion = viajeEntity.getTipoViajeAvion().getIdTipoViajeAvion();
        this.idAgencia = viajeEntity.getAgencia().getIdAgencia();
    }

    public void actualizarViaje() {
        servicioViaje = new ServicioViaje();
        ServicioAgencia servicioAgencia = new ServicioAgencia();
        ServicioTipoViajeAutobus servicioTipoViajeAutobus = new ServicioTipoViajeAutobus();
        ServicioTipoViajeAvion servicioTipoViajeAvion = new ServicioTipoViajeAvion();

        ViajeEntity viajeMod = servicioViaje.obtenerViaje(this.idViaje);
        try {
            viajeMod.setIdViaje(this.idViaje);
            viajeMod.setOrigen(this.viajeEntity.getOrigen());
            viajeMod.setDestino(this.viajeEntity.getDestino());
            viajeMod.setPrecio(this.viajeEntity.getPrecio());

            SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
            Date date = sdf.parse(this.fecha);
            viajeMod.setFecha(date);

            viajeMod.setTipoViajeAutobus(servicioTipoViajeAutobus.obtenerTipoViajeAutobus(tipoAuto));
            viajeMod.setTipoViajeAvion(servicioTipoViajeAvion.obtenerTipoViajeAvion(tipoAvion));
            viajeMod.setAgencia(servicioAgencia.obtenerAgencia(idAgencia));

            if (!viajeMod.verificaTipoViaje())
                throw new Exception("ERROR. Tipos de viaje incompatibles");

            servicioViaje.actualizarViaje(viajeMod);
            this.estatus = "Viaje actualizado con éxito";
        } catch (Exception e) {
            this.estatus = "No se pudo actualizar el viaje: " + e.getMessage();
        }
    }

    public void nuevoViaje() {
        servicioViaje = new ServicioViaje();
        ServicioAgencia servicioAgencia = new ServicioAgencia();
        ServicioTipoViajeAutobus servicioTipoViajeAutobus = new ServicioTipoViajeAutobus();
        ServicioTipoViajeAvion servicioTipoViajeAvion = new ServicioTipoViajeAvion();

        try {

            if (this.tipoAuto == this.tipoAvion) {
                throw new Exception("ERROR. Tipos de viaje incompatibles.");
            } else if (this.tipoAvion == 4) {
                TipoViajeAutobusEntity auto = servicioTipoViajeAutobus.obtenerTipoViajeAutobus(this.tipoAuto);
                ViajeEntity viajeNuevo = new ViajeEntity.Builder().setViajeAutobus(auto).build();

                viajeNuevo.setIdViaje(this.idViaje);
                viajeNuevo.setOrigen(this.origen);
                viajeNuevo.setDestino(this.destino);
                viajeNuevo.setPrecio(this.precio);

                SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyy");
                Date date = sdf.parse(this.fecha);
                viajeNuevo.setFecha(date);

                viajeNuevo.setAgencia(servicioAgencia.obtenerAgencia(this.idAgencia));
                viajeNuevo.setTipoViajeAutobus(servicioTipoViajeAutobus.obtenerTipoViajeAutobus(this.tipoAuto));
                viajeNuevo.setTipoViajeAvion(servicioTipoViajeAvion.obtenerTipoViajeAvion(4));

                servicioViaje.guardarViaje(viajeNuevo);
                this.estatus = "Viaje guardado con éxito";
                // this.estatus = this.tipoAuto.toString() + this.tipoAvion.toString();
            } else if (this.tipoAvion == 4) {
                TipoViajeAvionEntity avion = servicioTipoViajeAvion.obtenerTipoViajeAvion(this.tipoAvion);
                ViajeEntity viajeNuevo = new ViajeEntity.Builder().setViajeAvion(avion).build();

                viajeNuevo.setIdViaje(this.idViaje);
                viajeNuevo.setOrigen(this.origen);
                viajeNuevo.setDestino(this.destino);
                viajeNuevo.setPrecio(this.precio);

                SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyy");
                Date date = sdf.parse(this.fecha);
                viajeNuevo.setFecha(date);

                viajeNuevo.setAgencia(servicioAgencia.obtenerAgencia(this.idAgencia));
                viajeNuevo.setTipoViajeAutobus(servicioTipoViajeAutobus.obtenerTipoViajeAutobus(4));
                viajeNuevo.setTipoViajeAvion(servicioTipoViajeAvion.obtenerTipoViajeAvion(this.tipoAvion));

                servicioViaje.guardarViaje(viajeNuevo);
                // this.estatus = "Viaje guardado con éxito.";
                this.estatus = this.tipoAuto.toString() + this.tipoAvion.toString();
            } else {
                this.estatus = "ERROR. Tipos de viaje incompatibles";
            }
        } catch (Exception e) {
            this.estatus = "No se pudo guardar el viaje: " + e.getMessage();
        }
    }

    public void eliminarViaje() {
        servicioViaje = new ServicioViaje();

        try {
            if (servicioViaje.eliminarViaje(this.idViaje)) {
                this.estatus = "Viaje eliminado con éxito.";
            } else {
                this.estatus = "ERROR. No se pudo eliminar el viaje";
            }
        } catch (Exception e) {
            this.estatus = "ERROR. No se pudo eliminar el viaje";
        }
    }
}
