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
    private Set<EmpleadoBean> empleados;

    public AgenciaBean() {
        this.idAgencia = 1;
        this.nombreAgencia = "Agencia 1";
        this.ubicación = "  Ciudad de México";
        this.empleados = new HashSet<>();

        EmpleadoBean empleado = new EmpleadoBean();
        empleado.setIdEmpleado(5);
        empleado.setNombre("Kevin Lara");
        empleado.setCorreo("kevin96");
        empleado.setContrasena("1HOla");
        empleado.setRfc("LAKS");
        empleado.setSalario(30.0f);
        empleado.setAgencia(this);

        this.empleados.add(empleado);

        empleado = new EmpleadoBean();
        empleado.setIdEmpleado(1);
        empleado.setNombre("Kevin Lara");
        empleado.setCorreo("kevin96");
        empleado.setContrasena("1HOla");
        empleado.setRfc("LAKS");
        empleado.setSalario(30.0f);
        empleado.setAgencia(this);

        this.empleados.add(empleado);
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

    public Set<EmpleadoBean> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set<EmpleadoBean> empleados) {
        this.empleados = empleados;
    }

}
