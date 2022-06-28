package dgtic.modelo;

import java.util.ArrayList;

public class Pedido {

    private Cuenta cuenta;
    private ArrayList<Articulo> articulos = new ArrayList<>();
    private ArrayList<Direccion> direcciones = new ArrayList<>();
    private boolean status;

    public Pedido() {

    }

    public void enviar() {
        if (this.status)
            System.out.println("Enviar el pedido");
        else
            System.out.println("No hay pago");
    }

    public boolean verificar() {
        if (this.cuenta.verificarPago())
            status = true;
        else
            status = false;
        return status;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }

    public ArrayList<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(ArrayList<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    @Override
    public String toString() {
        return "Pedido [articulos=" + articulos + ", cuenta=" + cuenta + ", direcciones=" + direcciones + ", status="
                + status + "]";
    }
}
