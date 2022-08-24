package dgtic.modelo.viaje;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

import dgtic.modelo.viaje.interfaces.TipoViaje;

public class Viaje implements Serializable {
    private int idViaje;
    private String origen;
    private String destino;
    private float precio;
    private int distancia;
    private String fecha;
    private TipoViaje tipoViaje;

    public Viaje(int idViaje, String origen, String destino, float precio, int distancia, String fecha,
            TipoViaje tipoViaje) {
        setIdViaje(idViaje);
        setTipoViaje(tipoViaje);
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
            if (this.getTipoViaje() == TipoViaje.CORTO) {
                this.destino = "Ciudad de México";
            } else if (this.getTipoViaje() == TipoViaje.MEDIO) {
                this.destino = "Guadalajara";
            } else {
                this.destino = "Monterrey";
            }
        } else {
            this.destino = destino;
        }
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        if (precio <= 0) {
            if (this.getTipoViaje() == TipoViaje.CORTO) {
                this.precio = 500.0f;
            } else if (this.getTipoViaje() == TipoViaje.MEDIO) {
                this.precio = 1500.0f;
            } else {
                this.precio = 4000.0f;
            }
        } else {
            this.precio = precio;
        }
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        if (distancia <= 0) {
            if (this.getTipoViaje() == TipoViaje.CORTO) {
                this.distancia = 50;
            } else if (this.getTipoViaje() == TipoViaje.MEDIO) {
                this.distancia = 400;
            } else {
                this.distancia = 800;
            }
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

    public TipoViaje getTipoViaje() {
        return tipoViaje;
    }

    public void setTipoViaje(TipoViaje tipoViaje) {
        // Si el tipo de viaje se especifica, se asigna al viaje.
        for (TipoViaje viaje : TipoViaje.values()) {
            if (viaje == tipoViaje) {
                this.tipoViaje = tipoViaje;
                return;
            }
        }
        // Si no se especifica, se elige uno aleatorio del Enum.
        Random rand = new Random();
        this.tipoViaje = TipoViaje.values()[rand.nextInt(2)];
    }

    @Override
    public String toString() {
        return "Viaje [" + idViaje + "]: " +
                origen + " -> " + destino +
                "\n distancia=" + distancia +
                "\n fecha=" + fecha +
                "\n precio=" + precio + "]";
    }
}
