package unam.dgtic.diplomado.m1100base.dominio.empleado;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import unam.dgtic.diplomado.m1100base.dominio.agencia.Agencia;

@Access(AccessType.FIELD)
@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    private Integer idEmpleado;
    private String nombre;
    private String correo;
    private String contrasena;
    private String rfc;
    private Float salario;

    @ManyToOne
    @JoinColumn(name = "idAgencia")
    private Agencia agencia;

    @Transient
    private String puesto;

    public Empleado() {
    }

    public Empleado(Integer idEmpleado, String nombre, String correo, String contrasena, String rfc, Float salario) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rfc = rfc;
        this.salario = salario;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idEmpleado == null) ? 0 : idEmpleado.hashCode());
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
        Empleado other = (Empleado) obj;
        if (idEmpleado == null) {
            if (other.idEmpleado != null)
                return false;
        } else if (!idEmpleado.equals(other.idEmpleado))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", correo=" + correo + ", contrasena="
                + contrasena + ", rfc=" + rfc + ", salario=" + salario + ", puesto: " + puesto
                + ", agencia=" + agencia.getUbicacion() + "]";
    }

}
