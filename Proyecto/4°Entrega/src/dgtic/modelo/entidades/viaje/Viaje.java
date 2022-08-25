package dgtic.modelo.entidades.viaje;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

public class Viaje implements Serializable {
    private Integer idViaje;
    private String origen;
    private String destino;
    private Float precio;
    private Integer distancia;
    private String fecha;

    public Viaje(int idViaje, String origen, String destino, float precio, int distancia, String fecha) {
        setIdViaje(idViaje);
        setOrigen(origen);
        setDestino(destino);
        setPrecio(precio);
        setDistancia(distancia);
        setFecha(fecha);
    }

    public void setIdViaje(int idViaje) {
        if (idViaje <= 0) {
            Random rand = new Random();
            this.idViaje = rand.nextInt(999);
        } else {
            this.idViaje = idViaje;
        }
    }

    public int getIdViaje() {
        return idViaje;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        if (precio <= 0) {
            this.precio = 1500.0f;
        } else {
            this.precio = precio;
        }
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
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
