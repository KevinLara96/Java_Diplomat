package dgtic.modelo.autobus.interfaces;

public enum TipoUso {
    VIAJE(1),
    TOUR(2);

    final int idTipoUso;

    TipoUso(int idTipoUso) {
        this.idTipoUso = idTipoUso;
    }
}
