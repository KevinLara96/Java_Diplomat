package dgtic.repositorio;

import dgtic.repositorio.negocio.InventarioIntf;

public class Inventario implements InventarioIntf {
    @Override
    public int cantidadProductos(String almacen, String producto) {
        return BaseDeDatos.almacenes.get(almacen).get(producto);
    }
}
