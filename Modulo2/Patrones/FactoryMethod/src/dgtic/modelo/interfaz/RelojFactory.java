package dgtic.modelo.interfaz;

import dgtic.modelo.Reloj;

public abstract class RelojFactory {
    public Reloj crea() {
        Reloj reloj = crearReloj();
        reloj.ponerIndicadores();
        reloj.ponerIndice();

        return reloj;
    }

    protected abstract Reloj crearReloj();
}
