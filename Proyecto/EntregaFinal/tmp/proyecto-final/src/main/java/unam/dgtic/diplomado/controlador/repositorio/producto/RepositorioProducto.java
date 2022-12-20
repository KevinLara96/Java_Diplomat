package unam.dgtic.diplomado.controlador.repositorio.producto;

import unam.dgtic.diplomado.modelo.beans.producto.ProductoBean;

public interface RepositorioProducto {

    public Iterable<ProductoBean> obtenerProductos();

    public ProductoBean obtenerProducto(Integer idProducto);

    public void guardarProducto(ProductoBean producto) throws Exception;

    public void eliminarProducto(Integer idProducto);

    public void actualizarProducto(ProductoBean productoParam);

}
