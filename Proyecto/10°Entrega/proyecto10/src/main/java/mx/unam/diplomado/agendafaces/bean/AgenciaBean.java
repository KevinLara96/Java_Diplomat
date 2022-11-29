package mx.unam.diplomado.agendafaces.bean;

import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import mx.unam.diplomado.agendafaces.vo.Viaje;
import mx.unam.diplomado.ejb.IAgenciaEJBLocal;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;

/**
 * Clase que devuelve la lista de contactos.
 */
@Model
public class AgenciaBean {

    @Produces
    @Model
    public List<Viaje> cargaViajes() {

        List<Viaje> viajes = new ArrayList<>();
        IAgenciaEJBLocal service = null;

        try {
            InitialContext ctx = new InitialContext();
            service = (IAgenciaEJBLocal) ctx
                    .lookup("java:app/proyecto10/IAgenciaEJBLocal!mx.unam.diplomado.ejb.IAgenciaEJBLocal");

            if (service != null) {
                viajes = service.cargaViajes();
            } else {
                return new ArrayList<>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return viajes;
    }

}
