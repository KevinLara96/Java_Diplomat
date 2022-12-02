package unam.dgtic.diplomado.m1100base.dominio.viaje;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import unam.dgtic.diplomado.m1100base.dominio.agencia.Agencia;

@Entity
@Table(name = "viajes")
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idViaje;

    private String origen;
    private String destino;
    private Float precio;
    private String fecha;

    @JoinColumn(name = "idAgencia")
    private Agencia agencia;
    @JoinColumn(name = "idTipoViaje")
    private TipoViaje tipoViaje;

    public Viaje() {

    }

    public Viaje(Integer idViaje, String origen, String destino, Float precio, String fecha, Agencia agencia,
            TipoViaje tipoViaje) {
        this.idViaje = idViaje;
        this.origen = origen;
        this.destino = destino;
        this.precio = precio;
        this.fecha = fecha;
        this.agencia = agencia;
        this.tipoViaje = tipoViaje;
    }

    public Integer getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(Integer idViaje) {
        this.idViaje = idViaje;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public TipoViaje getTipoViaje() {
        return tipoViaje;
    }

    public void setTipoViaje(TipoViaje tipoViaje) {
        this.tipoViaje = tipoViaje;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idViaje == null) ? 0 : idViaje.hashCode());
        result = prime * result + ((origen == null) ? 0 : origen.hashCode());
        result = prime * result + ((destino == null) ? 0 : destino.hashCode());
        result = prime * result + ((precio == null) ? 0 : precio.hashCode());
        result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
        result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
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
        Viaje other = (Viaje) obj;
        if (idViaje == null) {
            if (other.idViaje != null)
                return false;
        } else if (!idViaje.equals(other.idViaje))
            return false;
        if (origen == null) {
            if (other.origen != null)
                return false;
        } else if (!origen.equals(other.origen))
            return false;
        if (destino == null) {
            if (other.destino != null)
                return false;
        } else if (!destino.equals(other.destino))
            return false;
        if (precio == null) {
            if (other.precio != null)
                return false;
        } else if (!precio.equals(other.precio))
            return false;
        if (fecha == null) {
            if (other.fecha != null)
                return false;
        } else if (!fecha.equals(other.fecha))
            return false;
        if (agencia == null) {
            if (other.agencia != null)
                return false;
        } else if (!agencia.equals(other.agencia))
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
        return "Viaje [idViaje=" + idViaje + ", origen=" + origen + ", destino=" + destino + ", precio=" + precio
                + ", fecha=" + fecha + ", agencia=" + agencia.getNombreAgencia() + ", tipoViaje="
                + tipoViaje.getTipoViaje() + "]";
    }

}
