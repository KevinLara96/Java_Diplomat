package mx.unam.diplomado.agendafaces.vo;

public class TipoContacto {

    private Integer idTipoContacto;
    private String nombre;
    private String estatus;

    public TipoContacto() {

    }

    public TipoContacto(Integer idTipoContacto, String nombre, String estatus) {
        this.idTipoContacto = idTipoContacto;
        this.nombre = nombre;
        this.estatus = estatus;
    }

    public Integer getIdTipoContacto() {
        return idTipoContacto;
    }

    public void setIdTipoContacto(Integer idTipoContacto) {
        this.idTipoContacto = idTipoContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

}
