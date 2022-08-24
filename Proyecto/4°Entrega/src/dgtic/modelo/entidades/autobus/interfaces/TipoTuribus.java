package dgtic.modelo.autobus.interfaces;

public enum TipoTuribus {
    UN_PISO(1),
    DOS_PISOS(2),
    ARTICULADO(3),
    BIARTICULADO(4),
    NA(0);

    public final int ID_TURIBUS;

    TipoTuribus(int idTuribus) {
        this.ID_TURIBUS = idTuribus;
    }
}
