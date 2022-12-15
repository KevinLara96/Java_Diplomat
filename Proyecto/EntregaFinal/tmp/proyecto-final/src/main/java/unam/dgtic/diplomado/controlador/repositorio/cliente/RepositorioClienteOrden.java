package unam.dgtic.diplomado.controlador.repositorio.cliente;

import unam.dgtic.diplomado.modelo.entidades.cliente.ClienteOrden;

public interface RepositorioClienteOrden {

    public Iterable<ClienteOrden> obtenerClientesOrdenes();

    public ClienteOrden obtenerClienteOrden(Integer idCliente, Integer idOrden);

    public void guardarClienteOrden(ClienteOrden agenciaNueva) throws Exception;

    public void eliminarClienteOrden(Integer idCliente, Integer idOrden);

    public void actualizarClienteOrden(ClienteOrden clienteOrdenParam);
}
