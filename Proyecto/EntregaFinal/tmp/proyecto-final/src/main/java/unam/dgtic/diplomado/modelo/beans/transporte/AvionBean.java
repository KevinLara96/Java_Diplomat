package unam.dgtic.diplomado.modelo.beans.transporte;

import java.util.Date;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import unam.dgtic.diplomado.modelo.excepciones.ExcepcionAtributos;

@Named
@SessionScoped
public class AvionBean extends TransporteBean {

    private String puertoAsignado;

    public AvionBean() {
        super();
    }

    public AvionBean(Integer idTransporte, String marca, String modelo, Integer capacidadCombustible,
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
