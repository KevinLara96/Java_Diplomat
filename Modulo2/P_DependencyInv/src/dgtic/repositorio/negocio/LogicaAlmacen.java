package dgtic.repositorio.negocio;

import dgtic.repositorio.Inventario;

public class LogicaAlmacen {
    private final Inventario inventario;

    public LogicaAlmacen(Inventario inventario) {
        this.inventario = inventario;
    }

    public boolean necesitaAbastecer(String tienda, String producto) {
        int actualCantidad = inventario.cantidadProductos(tienda, producto);

        return actualCantidad < 50;
    }
}
