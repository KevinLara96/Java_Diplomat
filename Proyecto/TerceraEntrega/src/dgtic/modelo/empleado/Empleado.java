package dgtic.modelo.empleado;

import java.io.Serializable;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        setPuesto(puesto);
    }

    public String getClaveEmpleado() {
        return this.claveEmpleado;
    }

    public void setClaveEmpleado(String claveEmpleado) {
        if (claveEmpleado.length() <= 0 || claveEmpleado == null) {
            Random rand = new Random();
            this.claveEmpleado = this.nombre.substring(0, 3) + rand.nextInt(999)
                    + "R";
        } else {
            this.claveEmpleado = claveEmpleado;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.length() <= 0 || nombre == null) {
            this.nombre = "Desconocido";
        } else {
            this.nombre = nombre;
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        Random rand = new Random();

        if (!matcher.matches() || correo == null) {
            this.correo = "desconocido" + getNombre().substring(0, 3) +
                    rand.nextInt(100) + "@sak.com";
        } else {
            this.correo = correo;
        }
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        if (contrasena.length() <= 0 || contrasena == null) {
            this.contrasena = "Usuario" + this.getNombre() + "1234#";
        } else {
            this.contrasena = contrasena;
        }
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        if (rfc.length() <= 0 || rfc == null) {
            this.rfc = "AAAA998877A99";
        } else {
            this.rfc = rfc;
        }
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        if (salario <= 0) {
            this.salario = 5000.00f;
        } else {
            this.salario = salario;
        }
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        for (Puesto puest : Puesto.values()) {
            if (puest == puesto) {
                this.puesto = puesto;
                return;
            }
        }
        this.puesto = Puesto.CONDUCTOR;
    }

    @Override
    public String toString() {
        return "Empleado: " + claveEmpleado +
                "/ nombre=" + nombre + ", puesto=" + puesto + ", correo= " + correo + ", rfc=" + rfc + ", salario="
                + salario;
    }
}
