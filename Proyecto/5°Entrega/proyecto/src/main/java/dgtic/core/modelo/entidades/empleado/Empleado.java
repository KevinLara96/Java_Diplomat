package dgtic.core.modelo.entidades.empleado;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dgtic.core.modelo.entidades.agencia.Agencia;
import dgtic.core.modelo.entidades.puesto.Puesto;

public class Empleado {
    private Integer idEmpleado;
    private String nombre;
    private String correo;
    private String contrasena;
    private String rfc;
    private Float salario;
    private Puesto puesto;
    private Agencia agencia;

    public Empleado() {
    }

    public Empleado(String nombre, String correo, String contrasena, String rfc, Float salario) {
        setNombre(nombre);
        setCorreo(correo);
        setContrasena(contrasena);
        setRfc(rfc);
        setSalario(salario);
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        if (idEmpleado <= 0 || idEmpleado == null) {
            Random rand = new Random();
            this.idEmpleado = rand.nextInt(1000);
        } else {
            this.idEmpleado = idEmpleado;
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
            this.rfc = "";
        } else {
            this.rfc = rfc;
        }
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        if (salario < 0) {
            this.salario = 5000.00f;
        } else {
            this.salario = salario;
        }
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        str.append("\nEmpleado: \n");
        str.append("idEmpleado: ").append(idEmpleado);
        str.append(", nombre: ").append(this.nombre);
        str.append(", correo: ").append(this.correo);
        str.append(", rfc=" + this.rfc + ", salario=" + this.salario);

        return str.toString();
    }

}
