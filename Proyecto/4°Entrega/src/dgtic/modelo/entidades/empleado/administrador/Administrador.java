package dgtic.modelo.entidades.empleado.administrador;

import java.util.Random;

import dgtic.modelo.entidades.empleado.Empleado;

public class Administrador extends Empleado {
    private Integer claveAdministrador;

    public Administrador() {
    }

    /* Constructor */
    public Administrador(Integer administradorId, String nombre, String correo, String contrasena, String rfc,
            float salario) {
        super(nombre, correo, contrasena, rfc, salario);
        setClaveAdministrador(administradorId);
    }

    public Integer getClaveAdministrador() {
        return claveAdministrador;
    }

    public void setClaveAdministrador(Integer claveAdministrador) {
        if (claveAdministrador <= 0) {
            Random rand = new Random();
            this.claveAdministrador = rand.nextInt(1000);
        } else {
            this.claveAdministrador = claveAdministrador;
        }
    }

    public String getNombre() {
        return super.getNombre();
    }

    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    public String getCorreo() {
        return super.getCorreo();
    }

    public void setCorreo(String correo) {
        super.setCorreo(correo);
    }

    public String getContrasena() {
        return super.getContrasena();
    }

    public void setContrasena(String contrasena) {
        super.setContrasena(contrasena);
    }

    public String getRfc() {
        return super.getRfc();
    }

    public void setRfc(String rfc) {
        super.setRfc(rfc);
    }

    public Float getSalario() {
        return super.getSalario();
    }

    public void setSalario(Float salario) {
        super.setSalario(salario);
    }

    @Override
    public String toString() {
        return super.toString() + ", claveAdministrador=" + claveAdministrador + "\n";
    }
}
