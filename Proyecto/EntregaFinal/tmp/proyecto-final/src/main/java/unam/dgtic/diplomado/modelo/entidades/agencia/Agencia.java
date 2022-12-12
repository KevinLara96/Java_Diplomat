package unam.dgtic.diplomado.modelo.entidades.agencia;

import java.util.ArrayList;
import java.util.List;

import unam.dgtic.diplomado.modelo.entidades.cliente.Cliente;
import unam.dgtic.diplomado.modelo.entidades.empleado.Empleado;
import unam.dgtic.diplomado.modelo.entidades.transporte.Transporte;
import unam.dgtic.diplomado.modelo.entidades.viaje.Viaje;
import unam.dgtic.diplomado.modelo.excepciones.ExcepcionAtributos;

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

    public void setIdAgencia(Integer idAgencia) throws Exception {
        if (idAgencia == null || idAgencia <= 0) {
            throw new ExcepcionAtributos("Id para agencia inválido.");
        } else {
            this.idAgencia = idAgencia;
        }
    }

    public String getNombreAgencia() {
        return nombreAgencia;
    }

    public void setNombreAgencia(String nombreAgencia) throws Exception {
        if (nombreAgencia == null || nombreAgencia.isEmpty()) {
            throw new ExcepcionAtributos("Nombre de agencia inválido.");
        } else {
            this.nombreAgencia = nombreAgencia;
        }
    }

    public String getUbicacionAgencia() {
        return ubicacionAgencia;
    }

    public void setUbicacionAgencia(String ubicacionAgencia) throws Exception {
        if (ubicacionAgencia == null || ubicacionAgencia.isEmpty()) {
            throw new ExcepcionAtributos("Ubicación de agencia inválido.");
        } else {
            this.ubicacionAgencia = ubicacionAgencia;
        }
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) throws Exception {
        if (empleados == null || empleados.isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Lista de empleados vacía.");
        } else {
            this.empleados = empleados;

        }
    }

    public List<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(List<Viaje> viajes) throws Exception {
        if (viajes == null || viajes.isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Lista de viajes vacía.");
        } else {
            this.viajes = viajes;
        }
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) throws Exception {
        if (clientes == null || clientes.isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Lista de clientes vacía.");
        } else {
            this.clientes = clientes;
        }
    }

    public List<Transporte> getTransportes() {
        return transportes;
    }

    public void setTransportes(List<Transporte> transportes) throws Exception {
        if (transportes == null || transportes.isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Lista de transportes vacía.");
        } else {
            this.transportes = transportes;
        }
    }

    @Override
    public String toString() {
        return "Agencia [idAgencia=" + idAgencia + ", nombreAgencia=" + nombreAgencia + ", ubicacionAgencia="
                + ubicacionAgencia + "]";
    }

}