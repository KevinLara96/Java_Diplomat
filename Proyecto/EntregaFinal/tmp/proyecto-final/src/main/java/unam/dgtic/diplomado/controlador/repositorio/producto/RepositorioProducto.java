package unam.dgtic.diplomado.controlador.repositorio.producto;

import unam.dgtic.diplomado.modelo.entidades.producto.ProductoEntity;

public interface RepositorioProducto {

    public Iterable<ProductoEntity> obtenerProductos();

    public ProductoEntity obtenerProducto(Integer idProducto);

    public boolean guardarProducto(ProductoEntity producto) throws Exception;

    public boolean eliminarProducto(Integer idProducto) throws Exception;

    public boolean actualizarProducto(ProductoEntity productoParam) throws Exception;

}
