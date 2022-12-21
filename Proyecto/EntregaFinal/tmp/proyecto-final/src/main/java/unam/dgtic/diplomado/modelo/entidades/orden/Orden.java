package unam.dgtic.diplomado.modelo.entidades.orden;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import unam.dgtic.diplomado.modelo.entidades.cliente.Cliente;
import unam.dgtic.diplomado.modelo.entidades.producto.Producto;
import unam.dgtic.diplomado.modelo.excepciones.ExcepcionAtributos;

@Named
@SessionScoped
public class Orden implements Serializable {

    private Integer idOrden;
    private Date fechaEmision;
    private Float monto;
    private String descripcion;

    private Cliente cliente;

    private List<Producto> productos;

    public Orden() {

    }

    public Orden(Integer idOrden, Date fechaEmision, Float monto, String descripcion) {
        this.idOrden = idOrden;
        this.fechaEmision = fechaEmision;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) throws Exception {
        if (idOrden == null || idOrden <= 0) {
            throw new ExcepcionAtributos("ERROR. Id de orden inválida.");
        } else {
            this.idOrden = idOrden;

        }
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) throws Exception {
        if (fechaEmision == null || fechaEmision.toString().isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Fecha de orden inválida.");
        } else {
            this.fechaEmision = fechaEmision;
        }
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) throws Exception {
        if (monto == null || monto == 0) {
            throw new ExcepcionAtributos("ERROR. Monto de orden inválida.");
        } else {
            this.monto = monto;
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) throws Exception {
        if (descripcion == null || descripcion.isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Descripción inválida.");
        } else {
            this.descripcion = descripcion;
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new ExcepcionAtributos("ERROR. Cliente inválido.");
        } else {
            this.cliente = cliente;
        }
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) throws Exception {
        if (productos == null || productos.isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Lista de productos inválida.");
        } else {
            this.productos = productos;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idOrden == null) ? 0 : idOrden.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Orden other = (Orden) obj;
        if (idOrden == null) {
            if (other.idOrden != null)
                return false;
        } else if (!idOrden.equals(other.idOrden))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "[idOrden=" + idOrden + ", fechaEmision=" + fechaEmision + ", monto=" + monto + ", descripcion="
                + descripcion + ", cliente=" + cliente.getIdCliente() + ", productos: ";
    }

}
