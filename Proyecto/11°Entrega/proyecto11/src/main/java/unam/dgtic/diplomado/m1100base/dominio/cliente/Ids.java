package unam.dgtic.diplomado.m1100base.dominio.cliente;

import java.io.Serializable;

public class Ids implements Serializable {

    private Integer idCliente;
    private Integer idOrden;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

}
