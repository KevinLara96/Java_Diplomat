package unam.dgtic.diplomado.core;

public class ViajeEntity {

    private Integer idViaje;
    private String origen;
    private String destino;
    private Float precio;
    private Integer distancia;
    private String fecha;
    private String tipoViaje;

    private AgenciaEntity agenciaEntity;

    public Integer getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(Integer idViaje) {
        this.idViaje = idViaje;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public AgenciaEntity getAgenciaEntity() {
        return agenciaEntity;
    }

    public void setAgenciaEntity(AgenciaEntity agenciaEntity) {
        this.agenciaEntity = agenciaEntity;
    }

    public String getTipoViaje() {
        return tipoViaje;
    }

    public void setTipoViaje(String tipoViaje) {
        this.tipoViaje = tipoViaje;
    }

}
