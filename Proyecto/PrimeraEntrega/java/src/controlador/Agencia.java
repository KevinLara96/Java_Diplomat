package controlador;

import java.util.ArrayList;

import modelo.camion.Camion;
import modelo.empleado.Empleado;
import modelo.viaje.Viaje;

public class Agencia {
    private ArrayList<Empleado> empleados = new ArrayList<>();
    private ArrayList<Camion> camiones = new ArrayList<>();
    private ArrayList<Viaje> viajes = new ArrayList<>();

    public Agencia() {
    }

    public Agencia(Empleado empleado, Camion camion, Viaje viaje) {
        this.empleados.add(empleado);
        this.camiones.add(camion);
        this.viajes.add(viaje);
    }

    public void nuevoDestino() {

    }

    public void eliminarDestino() {

    }

    public void modificarRuta() {

    }

    public void modificarPrecio() {

    }

    public void contratarEmpleado() {

    }

    public void despedirEmpleado() {

    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public ArrayList<Camion> getCamiones() {
        return camiones;
    }

    public void setCamiones(ArrayList<Camion> camiones) {
        this.camiones = camiones;
    }

    public ArrayList<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(ArrayList<Viaje> viajes) {
        this.viajes = viajes;
    }

    public void mostrarEmpleados() {
        short cont = 0;
        for (Empleado empleado : this.empleados) {
            System.out.println("Empleado " + (cont + 1) + empleado.getNombre() + empleado.getPuesto());
        }
    }

    public void mostrarViajes() {
        short cont = 0;
        for (Viaje viaje : this.viajes) {
            System.out.println("Viaje " + (cont + 1) + viaje.getOrigen() + " / " + viaje.getDestino());
        }
    }

    public void mostrarCamiones() {
        short cont = 0;
        for (Camion camion : this.camiones) {
            System.out.println("Camión " + (cont + 1) + camion);
        }
    }

}
