package modelo.camion;

import modelo.empleado.*;

public class Camion {
    private String marca;
    private String modelo;
    private short anio;
    private short capacidad;
    private Conductor conductorAsignado;

    public Camion() {
    }

    public Camion(short capacidad, Conductor conductorAsignado) {
        this.capacidad = capacidad;
        this.conductorAsignado = conductorAsignado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        try {
            this.marca = marca;
        } catch (Exception e) {
            System.out.println("Valor no válido");
        }
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public short getAnio() {
        return anio;
    }

    public void setAnio(short anio) {
        this.anio = anio;
    }

    public short getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(short capacidad) {
        this.capacidad = capacidad;
    }

    public Conductor getConductorAsignado() {
        return conductorAsignado;
    }

    public void setConductorAsignado(Conductor conductorAsignado) {
        this.conductorAsignado = conductorAsignado;
    }

    @Override
    public String toString() {
        return "[anio=" + anio +
                "\n capacidad=" + capacidad +
                "\n conductorAsignado=" + conductorAsignado +
                "\n marca=" + marca +
                "\n modelo=" + modelo + "]";
    }

}
