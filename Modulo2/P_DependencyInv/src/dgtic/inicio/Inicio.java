package dgtic.inicio;

import dgtic.repositorio.Inventario;
import dgtic.repositorio.negocio.LogicaAlmacen;

public class Inicio {
    public static void main(String[] args) {
        LogicaAlmacen logica = new LogicaAlmacen(new Inventario());
        System.out.println(logica.necesitaAbastecer("AlmacenDos", "frijol"));
    }
}
