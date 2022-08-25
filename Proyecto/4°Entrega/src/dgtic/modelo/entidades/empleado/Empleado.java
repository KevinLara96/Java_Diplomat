package dgtic.modelo.entidades.empleado;

import java.io.Serializable;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Empleado implements Serializable {
    private String nombre;
    private String correo;
    private String contrasena;
    private String rfc;
    private Float salario;

    public Empleado() {
    }

    public Empleado(String nombre, String correo, String contrasena, String rfc, float salario) {
        setNombre(nombre);
        setCorreo(correo);
        setContrasena(contrasena);
        setRfc(rfc);
        setSalario(salario);
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

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        if (salario <= 0) {
            this.salario = 5000.00f;
        } else {
            this.salario = salario;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        str.append("Empleado: \nnombre=").append(this.nombre);
        str.append(", correo=").append(this.correo);
        str.append(", rfc=" + this.rfc + ", salario=" + this.salario);

        return str.toString();
    }
}
