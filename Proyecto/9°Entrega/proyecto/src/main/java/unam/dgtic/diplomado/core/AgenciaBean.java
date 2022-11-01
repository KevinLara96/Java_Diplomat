package unam.dgtic.diplomado.core;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class AgenciaBean implements Serializable {

    private static final long serialVersionUID = -7258677092121565613L;

    private Integer idAgencia;
    private String nombreAgencia;
    private String ubicación;
    private Set<EmpleadoEntity> empleados;

    public AgenciaBean() {
        this.nombreAgencia = "Agencia 1";
        this.ubicación = "Ciudad de México";
        this.empleados = new HashSet<>();

        EmpleadoEntity emp = new EmpleadoEntity();
        emp.setIdEmpleado(1);
        emp.setNombre("SYS");
        emp.setCorreo("sys@sak.com");
        emp.setContrasena("system1");
        emp.setRfc("-");
        emp.setSalario(0.0f);
        emp.setAgencia(this);

        empleados.add(emp);
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

    public String getUbicación() {
        return ubicación;
    }

    public void setUbicación(String ubicación) {
        this.ubicación = ubicación;
    }

    public Set<EmpleadoEntity> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set<EmpleadoEntity> empleados) {
        this.empleados = empleados;
    }

    public String agregarEmpleado(EmpleadoBean empleado) {
        EmpleadoEntity emp = new EmpleadoEntity();
        emp.setIdEmpleado(empleado.getIdEmpleado());
        emp.setNombre(empleado.getNombre());
        emp.setCorreo(empleado.getCorreo());
        emp.setContrasena(empleado.getContrasena());
        emp.setRfc(empleado.getRfc());
        emp.setSalario(empleado.getSalario());
        emp.setAgencia(this);

        empleados.add(emp);

        return "confirmacion";
    }
}
