package unam.dgtic.diplomado.modelo.entidades.viaje;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import unam.dgtic.diplomado.modelo.entidades.agencia.AgenciaEntity;
import unam.dgtic.diplomado.modelo.excepciones.ExcepcionAtributos;

@Entity
@Table(name = "viaje")
public class ViajeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @SequenceGenerator(name = "seq_post", allocationSize = 5)
    private Integer idViaje;
    private String origen;
    private String destino;
    private Float precio;
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "idAgencia")
    private AgenciaEntity agencia;

    @ManyToOne
    @JoinColumn(name = "idTipoViajeAutobus")
    private TipoViajeAutobusEntity tipoViajeAutobus;
    @ManyToOne
    @JoinColumn(name = "idTipoViajeAvion")
    private TipoViajeAvionEntity tipoViajeAvion;

    public ViajeEntity() {
    }

    public ViajeEntity(Integer idViaje) {
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

    public AgenciaEntity getAgencia() {
        return agencia;
    }

    public void setAgencia(AgenciaEntity agencia) {
        this.agencia = agencia;
    }

    public void setFecha(Date fecha) throws Exception {
        if (fecha == null || fecha.toString().isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Fecha de viaje inválido.");
        } else {
            this.fecha = fecha;
        }
    }

    public TipoViajeAutobusEntity getTipoViajeAutobus() {
        return tipoViajeAutobus;
    }

    public void setTipoViajeAutobus(TipoViajeAutobusEntity tipoViajeAutobus) throws Exception {
        if (tipoViajeAutobus == null) {
            throw new ExcepcionAtributos("ERROR. Tipo de viaje en autoús inválido.");
        } else {
            this.tipoViajeAutobus = tipoViajeAutobus;
        }
    }

    public TipoViajeAvionEntity getTipoViajeAvion() {
        return tipoViajeAvion;
    }

    public void setTipoViajeAvion(TipoViajeAvionEntity tipoViajeAvion) throws Exception {
        if (tipoViajeAvion == null) {
            throw new ExcepcionAtributos("ERROR. Tipo de viaje en avión inválido.");
        } else {
            this.tipoViajeAvion = tipoViajeAvion;
        }
    }

    public Boolean verificaTipoViaje() {
        // Si es viaje de autobús, avión debe ser 4.
        if (tipoViajeAutobus.getIdTipoViajeAutobus() != 4 && tipoViajeAvion.getIdTipoViajeAvion() == 4) {
            return true;
        }
        // Si es viaje de avión, autobúse debe ser 4.
        if (tipoViajeAvion.getIdTipoViajeAvion() != 4 && tipoViajeAutobus.getIdTipoViajeAutobus() == 4) {
            return true;
        }

        return false;
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
        ViajeEntity other = (ViajeEntity) obj;
        if (idViaje == null) {
            if (other.idViaje != null)
                return false;
        } else if (!idViaje.equals(other.idViaje))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "[idViaje=" + idViaje + ", origen=" + origen + ", destino=" + destino + ", precio=" + precio
                + ", fecha=" + fecha + ", agencia=" + agencia.getUbicacionAgencia() + ", tipoViajeAutobus="
                + tipoViajeAutobus.getTipoViajeAutobus()
                + ", tipoViajeAvion=" + tipoViajeAvion.getTipoViajeAvion() + "]";
    }

    // Clases internas.
    public static class Builder {

        private ViajeEntity viaje;

        public Builder() {
            viaje = new ViajeEntity();
        }

        public BuildViajeAvion setViajeAvion(TipoViajeAvionEntity tipoViajeAvion) {
            viaje.tipoViajeAvion = tipoViajeAvion;
            return new ViajeEntity.BuildViajeAvion(viaje);
        }

        public BuildViajeAutobus setViajeAutobus(TipoViajeAutobusEntity tipoViajeAutobus) {
            viaje.tipoViajeAutobus = tipoViajeAutobus;
            return new ViajeEntity.BuildViajeAutobus(viaje);
        }
    }

    public static class BuildViajeAvion {
        private ViajeEntity viaje;

        private BuildViajeAvion(ViajeEntity viaje) {
            this.viaje = viaje;
        }

        public BuildViajeAvion setTipoViajeAvion(TipoViajeAvionEntity tipoViajeAvion) throws Exception {
            this.viaje.setTipoViajeAvion(tipoViajeAvion);
            return this;
        }

        public ViajeEntity build() {
            return this.viaje;
        }
    }

    public static class BuildViajeAutobus {
        private ViajeEntity viaje;

        private BuildViajeAutobus(ViajeEntity viaje) {
            this.viaje = viaje;
        }

        public BuildViajeAutobus setTipoViajeAutobus(TipoViajeAutobusEntity tipoViajeAutobus) throws Exception {
            this.viaje.setTipoViajeAutobus(tipoViajeAutobus);
            return this;
        }

        public ViajeEntity build() {
            return this.viaje;
        }
    }
}
