package dgtic.mediador;

import dgtic.modelo.*;

public class Mediador {
    private Lampara lampara;
    private Radio radio;
    private Despertador despertador;
    private Television television;

    public Mediador() {
        this.lampara = new Lampara();
        this.radio = new Radio();
        this.despertador = new Despertador();
        this.television = new Television();
    }

    public void encenderLuces() {
        lampara.enciende();
    }

    public void apagarLuces() {
        lampara.apagar();
    }

    public void encenderRadio() {
        radio.enciende();
    }

    public void apagarRadio() {
        radio.apaga();
    }

    public void encenderTelevision() {
        television.enciende();
    }

    public void apagarTelevision() {
        television.apaga();
    }

    public void subirVolumenTelevision() {
        television.subirVolumen();
    }

    public void bajarVolumenTelevision() {
        television.bajarVolumen();
    }

    public void apagarDespertador() {
        despertador.apagar();
    }

    public void suenaDespertador() {
        despertador.suena();
    }
}
