package unam.dgtic.diplomado.modelo.entidades.transporte;

import java.util.Date;

import unam.dgtic.diplomado.modelo.excepciones.ExcepcionAtributos;

public class Autobus extends Transporte {

    private Integer numeroLlantas;
    private String estacionamientoAsignado;

    public Autobus() {
        super();
    }

    public Autobus(Integer idTransporte, String marca, String modelo, Integer capacidadUsuarios,
            Integer capacidadCombustible, Date fechaAdquisicion, Integer numeroLlantas,
            String estacionamientoAsignado) {
        super(idTransporte, marca, modelo, capacidadUsuarios, capacidadCombustible, fechaAdquisicion);
        this.numeroLlantas = numeroLlantas;
        this.estacionamientoAsignado = estacionamientoAsignado;
    }

    public Integer getNumeroLlantas() {
        return numeroLlantas;
    }

    public void setNumeroLlantas(Integer numeroLlantas) throws Exception {
        if (numeroLlantas == null || numeroLlantas < 4) {
            throw new ExcepcionAtributos("ERROR. Número de llantas inválido.");
        } else {
            this.numeroLlantas = numeroLlantas;
        }
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
        return "Autobus [numeroLlantas=" + numeroLlantas + ", estacionamientoAsignado=" + estacionamientoAsignado + "]";
    }

}
