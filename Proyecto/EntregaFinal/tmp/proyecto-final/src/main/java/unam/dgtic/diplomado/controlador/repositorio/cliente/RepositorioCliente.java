package unam.dgtic.diplomado.controlador.repositorio.cliente;

import unam.dgtic.diplomado.modelo.entidades.cliente.ClienteEntity;

public interface RepositorioCliente {

    public Iterable<ClienteEntity> obtenerClientes();

    public ClienteEntity obtenerCliente(Integer idCliente);

    public boolean guardarCliente(ClienteEntity cliente) throws Exception;

    public boolean eliminarCliente(Integer idCliente) throws Exception;

    public boolean actualizarCliente(ClienteEntity clienteParam) throws Exception;
}
