package dgtic.inicio;

import dgtic.mediador.*;

public class Inicio {
    public static void main(String[] args) {
        Mediador mediador = new Mediador();

        mediador.encenderTelevision();
        mediador.subirVolumenTelevision();
        mediador.encenderLuces();
        mediador.apagarRadio();
        mediador.apagarDespertador();
    }
}
