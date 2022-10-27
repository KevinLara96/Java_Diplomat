package mx.unam.diplomado.modelo.entidades.viaje;

import java.time.LocalDate;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import mx.unam.diplomado.modelo.entidades.agencia.Agencia;

public class Viaje {

    @Id
    private Integer idViaje;
    private String origen;
    private String destino;
    private Float precio;
    private Integer distancia;
    private String fecha;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idTipoTour", referencedColumnName = "idTipoTour")
    private TipoTour tipoTour;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idTipoViaje", referencedColumnName = "idTipoViaje")
    private TipoViaje tipoViaje;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idAgencia")
    private Agencia agencia;

    public Viaje() {
    }

    public Viaje(Integer idViaje, String origen, String destino, float precio, int distancia, String fecha) {
        // setIdViaje(idViaje);
        setOrigen(origen);
        setDestino(destino);
        setPrecio(precio);
        setDistancia(distancia);
        setFecha(fecha);
    }

    public Integer getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(Integer idViaje) {
        if (idViaje <= 0 || idViaje == null) {
            Random rand = new Random();
            this.idViaje = rand.nextInt(999);
        } else {
            this.idViaje = idViaje;
        }
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        if (origen.length() <= 0 || origen == null) {
            this.origen = "Ciudad de México";
        } else {
            this.origen = origen;
        }
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        if (destino.length() <= 0 || destino == null) {
            this.destino = "Monterrey";
        } else {
            this.destino = destino;
        }
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        if (precio <= 0) {
            this.precio = 1500.0f;
        } else {
            this.precio = precio;
        }
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        if (distancia <= 0) {
            this.distancia = 800;
        } else {
            this.distancia = distancia;
        }

    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        if (fecha == null) {
            this.fecha = LocalDate.now().toString();
        } else {
            this.fecha = fecha;
        }
    }

    public TipoTour getTipoTour() {
        return tipoTour;
    }

    public void setTipoTour(TipoTour tipoTour) {
        this.tipoTour = tipoTour;
    }

    public TipoViaje getTipoViaje() {
        return tipoViaje;
    }

    public void setTipoViaje(TipoViaje tipoViaje) {
        this.tipoViaje = tipoViaje;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((destino == null) ? 0 : destino.hashCode());
        result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
        result = prime * result + ((idViaje == null) ? 0 : idViaje.hashCode());
        result = prime * result + ((origen == null) ? 0 : origen.hashCode());
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
        if (destino == null) {
            if (other.destino != null)
                return false;
        } else if (!destino.equals(other.destino))
            return false;
        if (fecha == null) {
            if (other.fecha != null)
                return false;
        } else if (!fecha.equals(other.fecha))
            return false;
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
        return true;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        str.append("\nViaje: \n");
        str.append("idViaje: ").append(idViaje);
        str.append(" / Destino: ").append(destino);
        str.append(" / Origen: ").append(origen);
        str.append(" / Precio: ").append(precio);
        str.append(" / Fecha: ").append(fecha);

        return str.toString();
    }

    public static class Builder {
        private Viaje viajeBuilder;

        public Builder() {
            viajeBuilder = new Viaje();
        }

        public Builder(int idViaje, String origen, String destino, float precio, int distancia, String fecha) {
            viajeBuilder = new Viaje(idViaje, origen, destino, precio, distancia, fecha);
        }

        public BuildViajeCorto setViajeCorto() {
            return new BuildViajeCorto(viajeBuilder);
        }

        public BuildViajeMedio setViajeMedio() {
            return new BuildViajeMedio(viajeBuilder);
        }

        public BuildViajeLargo setViajeLargo() {
            return new BuildViajeLargo(viajeBuilder);
        }

        public BuildTour setTour() {
            return new BuildTour(viajeBuilder);
        }
    }

    public static class BuildViajeCorto {
        private Viaje viaje;

        public BuildViajeCorto(Viaje viaje) {
            this.viaje = viaje;
        }

        public BuildViajeCorto setDuracionViaje() {
            return this;
        }

        public Viaje build() {
            return viaje;
        }
    }

    public static class BuildViajeMedio {
        private Viaje viaje;

        public BuildViajeMedio(Viaje viaje) {
            this.viaje = viaje;
        }

        public BuildViajeMedio setDuracionViaje() {
            return this;
        }

        public Viaje build() {
            return viaje;
        }
    }

    public static class BuildViajeLargo {
        private Viaje viaje;

        public BuildViajeLargo(Viaje viaje) {
            this.viaje = viaje;
        }

        public BuildViajeLargo setDuracionViaje() {
            return this;
        }

        public Viaje build() {
            return viaje;
        }
    }

    public static class BuildTour {
        private Viaje viaje;

        public BuildTour(Viaje viaje) {
            this.viaje = viaje;
        }

        public BuildTour setDuracionTour() {
            return this;
        }

        public Viaje build() {
            return viaje;
        }
    }

}
