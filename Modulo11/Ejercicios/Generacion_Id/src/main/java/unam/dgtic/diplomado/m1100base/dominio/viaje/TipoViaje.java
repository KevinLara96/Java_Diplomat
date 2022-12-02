package unam.dgtic.diplomado.m1100base.dominio.viaje;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipoViaje")
public class TipoViaje {

    @Id
    @SequenceGenerator(name = "tipoViajeGen", sequenceName = "secuencia_tipoViaje")
    @GeneratedValue(generator = "tipoViajeGen")
    private Integer idTipoViaje;

    private String tipoViaje;

    public Integer getIdTipoViaje() {
        return idTipoViaje;
    }

    public void setIdTipoViaje(Integer idTipoViaje) {
        this.idTipoViaje = idTipoViaje;
    }

    public String getTipoViaje() {
        return tipoViaje;
    }

    public void setTipoViaje(String tipoViaje) {
        this.tipoViaje = tipoViaje;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idTipoViaje == null) ? 0 : idTipoViaje.hashCode());
        result = prime * result + ((tipoViaje == null) ? 0 : tipoViaje.hashCode());
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
        TipoViaje other = (TipoViaje) obj;
        if (idTipoViaje == null) {
            if (other.idTipoViaje != null)
                return false;
        } else if (!idTipoViaje.equals(other.idTipoViaje))
            return false;
        if (tipoViaje == null) {
            if (other.tipoViaje != null)
                return false;
        } else if (!tipoViaje.equals(other.tipoViaje))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TipoViaje [idTipoViaje=" + idTipoViaje + ", tipoViaje=" + tipoViaje + "]";
    }

}