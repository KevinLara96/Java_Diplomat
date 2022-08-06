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

    public static void main(String[] args) {

        HibernateUtil.init();
        ServiciosCatalogos serviciosCatalogos = ServiciosCatalogosImpl.getInstance();
        ServiciosContactos serviciosContactos = ServiciosContactosImpl.getInstance();

        List<TipoContacto> tiposContacto = serviciosCatalogos.cargaTiposContacto();
        for (TipoContacto tipoContacto : tiposContacto) {
            System.out.println("El tipo contacto es:" + tipoContacto.getNombre());
        }

        TipoContacto familiar = serviciosCatalogos.cargaTipoContactoPorId(1);
        System.out.println("El contacto familiar===" + familiar);

        List<MedioContacto> mediosContacto = serviciosCatalogos.cargaMediosContacto();

        for (MedioContacto medioContacto : mediosContacto) {
            System.out.println("El medio contacto es:" + medioContacto.getNombre());
        }

        MedioContacto casa = serviciosCatalogos.cargaMedioContactoPorId(1);
        System.out.println("El medio casa===" + casa);
        Contacto papa = new Contacto();

        /* Ingreso de datos. */
        boolean bandera = false;
        Scanner input = new Scanner(System.in);
        do {
            try {
                System.out.print("\nIngrese nombre: ");
                papa.setNombre(input.nextLine());
                System.out.print("\nIngrese apellidos: ");
                papa.setApellidos(input.nextLine());
                System.out.print("\nIngrese direccion: ");
                papa.setDireccion(input.nextLine());
                System.out.print("\nIngrese edad: ");
                papa.setEdad(Integer.parseInt(input.nextLine()));

                bandera = true;
            } catch (Exception e) {
                System.out.println("Datos inválidos, ingrese de nuevo sus datos.");
            }
        } while (!bandera);
        familiar = serviciosCatalogos.cargaTipoContactoPorId(1);
        papa.setTipoContacto(familiar);

        ContactoMedio contactoMedio = new ContactoMedio();
        bandera = false;
        do {
            try {
                System.out.print("\nIngrese su número: ");
                contactoMedio.setValor(input.nextLine());
                System.out.print("\nIngrese su forma de contacto: " +
                        "\n1. Teléfono casa." +
                        "\n2. Teléfono trabajo." +
                        "\n3. Teléfono celular.");
                MedioContacto trabajo = serviciosCatalogos.cargaMedioContactoPorId(Integer.parseInt(input.nextLine()));
                contactoMedio.setMedioContacto(trabajo);

                /*
                 * System.out.print("\nIngrese su contacto: " +
                 * "\n1. Familiar." +
                 * "\n2. Escolar." +
                 * "\n3. Laboral.");
                 */
                contactoMedio.setContacto(papa);
                bandera = true;
            } catch (Exception e) {
                System.out.println("Datos inválidos, ingrese de nuevo sus datos.");
            }
        } while (!bandera);

        Set<ContactoMedio> contactosMedios = new HashSet<ContactoMedio>();
        contactosMedios.add(contactoMedio);
        papa.setContactosMedios(contactosMedios);

        serviciosContactos.guardaContacto(papa);
        List<Contacto> contactos = serviciosContactos.cargaContactos();
        for (Contacto contacto : contactos) {
            System.out.println("El contacto es:" + contacto.getNombre());
            System.out.println("El tipo contacto es:" + contacto.getTipoContacto().getNombre());
        }

        input.close();
    }

}
