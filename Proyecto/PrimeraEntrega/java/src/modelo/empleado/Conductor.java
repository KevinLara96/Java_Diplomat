package modelo.empleado;

import modelo.viaje.Viaje;
import modelo.camion.*;

import java.util.ArrayList;

public class Conductor extends Empleado {
    private int id;
    private ArrayList<Camion> camionesAsignados;
    private Viaje viajeAsignado;

    public Conductor() {
    }

    public Conductor(int id, ArrayList<Camion> camionesAsignados, Viaje viajeAsignado, String nombre,
            String correoInstitucional, String contrasenia, String rfc, float salario) {
        super(nombre, correoInstitucional, contrasenia, rfc, salario);
        this.id = id;
        this.camionesAsignados = camionesAsignados;
        this.viajeAsignado = viajeAsignado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Camion> getCamionesAsignados() {
        return camionesAsignados;
    }

    public void setCamionesAsignados(ArrayList<Camion> camionesAsignados) {
        this.camionesAsignados = camionesAsignados;
    }

    public Viaje getViajeAsignado() {
        return viajeAsignado;
    }

    public void setViajeAsignado(Viaje viajeAsignado) {
        this.viajeAsignado = viajeAsignado;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\ncamionesAsignados=" + camionesAsignados +
                "\n id= " + id +
                "\n viajeAsignado=" + viajeAsignado + "]";
    }

}
