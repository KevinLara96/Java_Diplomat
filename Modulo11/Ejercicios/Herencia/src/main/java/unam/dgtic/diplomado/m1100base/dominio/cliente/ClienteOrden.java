package unam.dgtic.diplomado.m1100base.dominio.cliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente_orden")
public class ClienteOrden {

    @Id
    @Column(name = "idCliente")
    private Integer idCliente;
    @Id
    @Column(name = "idOrden")
    private Integer idOrden;

    public ClienteOrden() {

    }

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
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
        ClienteOrden other = (ClienteOrden) obj;
        if (idCliente == null) {
            if (other.idCliente != null)
                return false;
        } else if (!idCliente.equals(other.idCliente))
            return false;
        if (idOrden == null) {
            if (other.idOrden != null)
                return false;
        } else if (!idOrden.equals(other.idOrden))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ClienteOrden [idCliente=" + idCliente + ", idOrden=" + idOrden + "]";
    }
}
