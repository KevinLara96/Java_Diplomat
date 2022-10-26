package mx.unam.diplomado.forms;

import javax.validation.constraints.NotNull;

//import org.hibernate.validator.constraints.NotBlank;
import jakarta.validation.constraints.NotBlank;

public class EmpleadoForm {

    private Integer idEmpleado;

    private String nombre;

    @NotBlank
    private String correo;

    @NotNull
    private String contrasena;

    @NotNull
    private String rfc;

    @NotNull
    private Float salario;

    @NotBlank
    private String agencia;

    @NotBlank
    private String puesto;

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

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "EmpleadoForm [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", correo=" + correo + ", contrasena="
                + contrasena + ", rfc=" + rfc + ", agencia=" + agencia + ", puesto=" + puesto + "]";
    }

}
