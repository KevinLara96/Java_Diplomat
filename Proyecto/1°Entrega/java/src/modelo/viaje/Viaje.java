package modelo.viaje;

import modelo.camion.Camion;

public class Viaje {
    private String origen;
    private String destino;
    private Camion camionAsignado;
    private float precio;
    private short distancia;

    public Viaje() {
    }

    public Viaje(String origen, String destino, Camion camionAsignado, float precio, short distancia) {
        this.origen = origen;
        this.destino = destino;
        this.camionAsignado = camionAsignado;
        this.precio = precio;
        this.distancia = distancia;
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

    public Camion getCamionAsignado() {
        return camionAsignado;
    }

    public void setCamionAsignado(Camion camionAsignado) {
        this.camionAsignado = camionAsignado;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public short getDistancia() {
        return distancia;
    }

    public void setDistancia(short distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "[camionAsignado=" + camionAsignado +
                "\n destino=" + destino +
                "\n distancia=" + distancia +
                "\n origen=" + origen +
                "\n precio=" + precio + "]";
    }

}
