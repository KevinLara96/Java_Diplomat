package modelo.empleado;

public class Empleado {
    private String nombre;
    private String correoInstitucional;
    private String contrasenia;
    private String rfc;
    private float salario;
    private String puesto;

    public Empleado() {
    }

    public Empleado(String nombre, String correoInstitucional, String contrasenia, String rfc, float salario) {
        this.nombre = nombre;
        this.correoInstitucional = correoInstitucional;
        this.contrasenia = contrasenia;
        this.rfc = rfc;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "correoInstitucional=" + correoInstitucional +
                "\n nombre=" + nombre +
                "\n rfc=" + rfc +
                "\n salario=" + salario + "]";
    }

}
