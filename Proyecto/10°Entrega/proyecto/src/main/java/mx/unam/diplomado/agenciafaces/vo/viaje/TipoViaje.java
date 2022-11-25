package mx.unam.diplomado.agenciafaces.vo.viaje;

public class TipoViaje {

    private Integer idTipoViaje;
    private String tipoViaje;

    public TipoViaje() {

    }

    public TipoViaje(Integer idTipoViaje, String tipoViaje) {
        this.idTipoViaje = idTipoViaje;
        this.tipoViaje = tipoViaje;
    }

    public Integer getIdTipoViaje() {
        return idTipoViaje;
    }

    public void setIdTipoViaje(Integer idTipoViaje) {
        this.idTipoViaje = idTipoViaje;
    }

    public String getTipoViaje() {
        return tipoViaje;
    }

    public void setTipoViaje(String tipoViaje) {
        this.tipoViaje = tipoViaje;
    }

}
