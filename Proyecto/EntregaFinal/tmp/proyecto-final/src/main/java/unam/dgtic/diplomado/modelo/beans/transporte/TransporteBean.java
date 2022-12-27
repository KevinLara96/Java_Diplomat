package unam.dgtic.diplomado.modelo.beans.transporte;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import unam.dgtic.diplomado.controlador.servicio.agencia.ServicioAgencia;
import unam.dgtic.diplomado.controlador.servicio.transporte.ServicioTransporte;
import unam.dgtic.diplomado.modelo.entidades.transporte.factory.AutobusFactory;
import unam.dgtic.diplomado.modelo.entidades.transporte.factory.AvionFactory;
import unam.dgtic.diplomado.modelo.entidades.transporte.factory.TransporteFactory;
import unam.dgtic.diplomado.modelo.entidades.transporte.AutobusEntity;
import unam.dgtic.diplomado.modelo.entidades.transporte.AvionEntity;
import unam.dgtic.diplomado.modelo.entidades.transporte.TransporteEntity;

@Named
@SessionScoped
public class TransporteBean implements Serializable {

    private ServicioTransporte servicioTransporte;
    private TransporteEntity transporteEntity;
    private AvionEntity avionEntity;
    private AutobusEntity autobusEntity;

    private Integer idTransporte;
    private String tipoTransporte;
    private String marca;
    private String modelo;
    private Integer capacidadCombustible;
    private String fechaAdquisicion;
    private Integer asientosBasicos;
    private Integer asientosPrimeraClase;

    private String puertoAsignado;
    private String estacionamientoAsignado;
    private Integer idAgencia;

    private String estatus;

    /*
     * Constructores
     */
    public TransporteBean() {

    }

    /*
     * Getters & Setters
     */
    public TransporteEntity getTransporteEntity() {
        return transporteEntity;
    }

    public void setTransporteEntity(TransporteEntity transporteEntity) {
        this.transporteEntity = transporteEntity;
    }

    public Integer getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(Integer idTransporte) {
        this.idTransporte = idTransporte;
    }

    public String getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getCapacidadCombustible() {
        return capacidadCombustible;
    }

    public void setCapacidadCombustible(Integer capacidadCombustible) {
        this.capacidadCombustible = capacidadCombustible;
    }

