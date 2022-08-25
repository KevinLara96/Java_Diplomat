package dgtic.modelo.entidades.empleado.conductor;

import java.util.Random;

import dgtic.modelo.entidades.empleado.Empleado;

public class Conductor extends Empleado {
    private Integer claveConductor;

    public Conductor() {
        super();
    }

    public Conductor(Integer claveConductor, String nombre, String correo, String contrasena, String rfc,
            float salario) {
        super(nombre, correo, contrasena, rfc, salario);
        setClaveConductor(claveConductor);
    }

    public Integer getClaveConductor() {
        return claveConductor;
    }

    public void setClaveConductor(int claveConductor) {
        if (claveConductor <= 0) {
            Random rand = new Random();
            this.claveConductor = rand.nextInt(1000);
        } else {
            this.claveConductor = claveConductor;
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
        return super.toString() + ", claveConductor=" + claveConductor;
    }
}
