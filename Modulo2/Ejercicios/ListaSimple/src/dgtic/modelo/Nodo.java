package dgtic.modelo;

public class Nodo {
    private Nodo siguiente;
    private Object elemento;

    public Nodo(Object elemento) {
        this.siguiente = null;
        this.elemento = elemento;
    }

    public Nodo getsiguiente() {
        return this.siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    @Override
    public String toString() {
        return "Nodo [elemento=" + elemento + ", siguiente=" + siguiente + "]";
    }

}
