package unam.dgtic.diplomado.controlador.repositorio.producto;

import unam.dgtic.diplomado.modelo.entidades.producto.ProductoEntity;

public interface RepositorioProducto {

    public Iterable<ProductoEntity> obtenerProductos();

    public ProductoEntity obtenerProducto(Integer idProducto);

    public void guardarProducto(ProductoEntity producto) throws Exception;

    public void eliminarProducto(Integer idProducto);

    public void actualizarProducto(ProductoEntity productoParam);

}
