package unam.dgtic.diplomado.modelo.entidades.transporte;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "avion")
@DiscriminatorValue("Avión")
public class AvionEntity extends TransporteEntity {

    @Column(name = "puertoAsignado", insertable = true, updatable = true)
    private String puertoAsignado = "";

    public AvionEntity() {
        super();
    }

    public AvionEntity(Integer idTransporte, String marca, String modelo, Integer capacidadCombustible,
            Date fechaAdquisicion, String puertoAsignado, Integer asientosBasicos, Integer asientosPrimeraClase) {
        super(idTransporte, marca, modelo, capacidadCombustible, fechaAdquisicion, asientosBasicos,
                asientosPrimeraClase);
        this.puertoAsignado = puertoAsignado;
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
        return tmp + ", puertoAsignado=" + puertoAsignado + "]";
    }

}
