package unam.dgtic.diplomado.modelo.entidades.agencia;

import java.util.ArrayList;
import java.util.List;

import unam.dgtic.diplomado.modelo.entidades.cliente.Cliente;
import unam.dgtic.diplomado.modelo.entidades.empleado.Empleado;
import unam.dgtic.diplomado.modelo.entidades.transporte.Transporte;
import unam.dgtic.diplomado.modelo.entidades.viaje.Viaje;

public class Agencia {

    private Integer idAgencia;
    private String nombreAgencia;
    private String ubicacionAgencia;

    private List<Empleado> empleados;
    private List<Viaje> viajes;
    private List<Cliente> clientes;
    private List<Transporte> transportes;

    public Agencia() {
    }

    public Agencia(Integer idAgencia) {
        this.idAgencia = idAgencia;
    }

    public Agencia(Integer idAgencia, String nombreAgencia, String ubicacionAgencia) {
        this.idAgencia = idAgencia;
        this.nombreAgencia = nombreAgencia;
        this.ubicacionAgencia = ubicacionAgencia;
        this.empleados = new ArrayList<>();
        this.viajes = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.transportes = new ArrayList<>();
    }

    public Integer getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(Integer idAgencia) {
        this.idAgencia = idAgencia;
    }

    public String getNombreAgencia() {
        return nombreAgencia;
    }

    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }

    public String getUbicacionAgencia() {
        return ubicacionAgencia;
    }

    public void setUbicacionAgencia(String ubicacionAgencia) {
        this.ubicacionAgencia = ubicacionAgencia;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(List<Viaje> viajes) {
        this.viajes = viajes;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Transporte> getTransportes() {
        return transportes;
    }

    public void setTransportes(List<Transporte> transportes) {
        this.transportes = transportes;
    }

    @Override
    public String toString() {
        return "Agencia [idAgencia=" + idAgencia + ", nombreAgencia=" + nombreAgencia + ", ubicacionAgencia="
                + ubicacionAgencia + "]";
    }

}