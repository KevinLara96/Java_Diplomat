package dgtic.modelo.autobus.interfaces;

public enum Clase {
    TURISTA(1),
    EJECUTIVO(2),
    PRIMERA_CLASE(3),
    NA(0);

    public final int ID_CLASE;

    Clase(int idClase) {
        this.ID_CLASE = idClase;
    }
}
