package dgtic.modelo.empleado;

import java.io.Serializable;

import dgtic.modelo.empleado.puesto.Puesto;

public class Empleado implements Serializable {
    private String nombre;
    private String correo;
    private String contrasena;
    private String rfc;
    private float salario;
    private Puesto puesto;

    public Empleado(String nombre, String correo, String contrasena, String rfc, float salario, Puesto puesto) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rfc = rfc;
        this.salario = salario;
        this.puesto = puesto;
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

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Empleado: " +
                "nombre=" + nombre + ", puesto=" + puesto + ", correo= " + correo + ", rfc=" + rfc + ", salario="
                + salario;
    }
}
