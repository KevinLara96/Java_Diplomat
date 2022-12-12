package unam.dgtic.diplomado.modelo.entidades.transporte;

import java.util.Date;

import unam.dgtic.diplomado.modelo.excepciones.ExcepcionAtributos;

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

    public void setNumeroTurbinas(Integer numeroTurbinas) throws Exception {
        if (numeroTurbinas == null || numeroTurbinas < 2) {
            throw new ExcepcionAtributos("ERROR. Número de turbinas inválido.");
        } else {
            this.numeroTurbinas = numeroTurbinas;

        }
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
        return tmp + ", numeroTurbinas=" + numeroTurbinas + ", puertoAsignado=" + puertoAsignado;
    }

}
