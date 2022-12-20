package unam.dgtic.diplomado.modelo.beans.transporte;

import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import unam.dgtic.diplomado.modelo.excepciones.ExcepcionAtributos;

@Entity(name = "autobus")
@DiscriminatorValue("Autobús")
public class AutobusBean extends TransporteBean {

    private String estacionamientoAsignado;

    public AutobusBean() {
        super();
    }

    public AutobusBean(Integer idTransporte, String marca, String modelo, Integer capacidadCombustible,
            Date fechaAdquisicion, String estacionamientoAsignado, Integer asientosBasicos,
            Integer asientosPrimeraClase) {
        super(idTransporte, marca, modelo, capacidadCombustible, fechaAdquisicion, asientosBasicos,
                asientosPrimeraClase);
        this.estacionamientoAsignado = estacionamientoAsignado;
    }

    public String getEstacionamientoAsignado() {
        return estacionamientoAsignado;
    }

    public void setEstacionamientoAsignado(String estacionamientoAsignado) throws Exception {
        if (estacionamientoAsignado == null || estacionamientoAsignado.isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Estacionamiento de autobús inválido.");
        } else {
            this.estacionamientoAsignado = estacionamientoAsignado;
        }
    }

    @Override
    public String toString() {
        String tmp = super.toString();
        return tmp + ", estacionamientoAsignado=" + estacionamientoAsignado + "]";
    }

}
