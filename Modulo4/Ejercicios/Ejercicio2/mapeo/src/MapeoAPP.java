import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.InputMismatchException;
import java.util.Scanner;
import mx.unam.tic.diplomado.hibernate.Tabla;

public class MapeoAPP {

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
        System.out.println("Introduce el valor a guardar");
        sn = new Scanner(System.in);
        String dato = sn.nextLine();
        try {

            Session session = this.sessionFactory.openSession();
            // se obtiene la session hibernate
            session = this.sessionFactory.openSession();
            // se inicia una transaccion
            session.beginTransaction();
            Tabla tabla = new Tabla();
            tabla.setTexto(dato);
            session.save(tabla);
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

            Session session = this.sessionFactory.openSession();
            // se obtiene la session hibernate
            // session = this.sessionFactory.openSession();
            // se inicia una transaccion
            session.beginTransaction();
            List result = session.createQuery("from Tabla").list();
            for (Tabla tabla : (List<Tabla>) result) {
                System.out.println("Datos (" + tabla.getTexto() + ")");
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

        MapeoAPP mapeo = new MapeoAPP();
        mapeo.init();
        mapeo.cargaMenu();

    }

}
