package dgtic.modelo.entidades.viaje;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

import javax.persistence.*;

@Entity
@Table(name = "Viaje")
public class Viaje implements Serializable {
    private Integer idViaje;
    private String origen;
    private String destino;
    private Float precio;
    private Integer distancia;
    private String fecha;
    private TipoTour tipoTour;
    private TipoViaje tipoViaje;

    public Viaje() {
    }

    public Viaje(Integer idViaje, String origen, String destino, float precio, int distancia, String fecha) {
        setIdViaje(idViaje);
        setOrigen(origen);
        setDestino(destino);
        setPrecio(precio);
        setDistancia(distancia);
        setFecha(fecha);
    }

    @Id
    @Column(name = "idViaje")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "origen")
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

    @Column(name = "destino")
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

    @Column(name = "precio")
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

    @Column(name = "distancia")
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

    @Column(name = "fecha")
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

    @OneToOne(targetEntity = TipoTour.class, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "idTipoTour", referencedColumnName = "idTipoTour", nullable = false)
    public TipoTour getTipoTour() {
        return tipoTour;
    }

    public void setTipoTour(TipoTour tipoTour) {
        this.tipoTour = tipoTour;
    }

    @OneToOne(targetEntity = TipoViaje.class, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "idTipoViaje", referencedColumnName = "idTipoViaje", nullable = false)
    public TipoViaje getTipoViaje() {
        return tipoViaje;
    }

    public void setTipoViaje(TipoViaje tipoViaje) {
        this.tipoViaje = tipoViaje;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        str.append("Viaje ").append(idViaje);
        str.append("\nDestino: ").append(destino);
        str.append("\nOrigen: ").append(origen);
        str.append("\nPrecio: ").append(precio);
        str.append("\nFecha: ").append(fecha);

        return str.toString();
    }

    public static class Builder {
        private Viaje viajeBuilder;

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

        public BuildViajeMedio setDuracionTour() {
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

        public BuildViajeLargo setDuracionTour() {
            return this;
        }

        public Viaje build() {
            return viaje;
        }
    }
}
