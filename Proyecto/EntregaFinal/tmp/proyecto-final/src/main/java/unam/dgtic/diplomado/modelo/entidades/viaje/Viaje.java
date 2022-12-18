package unam.dgtic.diplomado.modelo.entidades.viaje;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import unam.dgtic.diplomado.modelo.entidades.agencia.Agencia;
import unam.dgtic.diplomado.modelo.excepciones.ExcepcionAtributos;

@Entity
@Table(name = "viaje")
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idViaje;
    private String origen;
    private String destino;
    private Float precio;
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "idAgencia")
    private Agencia agencia;

    @ManyToOne
    @JoinColumn(name = "idTipoViajeAutobus")
    private TipoViajeAutobus tipoViajeAutobus;
    @ManyToOne
    @JoinColumn(name = "idTipoViajeAvion")
    private TipoViajeAvion tipoViajeAvion;

    public Viaje() {
    }

    public Viaje(Integer idViaje) {
        this.idViaje = idViaje;
    }

    public Integer getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(Integer idViaje) throws Exception {
        if (idViaje == null || idViaje <= 0) {
            throw new ExcepcionAtributos("ERROR. Id de viaje inválido.");
        } else {
            this.idViaje = idViaje;
        }
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) throws Exception {
        if (origen == null || origen.isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Origen de viaje inválido.");
        } else {
            this.origen = origen;
        }
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) throws Exception {
        if (destino == null || destino.isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Destino de viaje inválido.");
        } else {
            this.destino = destino;
        }
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) throws Exception {
        if (precio == null || precio <= 0) {
            throw new ExcepcionAtributos("ERROR. Precio de viaje inválido.");
        } else {
            this.precio = precio;
        }
    }

    public Date getFecha() {
        return fecha;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public void setFecha(Date fecha) throws Exception {
        if (fecha == null || fecha.toString().isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Fecha de viaje inválido.");
        } else {
            this.fecha = fecha;
        }
    }

    public TipoViajeAutobus getTipoViajeAutobus() {
        return tipoViajeAutobus;
    }

    public void setTipoViajeAutobus(TipoViajeAutobus tipoViajeAutobus) throws Exception {
        if (tipoViajeAutobus == null) {
            throw new ExcepcionAtributos("ERROR. Tipo de viaje en autoús inválido.");
        } else {
            this.tipoViajeAutobus = tipoViajeAutobus;
        }
    }

    public TipoViajeAvion getTipoViajeAvion() {
        return tipoViajeAvion;
    }

    public void setTipoViajeAvion(TipoViajeAvion tipoViajeAvion) throws Exception {
        if (tipoViajeAvion == null) {
            throw new ExcepcionAtributos("ERROR. Tipo de viaje en avión inválido.");
        } else {
            this.tipoViajeAvion = tipoViajeAvion;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idViaje == null) ? 0 : idViaje.hashCode());
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
        return true;
    }

    // Clases internas.
    public static class Builder {

        private Viaje viaje;

        public Builder() {
            viaje = new Viaje();
        }

        public BuildViajeAvion setViajeAvion(TipoViajeAvion tipoViajeAvion) {
            viaje.tipoViajeAvion = tipoViajeAvion;
            return new Viaje.BuildViajeAvion(viaje);
        }

        public BuildViajeAutobus setViajeAutobus(TipoViajeAutobus tipoViajeAutobus) {
            viaje.tipoViajeAutobus = tipoViajeAutobus;
            return new Viaje.BuildViajeAutobus(viaje);
        }
    }

    public static class BuildViajeAvion {
        private Viaje viaje;

        private BuildViajeAvion(Viaje viaje) {
            this.viaje = viaje;
        }

        public BuildViajeAvion setTipoViajeAvion(TipoViajeAvion tipoViajeAvion) throws Exception {
            this.viaje.setTipoViajeAvion(tipoViajeAvion);
            return this;
        }

        public Viaje build() {
            return this.viaje;
        }
    }

    public static class BuildViajeAutobus {
        private Viaje viaje;

        private BuildViajeAutobus(Viaje viaje) {
            this.viaje = viaje;
        }

        public BuildViajeAutobus setTipoViajeAutobus(TipoViajeAutobus tipoViajeAutobus) throws Exception {
            this.viaje.setTipoViajeAutobus(tipoViajeAutobus);
            return this;
        }

        public Viaje build() {
            return this.viaje;
        }
    }
}
