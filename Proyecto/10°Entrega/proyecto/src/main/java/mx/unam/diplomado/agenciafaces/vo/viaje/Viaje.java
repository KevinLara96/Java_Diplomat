package mx.unam.diplomado.agenciafaces.vo.viaje;

//import mx.unam.diplomado.agenciafaces.vo.agencia.Agencia;

public class Viaje {

    private Integer idViaje;
    private String origen;
    private String destino;
    private Float precio;
    private String fecha;

    // Para obtener de la Base
    private Integer idAgencia;
    // private Agencia agencia;

    // Para obtener de la Base
    private Integer idTipoViaje;
    // private TipoViaje tipoViaje;

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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /*
     * public TipoViaje getTipoViaje() {
     * return tipoViaje;
     * }
     * 
     * public void setTipoViaje(TipoViaje tipoViaje) {
     * this.tipoViaje = tipoViaje;
     * }
     */

    public Integer getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(Integer idAgencia) {
        this.idAgencia = idAgencia;
    }

    /*
     * public Agencia getAgencia() {
     * return agencia;
     * }
     * 
     * public void setAgencia(Agencia agencia) {
     * this.agencia = agencia;
     * }
     */

    public Integer getIdTipoViaje() {
        return idTipoViaje;
    }

    public void setIdTipoViaje(Integer idTipoViaje) {
        this.idTipoViaje = idTipoViaje;
    }

    @Override
    public String toString() {
        return "Viaje [idViaje=" + idViaje + ", origen=" + origen + ", destino=" + destino + ", precio=" + precio
                + ", fecha=" + fecha + ", idAgencia=" + idAgencia + ", agencia="
                + ", idTipoViaje=" + idTipoViaje + ", tipoViaje=" + "]";
    }

}
