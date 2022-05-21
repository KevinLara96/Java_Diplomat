public class Cliente {
    private int idCliente;
    private String nombre;
    private String rfc;
    private String direccion;
    private String comprobanteIngreso;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComprobanteIngreso() {
        return comprobanteIngreso;
    }

    public void setComprobanteIngreso(String comprobanteIngreso) {
        this.comprobanteIngreso = comprobanteIngreso;
    }
}
