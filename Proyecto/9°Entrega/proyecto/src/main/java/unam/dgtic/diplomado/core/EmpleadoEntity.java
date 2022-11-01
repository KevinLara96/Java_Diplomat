package unam.dgtic.diplomado.core;

public class EmpleadoEntity {

    private Integer idEmpleado;
    private String nombre;
    private String correo;
    private String contrasena;
    private String rfc;
    private Float salario;

    private AgenciaBean agencia;

    public EmpleadoEntity(
            Integer idEmpleado,
            String nombre,
            String correo,
            String contrasena,
            String rfc,
            Float salario,
            AgenciaBean agencia) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rfc = rfc;
        this.salario = salario;
        this.agencia = agencia;
    }

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

    public AgenciaBean getAgencia() {
        return agencia;
    }

    public void setAgencia(AgenciaBean agencia) {
        this.agencia = agencia;
    }

}
