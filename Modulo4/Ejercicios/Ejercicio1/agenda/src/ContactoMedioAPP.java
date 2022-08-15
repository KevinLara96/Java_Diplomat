import java.util.List;

import mx.unam.tic.diplomado.agenda.modelo.entidades.ContactoMedio;
import mx.unam.tic.diplomado.agenda.modelo.entidades.MedioContacto;
import mx.unam.tic.diplomado.agenda.modelo.hibernate.HibernateUtil;
import mx.unam.tic.diplomado.agenda.servicios.ServiciosCatalogos;
import mx.unam.tic.diplomado.agenda.servicios.ServiciosCatalogosImpl;
import mx.unam.tic.diplomado.agenda.servicios.ServiciosContactos;
import mx.unam.tic.diplomado.agenda.servicios.ServiciosContactosImpl;

public class ContactoMedioAPP {

	public static void main(String[] args) {

		HibernateUtil.init();
		
		ServiciosCatalogos servicioCatalogos = ServiciosCatalogosImpl.getInstance();
		ServiciosContactos serviciosContactos = ServiciosContactosImpl.getInstance();
		
		MedioContacto medioContacto = servicioCatalogos.cargaMedioContactoPorId(1);
		
		List<ContactoMedio> contactosMedio = serviciosContactos.cargaContactosMedio(medioContacto);
		
		if (contactosMedio != null && ! contactosMedio.isEmpty()) {
			System.out.println("Los números de medio de contacto:" + medioContacto.getNombre());
			for (ContactoMedio contactoMedio : contactosMedio) {
				System.out.println("El número es:" 
						+ contactoMedio.getValor() 
						+ " y el nombre del contacto es:" + contactoMedio.getContacto().getNombre());
			}
		}

	}

}
