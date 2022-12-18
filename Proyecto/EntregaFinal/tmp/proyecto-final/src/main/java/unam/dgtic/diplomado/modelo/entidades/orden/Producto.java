package unam.dgtic.diplomado.modelo.entidades.orden;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    private Integer idProducto;
    private String nombreProducto;

    @ManyToMany(mappedBy = "productos")
    private List<Orden> ordenes;

    public Producto() {
    }

    public Producto(Integer idProducto, String nombreProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        Producto other = (Producto) obj;
        if (idProducto == null) {
            if (other.idProducto != null)
                return false;
        } else if (!idProducto.equals(other.idProducto))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "[idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + "]";
    }

}
