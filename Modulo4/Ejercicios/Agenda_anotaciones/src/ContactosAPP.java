import java.util.List;

import org.hibernate.Hibernate;

import mx.unam.tic.diplomado.agenda.modelo.entidades.Contacto;
import mx.unam.tic.diplomado.agenda.modelo.entidades.ContactoMedio;
import mx.unam.tic.diplomado.agenda.modelo.hibernate.HibernateUtil;
import mx.unam.tic.diplomado.agenda.servicios.ServiciosContactos;
import mx.unam.tic.diplomado.agenda.servicios.ServiciosContactosImpl;

public class ContactosAPP {

    public static void main(String[] args) {

        HibernateUtil.init();
        ServiciosContactos serviciosContactos = ServiciosContactosImpl.getInstance();

        /*
         * List<Contacto> contactos = serviciosContactos.cargaContactosTodos();
         * for (Contacto contacto : contactos) {
         * System.out.println("El contacto es:" + contacto.getNombre());
         * // Hibernate.initialize(contacto.getTipoContacto());
         * System.out.println("El tipo contacto es:" +
         * contacto.getTipoContacto().getNombre());
         * }
         * 
         * for (ContactoMedio m : contacto.getContactosMedios()) {
         * System.out.println("m" + m.getValor());
         * }
         * 
         * System.out.println("El contacto:" +
         * serviciosContactos.cargaContactoPorIdNQ(2).getNombre());
         * 
         * List<Contacto> contactosPorTipo =
         * serviciosContactos.cargaContactosPorTipo(3);
         * if (contactosPorTipo != null && !contactosPorTipo.isEmpty()) {
         * for (Contacto contacto : contactosPorTipo) {
         * System.out.println("El contacto es:" + contacto.getNombre() + " " +
         * contacto.getApellidos());
         * }
         * } else {
         * System.out.println("No existen contactos por el tipo indicado");
         * }
         */

        List<Contacto> contactosPorMedio = serviciosContactos.cargaContactosPorMedioContacto(1);
        if (contactosPorMedio != null && !contactosPorMedio.isEmpty()) {
            for (Contacto contacto : contactosPorMedio) {
                System.out.println("El contacto es:" + contacto.getNombre() + " " + contacto.getApellidos());
            }
        } else {
            System.out.println("No existen contactos por el medio indicado");
        }

    }

}
