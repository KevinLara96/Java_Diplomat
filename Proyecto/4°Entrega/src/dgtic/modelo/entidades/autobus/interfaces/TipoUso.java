package dgtic.modelo.autobus.interfaces;

public enum TipoUso {
    VIAJE(1),
    TOUR(2);

    public final int ID_TIPO_USO;

    TipoUso(int idTipoUso) {
        this.ID_TIPO_USO = idTipoUso;
    }
}
