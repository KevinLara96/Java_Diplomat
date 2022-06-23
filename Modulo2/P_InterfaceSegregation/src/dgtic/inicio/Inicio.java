package dgtic.inicio;

import dgtic.modelo.AlmacenarAdicionalImpl;
import dgtic.modelo.AlmacenarIntfAdicional;
import dgtic.modelo.AlmacenarIntfSimple;
import dgtic.modelo.Cifrado;

public class Inicio {
    public static void main(String[] args) {
        AlmacenarIntfSimple simple = new AlmacenarAdicionalImpl();
        simple.guardarMensaje("Mensaje");

        AlmacenarIntfAdicional complejo = new AlmacenarAdicionalImpl();
        complejo.setCifrado(Cifrado.FUERTE);
        complejo.guardarMensaje("Complejo");
    }
}
