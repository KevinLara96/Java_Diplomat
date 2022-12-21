package unam.dgtic.diplomado.modelo.beans.agencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import unam.dgtic.diplomado.modelo.beans.cliente.ClienteBean;
import unam.dgtic.diplomado.modelo.beans.empleado.EmpleadoBean;
import unam.dgtic.diplomado.modelo.beans.transporte.TransporteBean;
import unam.dgtic.diplomado.modelo.beans.viaje.ViajeBean;
import unam.dgtic.diplomado.modelo.excepciones.ExcepcionAtributos;

@Entity
@Table(name = "agencia")
@Named
@SessionScoped
public class AgenciaBean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAgencia;
    @Column(name = "nombre")
    private String nombreAgencia;
    @Column(name = "ubicacion")
    private String ubicacionAgencia;

    @OneToMany(mappedBy = "agencia")
    private List<EmpleadoBean> empleados;

    @OneToMany(mappedBy = "agencia")
    private List<ViajeBean> viajes;

    @OneToMany(mappedBy = "agencia")
    private List<ClienteBean> clientes;

    @OneToMany(mappedBy = "agencia")
    private List<TransporteBean> transportes;

    public AgenciaBean() {

    }

    public AgenciaBean(Integer idAgencia) {
        this.idAgencia = idAgencia;
    }

    public AgenciaBean(Integer idAgencia, String nombreAgencia, String ubicacionAgencia) {
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

    public List<EmpleadoBean> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<EmpleadoBean> empleados) throws Exception {
        if (empleados == null) {
            throw new ExcepcionAtributos("ERROR. Lista de empleados vacía.");
        } else {
            this.empleados = empleados;

        }
    }

    public List<ViajeBean> getViajes() {
        return viajes;
    }

    public void setViajes(List<ViajeBean> viajes) throws Exception {
        if (viajes == null) {
            throw new ExcepcionAtributos("ERROR. Lista de viajes vacía.");
        } else {
            this.viajes = viajes;
        }
    }

    public List<ClienteBean> getClientes() {
        return clientes;
    }

    public void setClientes(List<ClienteBean> clientes) throws Exception {
        if (clientes == null) {
            throw new ExcepcionAtributos("ERROR. Lista de clientes vacía.");
        } else {
            this.clientes = clientes;
        }
    }

    public List<TransporteBean> getTransportes() {
        return transportes;
    }

    public void setTransportes(List<TransporteBean> transportes) throws Exception {
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