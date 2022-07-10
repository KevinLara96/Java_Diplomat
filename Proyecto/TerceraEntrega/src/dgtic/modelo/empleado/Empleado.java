package dgtic.modelo.empleado;

import java.io.Serializable;
import java.util.Random;

import dgtic.modelo.empleado.puesto.Puesto;

public class Empleado implements Serializable {
    private String claveEmpleado;
    private String nombre;
    private String correo;
    private String contrasena;
    private String rfc;
    private float salario;
    private Puesto puesto;

    public Empleado(String claveEmpleado, String nombre, String correo, String contrasena, String rfc, float salario,
            Puesto puesto) {
        setNombre(nombre);
        setClaveEmpleado(claveEmpleado);
        setCorreo(correo);
        setContrasena(contrasena);
        setRfc(rfc);
        setSalario(salario);
        this.puesto = puesto;
    }

    public String getClaveEmpleado() {
        return this.claveEmpleado;
    }

    public void setClaveEmpleado(String claveEmpleado) {
        if (claveEmpleado.length() <= 0) {
            Random rand = new Random();
            this.claveEmpleado = this.nombre.substring(0, 3) + rand.nextInt(999)
                    + "R";
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.length() <= 0) {
            this.nombre = "Desconocido";
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (correo.length() <= 0) {
            this.correo = "desconocido@sak.com";
        }
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        if (contrasena.length() <= 0) {
            this.contrasena = "Usuario" + this.getNombre() + "1234#";
        }
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        if (rfc.length() <= 0) {
            this.rfc = "AAAA998877A99";
        }
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        if (salario <= 0) {
            this.salario = 5000.00f;
        }
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Empleado: " + claveEmpleado +
                "/ nombre=" + nombre + ", puesto=" + puesto + ", correo= " + correo + ", rfc=" + rfc + ", salario="
                + salario;
    }
}
