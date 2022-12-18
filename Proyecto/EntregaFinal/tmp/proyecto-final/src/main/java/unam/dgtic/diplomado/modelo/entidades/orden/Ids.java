package unam.dgtic.diplomado.modelo.entidades.orden;

import java.io.Serializable;

public class Ids implements Serializable {

    private Integer idProducto;
    private Integer idOrden;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

}
