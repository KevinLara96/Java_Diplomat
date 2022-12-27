package unam.dgtic.diplomado.modelo.entidades.transporte;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "autobus")
@DiscriminatorValue("Autobús")
public class AutobusEntity extends TransporteEntity {

    @Column(name = "estacionamientoAsignado", insertable = true, updatable = true)
    private String estacionamientoAsignado = "";

    public AutobusEntity() {
        super();
    }

    public AutobusEntity(Integer idTransporte, String marca, String modelo, Integer capacidadCombustible,
            Date fechaAdquisicion, String estacionamientoAsignado, Integer asientosBasicos,
            Integer asientosPrimeraClase) {
        super(idTransporte, marca, modelo, capacidadCombustible, fechaAdquisicion, asientosBasicos,
                asientosPrimeraClase);
        this.estacionamientoAsignado = estacionamientoAsignado;
    }

    public String getEstacionamientoAsignado() {
        return estacionamientoAsignado;
    }

    public void setEstacionamientoAsignado(String estacionamientoAsignado) {
        this.estacionamientoAsignado = estacionamientoAsignado;
    }

    @Override
    public String toString() {
        String tmp = super.toString();
        return tmp + ", estacionamientoAsignado=" + estacionamientoAsignado + "]";
    }

}
