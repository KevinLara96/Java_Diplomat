package dgtic.basedatos.servicio.escritura;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

//import dgtic.modelo.autobus.Autobus;
import dgtic.modelo.empleado.administrador.Administrador;
import dgtic.modelo.empleado.conductor.Conductor;
//import dgtic.modelo.viaje.Viaje;
import dgtic.basedatos.servicio.HibernateUtil;

public class Escritura {

    /*
     * Registra nuevo administrador en la base de datos.
     */
    public static boolean altaAdministrador(Administrador administrador) {
        Boolean guardado = Boolean.FALSE;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            session.save(administrador);
            guardado = administrador.getClaveAdministrador() != null ? Boolean.TRUE : Boolean.FALSE;
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
        return guardado;
    }

    /*
     * Registra nuevo conductor en la base de datos.
     */
    public static boolean altaConductor(Conductor conductor) {
        Boolean guardado = Boolean.FALSE;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            session.save(conductor);
            guardado = conductor.getClaveConductor() != null ? Boolean.TRUE : Boolean.FALSE;
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
        return guardado;

    }

    /*
     * Actualiza Administrador en la base de datos.
     */
    public static boolean actualizaAdministrador(Administrador administrador) {
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            session.update(administrador);
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
            return false;
        }
    }

    /*
     * Actualiza Conductor en la base de datos.
     */
    public static boolean actualizaConductor(Conductor conductor) {
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            session.update(conductor);
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
            return false;
        }
    }

}