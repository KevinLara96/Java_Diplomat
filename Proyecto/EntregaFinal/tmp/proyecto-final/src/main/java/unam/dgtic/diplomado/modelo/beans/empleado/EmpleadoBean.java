package unam.dgtic.diplomado.modelo.beans.empleado;

import java.io.Serializable;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import unam.dgtic.diplomado.controlador.servicio.agencia.ServicioAgencia;
import unam.dgtic.diplomado.controlador.servicio.empleado.ServicioEmpleado;
import unam.dgtic.diplomado.controlador.servicio.empleado.ServicioPuesto;
import unam.dgtic.diplomado.modelo.entidades.empleado.EmpleadoEntity;

@Named
@SessionScoped
public class EmpleadoBean implements Serializable {

    private ServicioEmpleado servicioEmpleado;
    private ServicioAgencia servicioAgencia;
    private ServicioPuesto servicioPuesto;

    private int idEmpleado;
    private String nombres;
    private String apellidos;
    private String correo;
    private String contrasena;
    private String rfc;
    private Float salario;

    private Integer idAgencia;
    private Integer idPuesto;
    private EmpleadoEntity empleadoEntity;
    private String estatus;

    /*
     * Constructores
     */
    public EmpleadoBean() {
    }

    /*
     * Getters & Setters.
     */
    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    public EmpleadoEntity getEmpleadoEntity() {
        return empleadoEntity;
    }

    public void setEmpleadoEntity(EmpleadoEntity empleado) {
        this.empleadoEntity = empleado;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Integer getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(Integer idAgencia) {
        this.idAgencia = idAgencia;
    }

    public Integer getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(Integer idPuesto) {
        this.idPuesto = idPuesto;
    }

    /*
     * Métodos bean
     */
    public List<EmpleadoEntity> obtenerEmpleados() {
        servicioEmpleado = new ServicioEmpleado();

        return (List<EmpleadoEntity>) servicioEmpleado.obtenerEmpleados();
    }

    public void obtenerEmpleado() {
        servicioEmpleado = new ServicioEmpleado();
        this.empleadoEntity = servicioEmpleado.obtenerEmpleado(this.idEmpleado);
    }

    public void actualizarEmpleado() {
        servicioEmpleado = new ServicioEmpleado();
        servicioAgencia = new ServicioAgencia();
        servicioPuesto = new ServicioPuesto();

        EmpleadoEntity empleadoMod = servicioEmpleado.obtenerEmpleado(this.idEmpleado);
        try {
            empleadoMod.setIdEmpleado(this.idEmpleado);
            empleadoMod.setNombres(empleadoEntity.getNombres());
            empleadoMod.setApellidos(empleadoEntity.getApellidos());
            empleadoMod.setCorreo(empleadoEntity.getCorreo());
            empleadoMod.setContrasena(empleadoEntity.getContrasena());
            empleadoMod.setRfc(empleadoEntity.getRfc());
            empleadoMod.setSalario(empleadoEntity.getSalario());

            empleadoMod.setPuesto(servicioPuesto.obtenerPuesto(
                    empleadoEntity.getPuesto().getIdPuesto()));
            empleadoMod.setAgencia(servicioAgencia.obtenerAgencia(
                    empleadoEntity.getAgencia().getIdAgencia()));

            servicioEmpleado.actualizarEmpleado(empleadoMod);
            this.estatus = "Empleado actualizado con éxito";
        } catch (Exception e) {
            this.estatus = "ERROR. No se pudo actualizar el empleado: " + e.getMessage();
        }
    }

    public void nuevoEmpleado() {
        servicioEmpleado = new ServicioEmpleado();
        servicioAgencia = new ServicioAgencia();
        servicioPuesto = new ServicioPuesto();
        this.empleadoEntity = new EmpleadoEntity();

        try {
            empleadoEntity.setIdEmpleado(this.idEmpleado);
            empleadoEntity.setNombres(this.nombres);
            empleadoEntity.setApellidos(this.apellidos);
            empleadoEntity.setCorreo(this.correo);
            empleadoEntity.setContrasena(this.contrasena);
            empleadoEntity.setRfc(this.rfc);
            empleadoEntity.setSalario(this.salario);

            empleadoEntity.setAgencia(servicioAgencia.obtenerAgencia(this.idAgencia));
            empleadoEntity.setPuesto(servicioPuesto.obtenerPuesto(this.idPuesto));

            servicioEmpleado.guardarEmpleado(empleadoEntity);
            this.estatus = "Empleado registrado con éxito.";
        } catch (Exception e) {
            this.estatus = "ERROR. No se pudo registrar el empleado:" +
                    e.getMessage();
        }
    }

    public void eliminarEmpleado() {
        servicioEmpleado = new ServicioEmpleado();
        try {
            if (servicioEmpleado.eliminarEmpleado(this.idEmpleado)) {
                this.estatus = "Empleado eliminado con éxito";
            } else {
                this.estatus = "ERROR. No se pudo eliminar el empleado";
            }
        } catch (Exception e) {
            this.estatus = "ERROR. No se pudo eliminar el empleado";
        }
    }
}
