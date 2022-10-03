package unam.dgtic.core.ejercicio3;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Dueno")
public class Dueno {

    @Id
    private Integer dueno_id;
    private String nombre;
    private String rfc;

    @ManyToOne
    @JoinColumn(name = "id_automovil")
    private Automovil automovil;

    public Dueno() {
        super();
    }

    public Dueno(String nombre, String rfc) {
        super();
        this.nombre = nombre;
        this.rfc = rfc;
    }

    public Integer getDueno_id() {
        return dueno_id;
    }

    public void setDueno_id(Integer dueno_id) {
        this.dueno_id = dueno_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Automovil getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }

    @Override
    public String toString() {
        return "Dueno [dueno_id=" + dueno_id + ", nombre=" + nombre + ", rfc=" + rfc;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dueno_id == null) ? 0 : dueno_id.hashCode());
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
        Dueno other = (Dueno) obj;
        if (dueno_id == null) {
            if (other.dueno_id != null)
                return false;
        } else if (!dueno_id.equals(other.dueno_id))
            return false;
        return true;
    }

}
