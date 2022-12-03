package unam.dgtic.diplomado.m1100base.dominio.cliente;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orden")
public class Orden {

    @Id
    private Integer idOrden;
    private String fecha;
    private Float pago;
    private String descripcion;

    @ManyToMany(mappedBy = "ordenes")
    private List<Cliente> clientes;

    public Orden() {
    }

    public Orden(Integer idOrden, String fecha, Float pago, String descripcion) {
        this.idOrden = idOrden;
        this.fecha = fecha;
        this.pago = pago;
        this.descripcion = descripcion;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Float getPago() {
        return pago;
    }

    public void setPago(Float pago) {
        this.pago = pago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
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
        StringBuilder str = new StringBuilder();
        for (Cliente c : this.clientes) {
            str.append(c.getNombre()).append(", ");
        }
        return "Orden [idOrden=" + idOrden + ", fecha=" + fecha + ", pago=" + pago + ", descripcion=" + descripcion
                + ", clientes=" + str.toString();

    }

}
