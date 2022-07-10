package dgtic.modelo.autobus.interfaces;

public enum TipoTuribus {
    UN_PISO(1),
    DOS_PISOS(2),
    ARTICULADO(3),
    BIARTICULADO(4);

    final int idTuribus;

    TipoTuribus(int idTuribus) {
        this.idTuribus = idTuribus;
    }
}
