package unam.dgtic.diplomado.controlador.repositorio.orden;

import unam.dgtic.diplomado.modelo.entidades.orden.OrdenProducto;

public interface RepositorioOrdenProducto {

    public Iterable<OrdenProducto> obtenerOrdenesProductos();

    public OrdenProducto obtenerOrdenProducto(Integer idOrdenProducto, Integer idProducto);

    public void guardarOrdenProducto(OrdenProducto ordenProducto) throws Exception;

    public void eliminarOrdenProducto(Integer idOrden, Integer idProducto);

    public void actualizarOrdenProducto(OrdenProducto ordenProductoParam);

}
