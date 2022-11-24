package mx.unam.diplomado.agendafaces.bean;

import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import mx.unam.diplomado.agendafaces.vo.Contacto;
import mx.unam.diplomado.agendafaces.vo.TipoContacto;
import mx.unam.diplomado.ejb.IAgendaEJBLocal;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;

/**
 * Clase que devuelve la lista de contactos.
 */
@Model
public class AgendaBean {

    @Produces
    @Model
    public List<Contacto> cargaContactos() {

        List<Contacto> contactos = null;
        IAgendaEJBLocal service = null;

        try {
            InitialContext ctx = new InitialContext();
            service = (IAgendaEJBLocal) ctx
                    .lookup("java:global/agendafaces/AgendaEJB!mx.unam.diplomado.ejb.IAgendaEJBLocal");
            if (service != null) {
                contactos = service.cargaContactos();
            } else {
                return new ArrayList<>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return contactos;
    }

    @Produces
    // @Model
    public List<TipoContacto> cargaTipoContacto() {

        List<TipoContacto> tipoContacto = null;
        IAgendaEJBLocal service = null;

        try {
            InitialContext ctx = new InitialContext();
            service = (IAgendaEJBLocal) ctx
                    .lookup("java:global/agendafaces/AgendaEJB!mx.unam.diplomado.ejb.IAgendaEJBLocal");
            if (service != null) {
                tipoContacto = service.cargaTipoContactos();
            } else {
                tipoContacto = new ArrayList<>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tipoContacto;
    }

}
