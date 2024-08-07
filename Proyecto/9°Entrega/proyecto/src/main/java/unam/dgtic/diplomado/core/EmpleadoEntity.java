package unam.dgtic.diplomado.core;

public class EmpleadoEntity {

    private Integer idEmpleado;
    private String nombre;
    private String correo;
    private String contrasena;
    private String rfc;
    private Float salario;

    private AgenciaEntity agencia;
    private PuestoEntity puesto;

    public EmpleadoEntity() {

    }

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

    public AgenciaEntity getAgencia() {
        return agencia;
    }

    public void setAgencia(AgenciaEntity agencia) {
        this.agencia = agencia;
    }

    public PuestoEntity getPuesto() {
        return puesto;
    }

    public void setPuesto(PuestoEntity puesto) {
        this.puesto = puesto;
    }

}
