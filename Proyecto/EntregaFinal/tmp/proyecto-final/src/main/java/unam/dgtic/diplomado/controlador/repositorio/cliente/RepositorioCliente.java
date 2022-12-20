package unam.dgtic.diplomado.controlador.repositorio.cliente;

import unam.dgtic.diplomado.modelo.beans.cliente.ClienteBean;

public interface RepositorioCliente {

    public Iterable<ClienteBean> obtenerClientes();

    public ClienteBean obtenerCliente(Integer idCliente);

    public void guardarCliente(ClienteBean cliente) throws Exception;

    public void eliminarCliente(Integer idCliente);

    public void actualizarCliente(ClienteBean clienteParam);
}
