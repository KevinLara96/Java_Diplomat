import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import mx.unam.tic.diplomado.agenda.modelo.entidades.Contacto;
import mx.unam.tic.diplomado.agenda.modelo.entidades.ContactoMedio;
import mx.unam.tic.diplomado.agenda.modelo.entidades.MedioContacto;
import mx.unam.tic.diplomado.agenda.modelo.entidades.TipoContacto;
import mx.unam.tic.diplomado.agenda.modelo.hibernate.HibernateUtil;
import mx.unam.tic.diplomado.agenda.servicios.ServiciosCatalogos;
import mx.unam.tic.diplomado.agenda.servicios.ServiciosCatalogosImpl;
import mx.unam.tic.diplomado.agenda.servicios.ServiciosContactos;
import mx.unam.tic.diplomado.agenda.servicios.ServiciosContactosImpl;

public class Agenda {

	private static Scanner input = new Scanner(System.in);
	private static ServiciosCatalogos serviciosCatalogos = ServiciosCatalogosImpl.getInstance();
	private static ServiciosContactos serviciosContactos = ServiciosContactosImpl.getInstance();

	public static void main(String[] args) {

		HibernateUtil.init();
		System.out.println("\n");
		System.out.println("\n");

		do {
			switch (menuPrincipal()) {
				case 1:
					ingresoUsuario();
					break;

				case 2:
					mostrarDatos();
					break;

				case 3:
					salir();
					break;

				default:
					System.out.println("Por favor, ingrese su opción nuevamente.");
			}
		} while (true);

	}

	public static int menuPrincipal() {
		int opcion = 0;
		System.out.println("Elija una opción: ");
		System.out.println("1. Ingresar nuevo contacto.");
		System.out.println("2. Mostrar lista de contactos.");
		System.out.println("3. Salir.");
		System.out.print("Su opción: ");
		try {
			opcion = Integer.parseInt(input.nextLine());
		} catch (Exception e) {
			System.out.println("Opción inválida. Únicamente se aceptan números del 1 al 3.");
			return 0;
		}
		return opcion;
	}

	public static boolean ingresoUsuario() {
		/* Creación de nuevo contacto. */
		Contacto nuevoContacto = new Contacto();// creacion de contacto
		try {
			System.out.print("\nIngrese el nombre: ");
			nuevoContacto.setNombre(input.nextLine());
			System.out.print("\nIngrese los apellidos: ");
			nuevoContacto.setApellidos(input.nextLine());
			System.out.print("\nIngrese la dirección: ");
			nuevoContacto.setDireccion(input.nextLine());
			System.out.print("\nIngrese la edad: ");
			nuevoContacto.setEdad(Integer.parseInt(input.nextLine())); // lenado de datos de contacto
			nuevoContacto.setEstatus("ACTIVO");

		} catch (Exception e) {
			System.out.println("ERROR: No se pudo crear el contacto, por favor, revise sus " +
					"datos e intente de nuevo.");
			return false;
		}

		/* Asignación de tipo de contacto. */
		try {
			System.out.println("\n\nElija el tipo de contacto.");
			System.out.println("1. Familiar.");
			System.out.println("2. Escolar.");
			System.out.println("3. Laboral.");
			System.out.print("Su opción: ");
			int idTipoContacto = Integer.parseInt(input.nextLine());
			TipoContacto tipoContacto = null;
			if (idTipoContacto < 1 || idTipoContacto > 3) {
				tipoContacto = serviciosCatalogos
						.cargaTipoContactoPorId(1);
				System.out.println("Opción inválida, se asignó tipo familiar.");
			} else {
				tipoContacto = serviciosCatalogos
						.cargaTipoContactoPorId(idTipoContacto);
			}
			// obtencion de catalogo tipo contacto
			nuevoContacto.setTipoContacto(tipoContacto); // relacionamos contacto con tipo contacto
		} catch (Exception e) {
			System.out.println("\nERROR: No se pudo asignar el tipo de contacto, por favor " +
					"revise sus datos e intente de nuevo.");
			return false;
		}

		/* Asignación de medio de contacto. */
		ContactoMedio contactoMedio = new ContactoMedio(); // creacion de contacto medio
		try {
			System.out.println("\nElija el medio de contacto.");
			System.out.println("1. Casa.");
			System.out.println("2. Trabajo.");
			System.out.println("3. Celular.");
			System.out.print("Su opción: ");
			MedioContacto medioContacto = serviciosCatalogos
					.cargaMedioContactoPorId(Integer.parseInt(input.nextLine()));
			// obtencion de catalogo de medio contacto

			System.out.print("\nIngrese el número: ");
			contactoMedio.setValor(input.nextLine()); // llenado de datos de contacto medio
			contactoMedio.setContacto(nuevoContacto); // relacionamos con contacto
			contactoMedio.setMedioContacto(medioContacto); // relacionamos contacto medio con catalogo medio contacto

			// generamos la coleccion
			Set<ContactoMedio> contactosMedios = new HashSet<ContactoMedio>();
			contactosMedios.add(contactoMedio); // llenamos la coleccion
			nuevoContacto.setContactosMedios(contactosMedios); // asignamos la coleccion al contacto
			serviciosContactos.guardaContacto(nuevoContacto); // guardamos al contacto

		} catch (Exception e) {
			System.out.println("\nERROR: No se pudo asignar el medio de contacto, por favor " +
					"revise sus datos e intente de nuevo.");
			return false;
		}

		return true;
	}

	public static void mostrarDatos() {

		List<Contacto> contactos = serviciosContactos.cargaContactos();
		System.out.println("\n");
		System.out.println("\n");
		for (Contacto contacto : contactos) {
			System.out.println("El contacto es:" + contacto.getNombre());
			System.out.println("El tipo contacto es:" + contacto.getTipoContacto().getNombre());
			for (ContactoMedio m : contacto.getContactosMedios()) {
				System.out.println("m" + m.getValor());
			}
			System.out.println("Su estatus es: " + contacto.getEstatus());
		}
		System.out.println("\n");
		System.out.println("\n");
	}

	public static void salir() {
		System.out.println("Fin del programa.");
		System.exit(0);
	}
}

/*
 * List<TipoContacto> tiposContacto = serviciosCatalogos.cargaTiposContacto();
 * for (TipoContacto tipoContacto : tiposContacto) {
 * System.out.println("El tipo contacto es:" + tipoContacto.getNombre());
 * }
 * 
 * TipoContacto familiar = serviciosCatalogos.cargaTipoContactoPorId(1);
 * System.out.println("El contacto familiar===" + familiar);
 * 
 * List<MedioContacto> mediosContacto =
 * serviciosCatalogos.cargaMediosContacto();
 * 
 * for (MedioContacto medioContacto : mediosContacto) {
 * System.out.println("El medio contacto es:" + medioContacto.getNombre());
 * }
 * System.out.println("\n");
 * System.out.println("\n");
 * 
 * MedioContacto casa = serviciosCatalogos.cargaMedioContactoPorId(1);
 * System.out.println("El medio casa===" + casa);
 */