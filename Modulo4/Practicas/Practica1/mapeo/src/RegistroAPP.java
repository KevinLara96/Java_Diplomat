import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import mx.unam.tic.diplomado.hibernate.Registro;

public class RegistroAPP {

    private SessionFactory sessionFactory;
    private StandardServiceRegistry registry;
    Scanner sn;

    public void cargaMenu() {
        boolean salir = false;
        int opcion; // Guardaremos la opcion del usuario
        sn = new Scanner(System.in);
        do {
            System.out.println("1. Crear registro");
            System.out.println("2. Consultar registro");
            System.out.println("3. Salir");
            try {
                System.out.print("Su opción: ");
                opcion = Integer.parseInt(sn.nextLine());
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
                        System.out.println("Solo n�meros entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un n�mero");
                sn.next();
            }
        } while (!salir);
        sn.close();
    }

    public void creaRegistro() {
        try {
            // se obtiene la session hibernate
            Session session = this.sessionFactory.openSession();

            // se inicia una transaccion
            session = this.sessionFactory.openSession();
            session.beginTransaction();

            // Ingreso de datos.
            Registro registro = new Registro();

            System.out.print("Nombre: ");
            registro.setNombre(sn.nextLine());
            System.out.print("Apellidos: ");
            registro.setApellidos(sn.nextLine());
            System.out.print("Edad: ");
            registro.setEdad(Integer.parseInt(sn.nextLine()));

            // Se guarda el objeto.
            session.save(registro);
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(this.registry);
        }
    }

    public void consultaRegistros() {
        try {
            // se obtiene la session hibernate
            Session session = this.sessionFactory.openSession();

            // se inicia una transaccion
            // session = this.sessionFactory.openSession();
            session.beginTransaction();

            List result = session.createQuery("SELECT R from Registro R").list();
            for (Registro registro : (List<Registro>) result) {
                System.out.println("Datos (" + registro + ")");
            }
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(this.registry);
        }
    }

    public void init() {

        registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml") // se carga la configuracion hibernate
                .build();
        try {
            // se crea una fabrica de sessiones hibernate
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static void main(String[] args) {

        RegistroAPP mapeo = new RegistroAPP();
        mapeo.init();
        mapeo.cargaMenu();

    }

}