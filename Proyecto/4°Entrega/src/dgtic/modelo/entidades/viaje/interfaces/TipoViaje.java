package dgtic.modelo.viaje.interfaces;

public enum TipoViaje {
    CORTO(1),
    MEDIO(2),
    LARGO(3);

    public final int ID_TIPO_VIAJE;

    TipoViaje(int idTipoViaje) {
        this.ID_TIPO_VIAJE = idTipoViaje;
    }
}
