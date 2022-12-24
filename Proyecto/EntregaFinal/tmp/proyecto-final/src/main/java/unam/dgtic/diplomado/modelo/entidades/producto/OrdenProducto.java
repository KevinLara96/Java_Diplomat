package unam.dgtic.diplomado.modelo.entidades.producto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import unam.dgtic.diplomado.modelo.entidades.orden.Ids;

@Entity
@Table(name = "orden_producto")
@IdClass(Ids.class)
public class OrdenProducto {

    @Id
    private Integer idOrden;
    @Id
    private Integer idProducto;

    public OrdenProducto() {
    }

    public OrdenProducto(Integer idOrden, Integer idProducto) {
        this.idOrden = idOrden;
        this.idProducto = idProducto;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idOrden == null) ? 0 : idOrden.hashCode());
        result = prime * result + ((idProducto == null) ? 0 : idProducto.hashCode());
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
        OrdenProducto other = (OrdenProducto) obj;
        if (idOrden == null) {
            if (other.idOrden != null)
                return false;
        } else if (!idOrden.equals(other.idOrden))
            return false;
        if (idProducto == null) {
            if (other.idProducto != null)
                return false;
        } else if (!idProducto.equals(other.idProducto))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "OrdenProducto [idOrden=" + idOrden + ", idProducto=" + idProducto + "]";
    }

}
