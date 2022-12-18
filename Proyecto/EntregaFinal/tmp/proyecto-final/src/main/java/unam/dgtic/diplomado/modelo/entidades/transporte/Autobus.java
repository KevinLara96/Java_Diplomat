package unam.dgtic.diplomado.modelo.entidades.transporte;

import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import unam.dgtic.diplomado.modelo.excepciones.ExcepcionAtributos;

@Entity(name = "autobus")
@DiscriminatorValue("Autobús")
public class Autobus extends Transporte {

    private String estacionamientoAsignado;

    public Autobus() {
        super();
    }

    public Autobus(Integer idTransporte, String marca, String modelo, Integer capacidadUsuarios,
            Integer capacidadCombustible, Date fechaAdquisicion, String estacionamientoAsignado) {
        super(idTransporte, marca, modelo, capacidadUsuarios, capacidadCombustible, fechaAdquisicion);
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
