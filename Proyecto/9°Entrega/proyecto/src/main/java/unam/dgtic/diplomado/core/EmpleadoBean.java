package unam.dgtic.diplomado.core;

import java.io.Serializable;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class EmpleadoBean implements Serializable {

    private static final long serialVersionUID = -7258677092121565610L;

    private Integer idEmpleado = 1;
    private String nombre;
    private String correo;
    private String contrasena;
    private String rfc;
    private Float salario;

    private AgenciaBean agencia;
    // private PuestoBean puesto;

    public EmpleadoBean() {
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

    public AgenciaBean getAgencia() {
        return agencia;
    }

    public void setAgencia(AgenciaBean agencia) {
        this.agencia = agencia;
    }

}