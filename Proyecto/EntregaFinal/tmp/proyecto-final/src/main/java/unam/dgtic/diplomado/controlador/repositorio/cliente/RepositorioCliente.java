package unam.dgtic.diplomado.controlador.repositorio.cliente;

import unam.dgtic.diplomado.modelo.entidades.cliente.ClienteEntity;

public interface RepositorioCliente {

    public Iterable<ClienteEntity> obtenerClientes();

    public ClienteEntity obtenerCliente(Integer idCliente);

    public void guardarCliente(ClienteEntity cliente) throws Exception;

    public void eliminarCliente(Integer idCliente);

    public void actualizarCliente(ClienteEntity clienteParam);
}
