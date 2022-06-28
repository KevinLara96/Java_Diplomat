package dgtic.inicio;

import dgtic.modelo.*;

public class Inicio {
    public static void main(String[] args) {
        Lista lista = new Lista(new Nodo("Hola"));

        lista.insertar(new Nodo("Adiós"));
        lista.insertar(new Nodo(5));

        System.out.println(lista);
    }
}
