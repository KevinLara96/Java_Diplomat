package unam.dgtic.diplomado.controlador.repositorio.orden;

import unam.dgtic.diplomado.modelo.entidades.orden.Producto;

public interface RepositorioProducto {

    public Iterable<Producto> obtenerProductos();

    public Producto obtenerProducto(Integer idProducto);

    public void guardarProducto(Producto producto) throws Exception;

    public void eliminarProducto(Integer idProducto);

    public void actualizarProducto(Producto productoParam);

}