    public String getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(String fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public Integer getAsientosBasicos() {
        return asientosBasicos;
    }

    public void setAsientosBasicos(Integer asientosBasicos) {
        this.asientosBasicos = asientosBasicos;
    }

    public Integer getAsientosPrimeraClase() {
        return asientosPrimeraClase;
    }

    public void setAsientosPrimeraClase(Integer asientosPrimeraClase) {
        this.asientosPrimeraClase = asientosPrimeraClase;
    }

    public String getPuertoAsignado() {
        return puertoAsignado;
    }

    public void setPuertoAsignado(String puertoAsignado) throws Exception {
        this.puertoAsignado = puertoAsignado;
    }

    public String getEstacionamientoAsignado() {
        return estacionamientoAsignado;
    }

    public void setEstacionamientoAsignado(String estacionamientoAsignado) throws Exception {
        this.estacionamientoAsignado = estacionamientoAsignado;
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

    public AvionEntity getAvionEntity() {
        return avionEntity;
    }

    public void setAvionEntity(AvionEntity avionEntity) {
        this.avionEntity = avionEntity;
    }

    public AutobusEntity getAutobusEntity() {
        return autobusEntity;
    }

    public void setAutobusEntity(AutobusEntity autobusEntity) {
        this.autobusEntity = autobusEntity;
    }

    /*
     * Métodos bean
     */
    public List<AvionEntity> obtenerAviones() {
        servicioTransporte = new ServicioTransporte();
        List<TransporteEntity> tmp = servicioTransporte.obtenerTransportes();
        List<AvionEntity> aviones = new ArrayList<>();

        for (TransporteEntity t : tmp) {
            if (t.getTipoTransporte().equals("Avión")) {
                aviones.add((AvionEntity) t);
            }
        }
        return aviones;
    }

    public List<AutobusEntity> obtenerAutobuses() {
        servicioTransporte = new ServicioTransporte();
        List<TransporteEntity> tmp = servicioTransporte.obtenerTransportes();
        List<AutobusEntity> autobuses = new ArrayList<>();

        for (TransporteEntity t : tmp) {
            if (t.getTipoTransporte().equals("Autobús")) {
                autobuses.add((AutobusEntity) t);
            }
        }
        return autobuses;
    }

    public void obtenerTransporte() {
        this.servicioTransporte = new ServicioTransporte();

        this.transporteEntity = servicioTransporte.obtenerTransporte(idTransporte);
        if (this.transporteEntity.getTipoTransporte().equals("Avión"))
            this.avionEntity = (AvionEntity) transporteEntity;
        else
            this.autobusEntity = (AutobusEntity) transporteEntity;
        this.estatus = this.transporteEntity.getTipoTransporte();
    }

    public void actualizarTransporte() {
        servicioTransporte = new ServicioTransporte();
        ServicioAgencia servicioAgencia = new ServicioAgencia();
        TransporteEntity transporteMod = servicioTransporte.obtenerTransporte(this.idTransporte);

        if (transporteMod.getTipoTransporte().equals("Avión")) {
            AvionEntity avionMod = (AvionEntity) transporteMod;
            this.autobusEntity = new AutobusEntity();
            try {
                avionMod.setIdTransporte(this.idTransporte);
                avionMod.setTipoTransporte(this.avionEntity.getTipoTransporte());
                avionMod.setMarca(this.avionEntity.getMarca());
                avionMod.setModelo(this.avionEntity.getModelo());
                avionMod.setCapacidadCombustible(this.avionEntity.getCapacidadCombustible());

                SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
                Date date = sdf.parse(this.fechaAdquisicion);
                avionMod.setFechaAdquisicion(date);

                avionMod.setAsientosBasicos(this.avionEntity.getAsientosBasicos());
                avionMod.setAsientosPrimeraClase(this.avionEntity.getAsientosPrimeraClase());
                avionMod.setPuertoAsignado(this.puertoAsignado);
                avionMod.setAgencia(servicioAgencia.obtenerAgencia(this.idAgencia));

                servicioTransporte.actualizarTransporte(avionMod);
                this.estatus = "Avión actualizado con éxito";
            } catch (Exception e) {
                this.estatus = "Avión no se pudo actualizar: " + e.getMessage();
            }

        } else {
            AutobusEntity autobusMod = (AutobusEntity) transporteMod;
            this.avionEntity = new AvionEntity();
            try {
                autobusMod.setIdTransporte(this.idTransporte);
                autobusMod.setTipoTransporte(this.autobusEntity.getTipoTransporte());
                autobusMod.setMarca(this.autobusEntity.getMarca());
                autobusMod.setModelo(this.autobusEntity.getModelo());
                autobusMod.setCapacidadCombustible(this.autobusEntity.getCapacidadCombustible());

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/dd");
                Date date = sdf.parse(this.fechaAdquisicion);
                autobusMod.setFechaAdquisicion(date);

                autobusMod.setAsientosBasicos(this.autobusEntity.getAsientosBasicos());
                autobusMod.setAsientosPrimeraClase(this.autobusEntity.getAsientosPrimeraClase());
                autobusMod.setEstacionamientoAsignado(this.estacionamientoAsignado);
                autobusMod.setAgencia(servicioAgencia.obtenerAgencia(this.autobusEntity.getAgencia().getIdAgencia()));

                servicioTransporte.actualizarTransporte(autobusMod);
                this.estatus = "Autobús actualizado con éxito";
            } catch (Exception e) {
                this.estatus = "Autobús no se pudo actualizar" + e.getMessage();
            }

        }

    }

    public void nuevoTransporte() {
        servicioTransporte = new ServicioTransporte();
        ServicioAgencia servicioAgencia = new ServicioAgencia();

        if (this.tipoTransporte.equals("Avión")) {
            TransporteFactory tF = new AvionFactory();
            AvionEntity avionNuevo = (AvionEntity) tF.crear();
            try {
                avionNuevo.setIdTransporte(this.idTransporte);
                avionNuevo.setTipoTransporte(this.tipoTransporte);
                avionNuevo.setMarca(this.marca);
                avionNuevo.setModelo(this.modelo);
                avionNuevo.setCapacidadCombustible(this.capacidadCombustible);

                SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
                Date date = sdf.parse(this.fechaAdquisicion);
                avionNuevo.setFechaAdquisicion(date);

                avionNuevo.setAsientosBasicos(this.asientosBasicos);
                avionNuevo.setAsientosPrimeraClase(this.asientosPrimeraClase);
                avionNuevo.setPuertoAsignado(this.puertoAsignado);
                avionNuevo.setAgencia(servicioAgencia.obtenerAgencia(this.idAgencia));

                servicioTransporte.guardarTransporte(avionNuevo);
                this.estatus = "Avión actualizado con éxito";
            } catch (Exception e) {
                this.estatus = "No se pudo gurarda el avión: " + e.getMessage();
            }
        } else {
            TransporteFactory tf = new AutobusFactory();
            AutobusEntity autobusNuevo = (AutobusEntity) tf.crear();
            try {
                autobusNuevo.setIdTransporte(this.idTransporte);
                this.estatus = this.idTransporte.toString();
                autobusNuevo.setTipoTransporte(this.tipoTransporte);
                autobusNuevo.setMarca(this.marca);
                autobusNuevo.setModelo(this.modelo);
                autobusNuevo.setCapacidadCombustible(this.capacidadCombustible);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/dd");
                Date date = sdf.parse(this.fechaAdquisicion);
                autobusNuevo.setFechaAdquisicion(date);

                autobusNuevo.setAsientosBasicos(this.asientosBasicos);
                autobusNuevo.setAsientosPrimeraClase(this.asientosPrimeraClase);
                autobusNuevo.setEstacionamientoAsignado(this.estacionamientoAsignado);
                autobusNuevo.setAgencia(servicioAgencia.obtenerAgencia(this.idAgencia));

                servicioTransporte.actualizarTransporte(autobusNuevo);
                this.estatus = "Autobús guardado con éxito";
            } catch (Exception e) {
                this.estatus = "Autobús no se pudo guardar: " + e.getMessage();
            }
        }
    }

    public void eliminarTransporte() {
        servicioTransporte = new ServicioTransporte();

        try {
            if (servicioTransporte.eliminarTransporte(this.idTransporte)) {
                this.estatus = "Transporte eliminado con éxito";
            } else {
                this.estatus = "ERROR. No se pudo eliminar el tansporte: ";
            }
        } catch (Exception e) {
            this.estatus = "ERROR. No se pudo eliminar el tansporte: ";
        }
    }
}
