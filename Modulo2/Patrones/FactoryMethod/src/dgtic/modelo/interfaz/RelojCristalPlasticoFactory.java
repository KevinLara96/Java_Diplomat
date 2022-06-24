package dgtic.modelo.interfaz;

import dgtic.modelo.Reloj;

public class RelojCristalPlasticoFactory extends RelojFactory {

    @Override
    protected Reloj crearReloj() {
        return new CristalPlastico();
    }

}
