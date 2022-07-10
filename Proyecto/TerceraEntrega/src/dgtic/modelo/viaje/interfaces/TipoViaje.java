package dgtic.modelo.viaje.interfaces;

public enum TipoViaje {
    CORTO(1),
    MEDIO(2),
    LARGO(3);

    final int idTipoViaje;

    TipoViaje(int idTipoViaje) {
        this.idTipoViaje = idTipoViaje;
    }
}
