package unam.dgtic.diplomado.modelo.entidades.cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import unam.dgtic.diplomado.modelo.excepciones.ExcepcionAtributos;

@Entity
@Table(name = "cliente_orden")
@IdClass(Ids.class)
public class ClienteOrden {

    @Id
    private Integer idCliente;
    @Id
    private Integer idOrden;

    public ClienteOrden() {

    }

    public ClienteOrden(Integer idCliente, Integer idOrden) {
        this.idCliente = idCliente;
        this.idOrden = idOrden;
    }

    public Integer getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(Integer idCliente) throws Exception {
        if (idCliente == null || idCliente <= 0) {
            throw new ExcepcionAtributos("IdCliente inválido.");
        } else {
            this.idCliente = idCliente;
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
