package unam.dgtic.diplomado.modelo.entidades.orden;

import java.io.Serializable;

public class Ids implements Serializable {

    private Integer idOrden;
    private Integer idProducto;

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

}
