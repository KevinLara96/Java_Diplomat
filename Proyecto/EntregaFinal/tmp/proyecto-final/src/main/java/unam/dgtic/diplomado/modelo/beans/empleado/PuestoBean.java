package unam.dgtic.diplomado.modelo.beans.empleado;

import java.io.Serializable;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import unam.dgtic.diplomado.modelo.excepciones.ExcepcionAtributos;

@Named
@SessionScoped
public class PuestoBean implements Serializable {

    private Integer idPuesto;
    private String puesto;

    public PuestoBean() {
    }

    public PuestoBean(Integer idPuesto, String puesto) {
        this.idPuesto = idPuesto;
        this.puesto = puesto;
    }

    public Integer getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(Integer idPuesto) throws Exception {
        if (idPuesto == null || idPuesto <= 0) {
            throw new ExcepcionAtributos("ERROR. Id de puesto inválido.");
        } else {
            this.idPuesto = idPuesto;
        }
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) throws Exception {
        if (puesto == null || puesto.isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Nombre de puesto inválido.");
        } else {
            this.puesto = puesto;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idPuesto == null) ? 0 : idPuesto.hashCode());
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
        PuestoBean other = (PuestoBean) obj;
        if (idPuesto == null) {
            if (other.idPuesto != null)
                return false;
        } else if (!idPuesto.equals(other.idPuesto))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "[idPuesto=" + idPuesto + ", puesto=" + puesto + "]";
    }

}