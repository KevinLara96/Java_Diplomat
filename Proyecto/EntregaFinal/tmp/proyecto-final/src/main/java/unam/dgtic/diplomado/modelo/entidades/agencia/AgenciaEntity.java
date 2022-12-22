package unam.dgtic.diplomado.modelo.entidades.agencia;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import unam.dgtic.diplomado.modelo.entidades.cliente.ClienteEntity;
import unam.dgtic.diplomado.modelo.entidades.empleado.EmpleadoEntity;
import unam.dgtic.diplomado.modelo.entidades.transporte.TransporteEntity;
import unam.dgtic.diplomado.modelo.entidades.viaje.ViajeEntity;
import unam.dgtic.diplomado.modelo.excepciones.ExcepcionAtributos;

@Entity
@Table(name = "agencia")
public class AgenciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAgencia = 0;
    @Column(name = "nombre")
    private String nombreAgencia = "Prueba";
    @Column(name = "ubicacion")
    private String ubicacionAgencia = "Prueba";

    @OneToMany(mappedBy = "agencia")
    private List<EmpleadoEntity> empleados;

    @OneToMany(mappedBy = "agencia")
    private List<ViajeEntity> viajes;

    @OneToMany(mappedBy = "agencia")
    private List<ClienteEntity> clientes;

    @OneToMany(mappedBy = "agencia")
    private List<TransporteEntity> transportes;

    public AgenciaEntity() {

    }

    public AgenciaEntity(Integer idAgencia) {
        this.idAgencia = idAgencia;
    }

    public AgenciaEntity(Integer idAgencia, String nombreAgencia, String ubicacionAgencia) {
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

    public List<EmpleadoEntity> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<EmpleadoEntity> empleados) throws Exception {
        if (empleados == null) {
            throw new ExcepcionAtributos("ERROR. Lista de empleados vacía.");
        } else {
            this.empleados = empleados;

        }
    }

    public List<ViajeEntity> getViajes() {
        return viajes;
    }

    public void setViajes(List<ViajeEntity> viajes) throws Exception {
        if (viajes == null) {
            throw new ExcepcionAtributos("ERROR. Lista de viajes vacía.");
        } else {
            this.viajes = viajes;
        }
    }

    public List<ClienteEntity> getClientes() {
        return clientes;
    }

    public void setClientes(List<ClienteEntity> clientes) throws Exception {
        if (clientes == null) {
            throw new ExcepcionAtributos("ERROR. Lista de clientes vacía.");
        } else {
            this.clientes = clientes;
        }
    }

    public List<TransporteEntity> getTransportes() {
        return transportes;
    }

    public void setTransportes(List<TransporteEntity> transportes) throws Exception {
        if (transportes == null) {
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