package mx.unam.diplomado.agenciafaces.vo.agencia;

public class Agencia {

    private Integer idAgencia;
    private String nombreAgencia;
    private String ubicacion;

    public Agencia() {

    }

    public Agencia(Integer idAgencia, String nombreAgencia, String ubicacion) {
        this.idAgencia = idAgencia;
        this.nombreAgencia = nombreAgencia;
        this.ubicacion = ubicacion;
    }

    public Integer getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(Integer idAgencia) {
        this.idAgencia = idAgencia;
    }

    public String getNombreAgencia() {
        return nombreAgencia;
    }

    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

}
