package dgtic.modelo;

public class Lista {
    private Nodo primero;
    private Nodo actual;

    public Lista(Nodo nodo) {
        this.primero = nodo;
        this.actual = nodo;
    }

    public void insertar(Nodo nodo) {
        this.actual.setSiguiente(nodo);
        this.actual = nodo;
    }

    public void eliminar() {

    }

    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public Nodo getActual() {
        return actual;
    }

    public void setActual(Nodo actual) {
        this.actual = actual;
    }

    @Override
    public String toString() {
        return "Lista \n[primero=" + primero +
                "\nactual = " + this.actual + "]";
    }

}
