import java.util.List;

import mx.unam.tic.diplomado.agenda.modelo.entidades.MedioContacto;
import mx.unam.tic.diplomado.agenda.modelo.entidades.TipoContacto;
import mx.unam.tic.diplomado.agenda.modelo.hibernate.HibernateUtil;
import mx.unam.tic.diplomado.agenda.servicios.ServiciosCatalogos;
import mx.unam.tic.diplomado.agenda.servicios.ServiciosCatalogosImpl;

public class CatalogosAPP {

	public static void main(String[] args) {

		HibernateUtil.init();
		ServiciosCatalogos serviciosCatalogos = ServiciosCatalogosImpl.getInstance();
		
		for (TipoContacto tipoContacto : serviciosCatalogos.cargaTiposContacto()) {
			System.out.println("El tipo contacto es:" + tipoContacto.getNombre());
		}

		TipoContacto familiar = serviciosCatalogos.cargaTipoContactoPorId(1);
		System.out.println("El contacto familiar===" + familiar.getNombre());

		List<MedioContacto> mediosContacto = serviciosCatalogos.cargaMediosContacto();

		for (MedioContacto medioContacto : mediosContacto) {
			System.out.println("El medio contacto es:" + medioContacto.getNombre());
		}

		MedioContacto casa = serviciosCatalogos.cargaMedioContactoPorId(1);
		System.out.println("El medio casa===" + casa.getNombre());

	}

}
