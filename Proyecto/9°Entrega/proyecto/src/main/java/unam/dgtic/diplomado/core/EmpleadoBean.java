package unam.dgtic.diplomado.core;

import java.io.Serializable;
//import java.util.ArrayList;
import java.util.HashSet;
//import java.util.List;
import java.util.Set;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class EmpleadoBean implements Serializable {

    private static final long serialVersionUID = -7258677092121565610L;

    private Integer idEmpleado;
    private String nombre;
    private String correo;
    private String contrasena;
    private String rfc;
    private Float salario;

    private AgenciaBean agencia;
    private Set<EmpleadoEntity> empleados;
    // private PuestoBean puesto;

    public EmpleadoBean() {
        this.empleados = new HashSet<>();
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

    public Set<EmpleadoEntity> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set<EmpleadoEntity> empleados) {
        this.empleados = empleados;
    }

    /*
     * public String agregarEmpleado() {
     * 
     * EmpleadoEntity empleadoBean = new EmpleadoEntity();
     * empleadoBean.setIdEmpleado(this.idEmpleado);
     * empleadoBean.setNombre(this.nombre);
     * empleadoBean.setCorreo(this.correo);
     * empleadoBean.setContrasena(this.contrasena);
     * empleadoBean.setRfc(this.rfc);
     * empleadoBean.setSalario(this.salario);
     * empleadoBean.setAgencia(new AgenciaBean());
     * 
     * empleados.add(empleadoBean);
     * 
     * // empleados.add(this);
     * 
     * return "confirmacion";
     * }
     */

}