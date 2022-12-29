package unam.dgtic.diplomado.modelo.beans.cliente;

import java.io.Serializable;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import unam.dgtic.diplomado.controlador.servicio.agencia.ServicioAgencia;
import unam.dgtic.diplomado.controlador.servicio.cliente.ServicioCliente;
import unam.dgtic.diplomado.modelo.entidades.cliente.ClienteEntity;

@Named
@SessionScoped
public class ClienteBean implements Serializable {

    private ServicioCliente servicioCliente;
    private ServicioAgencia servicioAgencia;
    private ClienteEntity clienteEntity;

    private Integer idCliente;
    private String nombres;
    private String apellidos;
    private String calle;
    private String colonia;
    private String codigoPostal;
    private String telefono;
    private String rfc;
    private String correo;
    private String contrasena;

    private Integer idAgencia;
    private String estatus;

    /*
     * Constructores
     */
    public ClienteBean() {
    }

    /*
     * Getters & Setters
     */
    public ClienteEntity getClienteEntity() {
        return clienteEntity;
    }

    public void setClienteEntity(ClienteEntity clienteEntity) {
        this.clienteEntity = clienteEntity;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
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

    public Integer getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(Integer idAgencia) {
        this.idAgencia = idAgencia;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    /*
     * Métodos Bean
     */
    public List<ClienteEntity> obtenerClientes() {
        servicioCliente = new ServicioCliente();

        return servicioCliente.obtenerClientes();
    }

    public void obtenerCliente() {
        servicioCliente = new ServicioCliente();

        this.clienteEntity = servicioCliente.obtenerCliente(this.idCliente);
    }

    public void actualizarCliente() {
        servicioCliente = new ServicioCliente();
        servicioAgencia = new ServicioAgencia();

        ClienteEntity clienteMod = servicioCliente.obtenerCliente(this.idCliente);
        try {
            clienteMod.setIdCliente(this.idCliente);
            clienteMod.setNombres(this.clienteEntity.getNombres());
            clienteMod.setApellidos(this.clienteEntity.getApellidos());
            clienteMod.setCalle(this.clienteEntity.getCalle());
            clienteMod.setColonia(this.clienteEntity.getColonia());
            clienteMod.setCodigoPostal(this.clienteEntity.getCodigoPostal());
            clienteMod.setTelefono(this.clienteEntity.getTelefono());
            clienteMod.setRfc(this.clienteEntity.getRfc());
            clienteMod.setCorreo(this.clienteEntity.getCorreo());
            clienteMod.setContrasena(this.clienteEntity.getContrasena());

            clienteMod.setAgencia(servicioAgencia.obtenerAgencia(this.idAgencia));
            servicioCliente.actualizarCliente(clienteMod);
            this.estatus = "Cliente actualizado con éxito";
        } catch (Exception e) {
            this.estatus = "No se pudo actualizar el cliente: " + e.getMessage();
        }
    }

    public void nuevoCliente() {
        servicioCliente = new ServicioCliente();
        servicioAgencia = new ServicioAgencia();

        this.clienteEntity = new ClienteEntity();
        try {
            clienteEntity.setIdCliente(this.idCliente);
            clienteEntity.setNombres(this.nombres);
            clienteEntity.setApellidos(this.apellidos);
            clienteEntity.setCalle(this.calle);
            clienteEntity.setColonia(this.colonia);
            clienteEntity.setCodigoPostal(this.codigoPostal);
            clienteEntity.setTelefono(this.telefono);
            clienteEntity.setRfc(this.rfc);
            clienteEntity.setCorreo(this.correo);
            clienteEntity.setContrasena(this.contrasena);

            clienteEntity.setAgencia(servicioAgencia.obtenerAgencia(this.idAgencia));
            servicioCliente.actualizarCliente(clienteEntity);
            this.estatus = "Cliente registrado con éxito";
        } catch (Exception e) {
            this.estatus = "No se pudo registrar el cliente: " + e.getMessage();
        }
    }

    public void eliminarCliente() {
        servicioCliente = new ServicioCliente();

        try {
            if (servicioCliente.eliminarCliente(this.idCliente)) {
                this.estatus = "Cliente eliminado con éxito";
            } else {
                this.estatus = "ERROR. No se pudo eliminar el cliente";
            }
        } catch (Exception e) {
            this.estatus = "ERROR. No se pudo eliminar el cliente";
        }
    }
}