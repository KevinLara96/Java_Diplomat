package unam.dgtic.diplomado.controlador.repositorio.producto;

import unam.dgtic.diplomado.modelo.beans.producto.Producto;

public interface RepositorioProducto {

    public Iterable<Producto> obtenerProductos();

    public Producto obtenerProducto(Integer idProducto);

    public void guardarProducto(Producto producto) throws Exception;

    public void eliminarProducto(Integer idProducto);

    public void actualizarProducto(Producto productoParam);

}
