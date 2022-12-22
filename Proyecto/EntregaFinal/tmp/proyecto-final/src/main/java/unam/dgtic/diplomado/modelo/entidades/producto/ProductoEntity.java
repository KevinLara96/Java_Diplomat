package unam.dgtic.diplomado.modelo.entidades.producto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import unam.dgtic.diplomado.modelo.entidades.orden.OrdenEntity;
import unam.dgtic.diplomado.modelo.excepciones.ExcepcionAtributos;

@Entity
@Table(name = "producto")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @SequenceGenerator(name = "seq_post", allocationSize = 5)
    private Integer idProducto;
    private String nombreProducto;
    private Float multiplicador;
    private String estatus;

    @ManyToMany(mappedBy = "productos")
    private List<OrdenEntity> ordenes;

    public ProductoEntity() {
    }

    public ProductoEntity(Integer idProducto, String nombreProducto) {
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

    public Float getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(Float multiplicador) throws Exception {
        if (multiplicador == null || multiplicador < 1) {
            throw new ExcepcionAtributos("ERROR. Multiplicador inválido.");
        } else {
            this.multiplicador = multiplicador;
        }
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public List<OrdenEntity> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<OrdenEntity> ordenes) {
        this.ordenes = ordenes;
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
        ProductoEntity other = (ProductoEntity) obj;
        if (idProducto == null) {
            if (other.idProducto != null)
                return false;
        } else if (!idProducto.equals(other.idProducto))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "[idProducto=" + idProducto + ", nombreProducto=" + nombreProducto +
                ", estatus=" + estatus + "]]";
    }

}
