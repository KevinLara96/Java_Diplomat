package mx.unam.diplomado.modelo.entidades.agencia;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Entity;

import mx.unam.diplomado.modelo.entidades.empleado.Empleado;
import mx.unam.diplomado.modelo.entidades.agencia.asignaciones.*;
import mx.unam.diplomado.modelo.entidades.viaje.*;
import mx.unam.diplomado.modelo.entidades.autobus.*;

@Entity
@Table(name = "agencia")
public class Agencia {

    @Id
    private Integer idAgencia;
    private String nombreAgencia;
    private String ubicacion;

    @OneToMany(mappedBy = "agencia", fetch = FetchType.LAZY)
    private Set<Viaje> destinos;

    @OneToMany(mappedBy = "agencia", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Empleado> empleados;

    @OneToMany(mappedBy = "agencia", fetch = FetchType.LAZY)
    private Set<Autobus> autobuses;

    @OneToMany(mappedBy = "agencia", fetch = FetchType.LAZY)
    private Set<ConductorViaje> viajesAsignados;

    @OneToMany(mappedBy = "agencia", fetch = FetchType.LAZY)
    private Set<ConductorAutobus> autobusesAsignados;

    public Agencia(Integer idAgencia, String nombre, String ubicacion) {
        this.idAgencia = idAgencia;
        this.nombreAgencia = nombre;
        this.ubicacion = ubicacion;
    }

    public Agencia() {
        this.empleados = new HashSet<>();
        this.destinos = new HashSet<>();
        this.autobuses = new HashSet<>();
        this.viajesAsignados = new HashSet<>();
        this.autobusesAsignados = new HashSet<>();
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

    public Set<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
        // this.empleados.retainAll(empleados);
        // this.empleados.addAll(empleados);
    }

    public Set<Viaje> getDestinos() {
        return destinos;
    }

    public void setDestinos(Set<Viaje> destinos) {
        this.destinos = destinos;
    }

    public Set<Autobus> getAutobuses() {
        return autobuses;
    }

    public void setAutobuses(Set<Autobus> autobuses) {
        this.autobuses = autobuses;
    }

    public Set<ConductorViaje> getViajesAsignados() {
        return viajesAsignados;
    }

    public void setViajesAsignados(Set<ConductorViaje> viajesAsignados) {
        this.viajesAsignados = viajesAsignados;
    }

    public Set<ConductorAutobus> getAutobusesAsignados() {
        return autobusesAsignados;
    }

    public void setAutobusesAsignados(Set<ConductorAutobus> autobusesAsignados) {
        this.autobusesAsignados = autobusesAsignados;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((autobuses == null) ? 0 : autobuses.hashCode());
        result = prime * result + ((autobusesAsignados == null) ? 0 : autobusesAsignados.hashCode());
        result = prime * result + ((destinos == null) ? 0 : destinos.hashCode());
        result = prime * result + ((empleados == null) ? 0 : empleados.hashCode());
        result = prime * result + ((idAgencia == null) ? 0 : idAgencia.hashCode());
        result = prime * result + ((nombreAgencia == null) ? 0 : nombreAgencia.hashCode());
        result = prime * result + ((ubicacion == null) ? 0 : ubicacion.hashCode());
        result = prime * result + ((viajesAsignados == null) ? 0 : viajesAsignados.hashCode());
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
        str.append("\n\nAgencia ").append(nombreAgencia);
        str.append("\nUbicación: ").append(ubicacion);
        str.append("\n\nempleados:\n").append(empleados);
        str.append("\n\ndestinos:\n").append(destinos);
        str.append("\n\nautobuses:\n").append(autobuses);
        str.append("\n\n");
        return str.toString();
    }
}