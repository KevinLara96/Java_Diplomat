package unam.dgtic.diplomado.m1100base.dominio.agencia;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import unam.dgtic.diplomado.m1100base.dominio.cliente.Cliente;
import unam.dgtic.diplomado.m1100base.dominio.empleado.Empleado;

@Entity
@Table(name = "agencia")
public class Agencia {

    @Id
    private Integer idAgencia;
    private String nombreAgencia;
    private String ubicacion;

    @OneToMany(mappedBy = "agencia")
    private List<Empleado> empleados;

    @OneToMany(mappedBy = "agencia")
    private List<Cliente> clientes;

    public Agencia() {
    }

    public Agencia(Integer idAgencia, String nombre, String ubicacion) {
        this.idAgencia = idAgencia;
        this.nombreAgencia = nombre;
        this.ubicacion = ubicacion;
        this.empleados = new ArrayList<>();
    }

    public Integer getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(Integer idAgencia) {
        this.idAgencia = idAgencia;
    }

    public String getNombreAgencia() {
        if (nombreAgencia == null || nombreAgencia.equals("")) {
            return "Agencia Vacía.";
        } else {
            return nombreAgencia;
        }
    }

    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Empleado> getempleados() {
        return empleados;
    }

    public void setempleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((empleados == null) ? 0 : empleados.hashCode());
        result = prime * result + ((idAgencia == null) ? 0 : idAgencia.hashCode());
        result = prime * result + ((nombreAgencia == null) ? 0 : nombreAgencia.hashCode());
        result = prime * result + ((ubicacion == null) ? 0 : ubicacion.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Agencia other = (Agencia) obj;
        if (idAgencia == null) {
            if (other.idAgencia != null)
                return false;
        } else if (!idAgencia.equals(other.idAgencia))
            return false;
        if (nombreAgencia == null) {
            if (other.nombreAgencia != null)
                return false;
        } else if (!nombreAgencia.equals(other.nombreAgencia))
            return false;
        if (ubicacion == null) {
            if (other.ubicacion != null)
                return false;
        } else if (!ubicacion.equals(other.ubicacion))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        str.append("Agencia ").append(nombreAgencia);
        str.append("\nUbicación: ").append(ubicacion);
        str.append("\nempleados: ").append(empleados);
        return str.toString();
    }
}