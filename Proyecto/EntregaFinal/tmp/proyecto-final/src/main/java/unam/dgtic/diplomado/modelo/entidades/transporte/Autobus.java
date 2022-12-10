package unam.dgtic.diplomado.modelo.entidades.transporte;

import java.util.Date;

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

    public void setNumeroLlantas(Integer numeroLlantas) {
        this.numeroLlantas = numeroLlantas;
    }

    public String getEstacionamientoAsignado() {
        return estacionamientoAsignado;
    }

    public void setEstacionamientoAsignado(String estacionamientoAsignado) {
        this.estacionamientoAsignado = estacionamientoAsignado;
    }

    @Override
    public String toString() {
        return "Autobus [numeroLlantas=" + numeroLlantas + ", estacionamientoAsignado=" + estacionamientoAsignado + "]";
    }

}
