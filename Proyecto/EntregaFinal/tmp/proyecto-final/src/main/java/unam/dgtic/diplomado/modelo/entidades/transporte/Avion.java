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

    public Avion(Integer idTransporte, String marca, String modelo, Integer capacidadUsuarios,
            Integer capacidadCombustible, Date fechaAdquisicion, String puertoAsignado) {
        super(idTransporte, marca, modelo, capacidadUsuarios, capacidadCombustible, fechaAdquisicion);
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
