package unam.dgtic.diplomado.modelo.entidades.transporte;

import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import unam.dgtic.diplomado.modelo.excepciones.ExcepcionAtributos;

@Entity(name = "avion")
@DiscriminatorValue("Avión")
public class Avion extends Transporte {

    private String puertoAsignado;

    public Avion() {
        super();
    }

    public Avion(Integer idTransporte, String marca, String modelo, Integer capacidadCombustible,
            Date fechaAdquisicion, String puertoAsignado, Integer asientosBasicos, Integer asientosPrimeraClase) {
        super(idTransporte, marca, modelo, capacidadCombustible, fechaAdquisicion, asientosBasicos,
                asientosPrimeraClase);
        this.puertoAsignado = puertoAsignado;
    }

    public String getPuertoAsignado() {
        return puertoAsignado;
    }

    public void setPuertoAsignado(String puertoAsignado) throws Exception {
        if (puertoAsignado == null || puertoAsignado.isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Puerto de avión inválido.");
        } else {
            this.puertoAsignado = puertoAsignado;
        }
    }

    @Override
    public String toString() {
        String tmp = super.toString();
        return tmp + ", puertoAsignado=" + puertoAsignado + "]";
    }

}
