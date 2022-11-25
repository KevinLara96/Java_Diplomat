package mx.unam.diplomado.agenciafaces.bean;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;

import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import mx.unam.diplomado.agenciafaces.vo.viaje.Viaje;
import mx.unam.diplomado.ejb.IAgenciaEJB;

/**
 * Clase que devuelve la lista de viajes
 */
@Model
public class AgenciaBean {

    @Produces
    @Model
    public List<Viaje> cargaViajes() {

        List<Viaje> viajes = new ArrayList<>();
        IAgenciaEJB service = null;

        try {
            InitialContext ctx = new InitialContext();
            service = (IAgenciaEJB) ctx
                    .lookup("java:global/proyecto/AgenciaEJB!mx.unam.diplomado.ejb.IAgenciaEJB");

            if (service != null) {
                viajes = service.cargarViajes();
            } else {
                return new ArrayList<>();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return viajes;
    }
}
