package unam.dgtic.diplomado.modelo.entidades.orden;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import unam.dgtic.diplomado.modelo.excepciones.ExcepcionAtributos;

@Entity
@Table(name = "orden_producto")
@IdClass(Ids.class)
public class OrdenProducto {

    @Id
    private Integer idProducto;
    @Id
    private Integer idOrden;

    public OrdenProducto() {

    }

    public OrdenProducto(Integer idProducto, Integer idOrden) {
        this.idProducto = idProducto;
        this.idOrden = idOrden;
    }

    public Integer getIdProducto() {
        return this.idProducto;
    }

    public void setIdProducto(Integer idProducto) throws Exception {
        if (idProducto == null || idProducto <= 0) {
            throw new ExcepcionAtributos("IdProducto inválido.");
        } else {
            this.idProducto = idProducto;
        }
    }

    public Integer getIdOrden() {
        return this.idOrden;
    }

    public void setIdOrden(Integer idOrden) throws Exception {
        if (idOrden == null || idOrden <= 0) {
            throw new ExcepcionAtributos("IdOrden inválido.");
        } else {
            this.idOrden = idOrden;
        }
    }
}
