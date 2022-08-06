import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;

import mx.unam.tic.diplomado.hibernate.Registro;

public class RegistroAPP {

    private SessionFactory sessionFactory;
    private StandardServiceRegistry registry;

    public static void main(String[] args) {
        RegistroAPP app = new RegistroAPP();
        app.init();

        Registro registro = new Registro();
        registro.setNombre("Kevin Arturo");
        registro.setApellido("Lara Sala");
        registro.setEdad(26);

        Session session = app.getFactory().openSession();
        session.beginTransaction();

        session.save(registro);
        session.getTransaction().commit();
    }

    public SessionFactory getFactory() {
        return this.sessionFactory;
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

}
