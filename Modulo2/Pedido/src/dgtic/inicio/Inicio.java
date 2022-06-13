package dgtic.inicio;

import dgtic.modelo.*;

public class Inicio {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        Articulo articulo = new Articulo();
        pedido.getArticulos().add(articulo);
        articulo = new Articulo();
        pedido.getArticulos().add(articulo);

        Direccion direccion = new Direccion();
        pedido.getDirecciones().add(direccion);
        direccion = new Direccion();
        pedido.getDirecciones().add(direccion);

        Cuenta cuenta = new Cuenta();
        pedido.setCuenta(cuenta);

        Pago pago = new Pago();
        cuenta.getPago().add(pago);

        System.out.println(pedido);
    }
}
