package dgtic.modelo.viaje;

import java.io.Serializable;
import java.time.LocalDate;

import dgtic.modelo.viaje.interfaces.TipoViaje;

public class Viaje implements Serializable {
    private int idViaje;
    private String origen;
    private String destino;
    private float precio;
    private int distancia;
    private LocalDate fecha;
    private TipoViaje tipoViaje;

    public Viaje(String origen, String destino, float precio, int distancia, LocalDate fecha, TipoViaje tipoViaje) {
        setTipoViaje(tipoViaje);
        setOrigen(origen);
        setDestino(destino);
        setPrecio(precio);
        setDistancia(distancia);
        setFecha(fecha);
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

    public TipoViaje getTipoViaje() {
        return tipoViaje;
    }

    public void setTipoViaje(TipoViaje tipoViaje) {
        this.tipoViaje = tipoViaje;
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
