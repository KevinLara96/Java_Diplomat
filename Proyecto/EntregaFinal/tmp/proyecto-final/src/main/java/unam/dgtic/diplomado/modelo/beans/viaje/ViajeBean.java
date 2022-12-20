package unam.dgtic.diplomado.modelo.beans.viaje;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import unam.dgtic.diplomado.modelo.beans.agencia.AgenciaBean;
import unam.dgtic.diplomado.modelo.excepciones.ExcepcionAtributos;

@Entity
@Table(name = "viaje")
public class ViajeBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idViaje;
    private String origen;
    private String destino;
    private Float precio;
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "idAgencia")
    private AgenciaBean agencia;

    @ManyToOne
    @JoinColumn(name = "idTipoViajeAutobus")
    private TipoViajeAutobusBean tipoViajeAutobus;
    @ManyToOne
    @JoinColumn(name = "idTipoViajeAvion")
    private TipoViajeAvionBean tipoViajeAvion;

    public ViajeBean() {
    }

    public ViajeBean(Integer idViaje) {
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

    public AgenciaBean getAgencia() {
        return agencia;
    }

    public void setAgencia(AgenciaBean agencia) {
        this.agencia = agencia;
    }

    public void setFecha(Date fecha) throws Exception {
        if (fecha == null || fecha.toString().isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Fecha de viaje inválido.");
        } else {
            this.fecha = fecha;
        }
    }

    public TipoViajeAutobusBean getTipoViajeAutobus() {
        return tipoViajeAutobus;
    }

    public void setTipoViajeAutobus(TipoViajeAutobusBean tipoViajeAutobus) throws Exception {
        if (tipoViajeAutobus == null) {
            throw new ExcepcionAtributos("ERROR. Tipo de viaje en autoús inválido.");
        } else {
            this.tipoViajeAutobus = tipoViajeAutobus;
        }
    }

    public TipoViajeAvionBean getTipoViajeAvion() {
        return tipoViajeAvion;
    }

    public void setTipoViajeAvion(TipoViajeAvionBean tipoViajeAvion) throws Exception {
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
        ViajeBean other = (ViajeBean) obj;
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

        private ViajeBean viaje;

        public Builder() {
            viaje = new ViajeBean();
        }

        public BuildViajeAvion setViajeAvion(TipoViajeAvionBean tipoViajeAvion) {
            viaje.tipoViajeAvion = tipoViajeAvion;
            return new ViajeBean.BuildViajeAvion(viaje);
        }

        public BuildViajeAutobus setViajeAutobus(TipoViajeAutobusBean tipoViajeAutobus) {
            viaje.tipoViajeAutobus = tipoViajeAutobus;
            return new ViajeBean.BuildViajeAutobus(viaje);
        }
    }

    public static class BuildViajeAvion {
        private ViajeBean viaje;

        private BuildViajeAvion(ViajeBean viaje) {
            this.viaje = viaje;
        }

        public BuildViajeAvion setTipoViajeAvion(TipoViajeAvionBean tipoViajeAvion) throws Exception {
            this.viaje.setTipoViajeAvion(tipoViajeAvion);
            return this;
        }

        public ViajeBean build() {
            return this.viaje;
        }
    }

    public static class BuildViajeAutobus {
        private ViajeBean viaje;

        private BuildViajeAutobus(ViajeBean viaje) {
            this.viaje = viaje;
        }

        public BuildViajeAutobus setTipoViajeAutobus(TipoViajeAutobusBean tipoViajeAutobus) throws Exception {
            this.viaje.setTipoViajeAutobus(tipoViajeAutobus);
            return this;
        }

        public ViajeBean build() {
            return this.viaje;
        }
    }
}
