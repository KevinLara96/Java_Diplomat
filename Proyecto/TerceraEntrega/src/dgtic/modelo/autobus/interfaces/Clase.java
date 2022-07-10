package dgtic.modelo.autobus.interfaces;

public enum Clase {
    TURISTA(1),
    EJECUTIVO(2),
    PRIMERA_CLASE(3);

    final int idClase;

    Clase(int idClase) {
        this.idClase = idClase;
    }
}
