package unam.dgtic.diplomado.modelo.beans.orden;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import unam.dgtic.diplomado.controlador.servicio.cliente.ServicioCliente;
import unam.dgtic.diplomado.controlador.servicio.orden.ServicioOrden;
import unam.dgtic.diplomado.modelo.entidades.orden.OrdenEntity;

@Named
@SessionScoped
public class OrdenBean implements Serializable {

    private ServicioOrden servicioOrden;
    private ServicioCliente servicioCliente;
    private OrdenEntity ordenEntity;

    private Integer idOrden;
    private String fechaEmision;
    private Float monto;
    private String descripcion;

    private Integer idCliente;
    private String estatus;

    /*
     * Constructores
     */
    public OrdenBean() {

    }

    /*
     * Getters & Setters
     */
    public OrdenEntity getOrdenEntity() {
        return ordenEntity;
    }

    public void setOrdenEntity(OrdenEntity ordenEntity) {
        this.ordenEntity = ordenEntity;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    /*
     * Métodos Bean
     */
    public List<OrdenEntity> obtenerOrdenes() {
        servicioOrden = new ServicioOrden();

        return servicioOrden.obtenerOrdenes();
    }

    public void obtenerOrden() {
        servicioOrden = new ServicioOrden();

        this.ordenEntity = servicioOrden.obtenerOrden(this.idOrden);
    }

    public void actualizarOrden() {
        servicioOrden = new ServicioOrden();
        servicioCliente = new ServicioCliente();

        OrdenEntity ordenMod = servicioOrden.obtenerOrden(this.idOrden);
        try {
            ordenMod.setIdOrden(this.idOrden);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyy");
            Date date = sdf.parse(this.fechaEmision);
            ordenMod.setFechaEmision(date);

            ordenMod.setMonto(this.ordenEntity.getMonto());
            ordenMod.setDescripcion(this.ordenEntity.getDescripcion());
            ordenMod.setCliente(servicioCliente.obtenerCliente(this.idCliente));

            servicioOrden.actualizarOrden(ordenMod);
            this.estatus = "Orden actualizada con éxito";
        } catch (Exception e) {
            this.estatus = "No se pudo actualizar la orden: " + e.getMessage();
        }
    }

    public void nuevaOrden() {
        servicioOrden = new ServicioOrden();
        servicioCliente = new ServicioCliente();

        this.ordenEntity = new OrdenEntity();
        try {
            this.ordenEntity.setIdOrden(this.idOrden);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyy");
            Date date = sdf.parse(this.fechaEmision);
            this.ordenEntity.setFechaEmision(date);

            this.ordenEntity.setMonto(this.monto);
            this.ordenEntity.setDescripcion(this.descripcion);
            this.ordenEntity.setCliente(servicioCliente.obtenerCliente(this.idCliente));

            servicioOrden.guardarOrden(ordenEntity);
            this.estatus = "Orden registrada con éxito";
        } catch (Exception e) {
            this.estatus = "No se pudo registrar la orden: " + e.getMessage();
        }
    }

}
