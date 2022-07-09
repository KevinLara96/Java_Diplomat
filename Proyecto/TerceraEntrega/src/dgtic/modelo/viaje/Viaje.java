package dgtic.modelo.viaje;

import java.io.Serializable;
//import java.sql.Date;
import java.time.LocalDate;

public class Viaje implements Serializable {
    private String origen;
    private String destino;
    private float precio;
    private int distancia;
    private LocalDate fecha;

    public Viaje(String origen, String destino, float precio, int distancia, LocalDate fecha) {
        this.origen = origen;
        this.destino = destino;
        this.precio = precio;
        this.distancia = distancia;
        this.fecha = fecha;
    }

    public Viaje() {
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Viaje [" +
                origen + " -> " + destino +
                "\n distancia=" + distancia +
                "\n fecha=" + fecha +
                "\n precio=" + precio + "]";
    }
}
