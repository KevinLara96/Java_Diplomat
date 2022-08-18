package modelo.empleado;

public class Administrador extends Empleado {
    private String claveAdministrador;
    private int idAdministrador;

    public Administrador() {
    }

    public Administrador(String nombre, String correoInstitucional, String contrasenia, String rfc, float salario,
            String claveAdministrador, int idAdministrador) {
        super(nombre, correoInstitucional, contrasenia, rfc, salario);
        this.claveAdministrador = claveAdministrador;
        this.idAdministrador = idAdministrador;
    }

    public String getClaveAdministrador() {
        return claveAdministrador;
    }

    public void setClaveAdministrador(String claveAdministrador) {
        this.claveAdministrador = claveAdministrador;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    @Override
    public String toString() {
        return super.toString() +
                "[claveAdministrador=" + claveAdministrador +
                "\n idAdministrador=" + idAdministrador + "]";
    }

}
