package unam.dgtic.diplomado.controlador.repositorio.cliente;

import unam.dgtic.diplomado.modelo.entidades.cliente.Cliente;

public interface RepositorioCliente {

    public Iterable<Cliente> obtenerClientes();

    public Cliente obtenerCliente(Integer idCliente);

    public void crearCliente(Cliente agenciaNueva) throws Exception;

    public void eliminarCliente();
}
