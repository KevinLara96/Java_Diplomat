package unam.dgtic.diplomado.m1100base.dominio.transporte;

import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "Avion")
@DiscriminatorValue("Avión")
public class Avion extends Transporte {

    private Integer numeroTurbinas;
    private String puertoAsignado;

    public Avion() {
        super();
    }

    public Avion(Integer idTransporte, String marca, String modelo, Integer capacidadUsuarios,
            Integer capacidadCombustible, Date fechaAdquisicion, Integer numeroTurbinas, String puertoAsignado) {
        super(idTransporte, marca, modelo, capacidadUsuarios, capacidadCombustible, fechaAdquisicion);
        this.numeroTurbinas = numeroTurbinas;
        this.puertoAsignado = puertoAsignado;
    }

    public Integer getNumeroTurbinas() {
        return numeroTurbinas;
    }

    public void setNumeroTurbinas(Integer numeroTurbinas) {
        this.numeroTurbinas = numeroTurbinas;
    }

    public String getPuertoAsignado() {
        return puertoAsignado;
    }

    public void setPuertoAsignado(String puertoAsignado) {
        this.puertoAsignado = puertoAsignado;
    }

    @Override
    public String toString() {
        String tmp = super.toString();
        return tmp + ", numeroTurbinas=" + numeroTurbinas + ", puertoAsignado=" + puertoAsignado;
    }

}
