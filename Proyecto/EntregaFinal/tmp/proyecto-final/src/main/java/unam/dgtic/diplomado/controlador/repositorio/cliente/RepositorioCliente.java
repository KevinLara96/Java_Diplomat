package unam.dgtic.diplomado.controlador.repositorio.cliente;

import unam.dgtic.diplomado.modelo.beans.cliente.Cliente;

public interface RepositorioCliente {

    public Iterable<Cliente> obtenerClientes();

    public Cliente obtenerCliente(Integer idCliente);

    public void guardarCliente(Cliente cliente) throws Exception;

    public void eliminarCliente(Integer idCliente);

    public void actualizarCliente(Cliente clienteParam);
}
