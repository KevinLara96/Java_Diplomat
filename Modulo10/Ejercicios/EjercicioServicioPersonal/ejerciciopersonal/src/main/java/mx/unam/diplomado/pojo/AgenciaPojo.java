package mx.unam.diplomado.pojo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "agencia")
@XmlAccessorType(XmlAccessType.FIELD)
public class AgenciaPojo {

    @XmlElement(required = true)
    private Integer idAgencia;
    @XmlElement(required = true)
    private String nombreAgencia;
    @XmlElement(required = true)
    private String ubicacion;

    // private List<EmpleadoEntity> empleados;

    public AgenciaPojo() {

    }

    public AgenciaPojo(Integer idAgencia, String nombreAgencia, String ubicacion) {
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
