import java.util.InputMismatchException;
import java.util.Scanner;
import mx.unam.tic.diplomado.agenda.modelo.entidades.TipoContacto;
import mx.unam.tic.diplomado.agenda.modelo.hibernate.HibernateUtil;
import mx.unam.tic.diplomado.agenda.servicios.ServiciosCatalogos;
import mx.unam.tic.diplomado.agenda.servicios.ServiciosCatalogosImpl;

public class CatalogosAPP {

	public static void main(String[] args) {
		
		HibernateUtil.init(); 
		CatalogosAPP catalogosAPP = new CatalogosAPP();
		catalogosAPP.cargaMenu();
	}
	
	
	public void cargaMenu() {
		Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        do{
            System.out.println("1. Agregar un Tipo Contacto");
            System.out.println("2. Consultar registros");
            System.out.println("3. Salir");
            try {
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Inicio de creacion registro...");
                        creaRegistro();
                        break;
                    case 2:
                        System.out.println("Cargando registros...");
                        consultaRegistros();
                        break;
                    case 3:
                    	salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        while (!salir) ;
	}

	public void creaRegistro() {
		ServiciosCatalogos servicioCatalogos = ServiciosCatalogosImpl.getInstance();
		System.out.println("Introduce el valor a guardar");
		Scanner sn = new Scanner(System.in);
		String dato = sn.nextLine();
		if (dato != null && ! dato.isEmpty()) {
			TipoContacto tipoContacto = new TipoContacto();
			tipoContacto.setNombre(dato);
			tipoContacto.setEstatus("ACTIVO");
			if (servicioCatalogos.guardaTipoContacto(tipoContacto)) {
				System.out.println("Nuevo registro Tipo Catalogo...");
			} else {
				System.out.println("No se genero nuevo registro Tipo Catalogo...");
			}
		} else {
			System.out.println("Nada que guardar...");
		}
	}
	
	public void consultaRegistros() {
		ServiciosCatalogos servicioCatalogos = ServiciosCatalogosImpl.getInstance();
		for (TipoContacto tipoContacto : servicioCatalogos.cargaTiposContacto()) {
			System.out.println("Tipo Contacto:" + tipoContacto.getNombre());
		}
	}
}
