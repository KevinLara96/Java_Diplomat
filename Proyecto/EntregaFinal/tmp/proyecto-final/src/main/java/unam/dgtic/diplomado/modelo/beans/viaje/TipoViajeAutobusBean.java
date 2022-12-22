package unam.dgtic.diplomado.modelo.beans.viaje;

import java.io.Serializable;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import unam.dgtic.diplomado.modelo.excepciones.ExcepcionAtributos;

@Named
@SessionScoped
public class TipoViajeAutobusBean implements Serializable {

    private Integer idTipoViajeAutobus;
    private String tipoViajeAutobus;

    public TipoViajeAutobusBean() {
    }

    public TipoViajeAutobusBean(Integer idTipoViajeAutobus, String tipoViajeAutobus) {
        this.idTipoViajeAutobus = idTipoViajeAutobus;
        this.tipoViajeAutobus = tipoViajeAutobus;
    }

    public Integer getIdTipoViajeAutobus() {
        return idTipoViajeAutobus;
    }

    public void setIdTipoViajeAutobus(Integer idTipoViajeAutobus) throws Exception {
        if (idTipoViajeAutobus == null || idTipoViajeAutobus <= 0) {
            throw new ExcepcionAtributos("ERROR. Id del tipo de viaje en autobús inválido.");
        } else {
            this.idTipoViajeAutobus = idTipoViajeAutobus;
        }
    }

    public String getTipoViajeAutobus() {
        return tipoViajeAutobus;
    }

    public void setTipoViajeAutobus(String tipoViajeAutobus) throws Exception {
        if (tipoViajeAutobus == null || tipoViajeAutobus.isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Tipo de viaje en autobús inválido.");
        } else {
            this.tipoViajeAutobus = tipoViajeAutobus;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idTipoViajeAutobus == null) ? 0 : idTipoViajeAutobus.hashCode());
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
        TipoViajeAutobusBean other = (TipoViajeAutobusBean) obj;
        if (idTipoViajeAutobus == null) {
            if (other.idTipoViajeAutobus != null)
                return false;
        } else if (!idTipoViajeAutobus.equals(other.idTipoViajeAutobus))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "[idTipoViajeAutobus=" + idTipoViajeAutobus + ", tipoViajeAutobus=" + tipoViajeAutobus + "]";
    }

}
