package unam.dgtic.diplomado.modelo.entidades.viaje;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import unam.dgtic.diplomado.modelo.excepciones.ExcepcionAtributos;

@Entity
@Table(name = "tipoViajeAvion")
public class TipoViajeAvionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoViajeAvion;
    private String tipoViajeAvion;

    public TipoViajeAvionEntity() {
    }

    public TipoViajeAvionEntity(Integer idTipoViajeAvion, String tipoViajeAvion) {
        this.idTipoViajeAvion = idTipoViajeAvion;
        this.tipoViajeAvion = tipoViajeAvion;
    }

    public Integer getIdTipoViajeAvion() {
        return idTipoViajeAvion;
    }

    public void setIdTipoViajeAvion(Integer idTipoViajeAvion) throws Exception {
        if (idTipoViajeAvion == null || idTipoViajeAvion <= 0) {
            throw new ExcepcionAtributos("ERROR. Id del tipo de viaje en avión inválido.");
        } else {
            this.idTipoViajeAvion = idTipoViajeAvion;
        }
    }

    public String getTipoViajeAvion() {
        return tipoViajeAvion;
    }

    public void setTipoViajeAvion(String tipoViajeAvion) throws Exception {
        if (tipoViajeAvion == null || tipoViajeAvion.isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Tipo de viaje en avión inválido.");
        } else {
            this.tipoViajeAvion = tipoViajeAvion;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idTipoViajeAvion == null) ? 0 : idTipoViajeAvion.hashCode());
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
        TipoViajeAvionEntity other = (TipoViajeAvionEntity) obj;
        if (idTipoViajeAvion == null) {
            if (other.idTipoViajeAvion != null)
                return false;
        } else if (!idTipoViajeAvion.equals(other.idTipoViajeAvion))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "[idTipoViajeAvion=" + idTipoViajeAvion + ", tipoViajeAvion=" + tipoViajeAvion + "]";
    }

}
