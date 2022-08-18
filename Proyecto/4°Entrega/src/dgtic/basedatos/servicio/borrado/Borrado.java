package dgtic.basedatos.servicio.borrado;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import dgtic.basedatos.servicio.HibernateUtil;
import dgtic.modelo.empleado.administrador.Administrador;
import dgtic.modelo.empleado.conductor.Conductor;

public class Borrado {

    /*
     * Elimina administrador de la base de datos.
     */
    public static boolean bajaAdministrador(Administrador administrador) {
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            session.remove(administrador);
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
     * Elimina conductor de la base de datos.
     */
    public static boolean bajaConductor(Conductor conductor) {
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            session.remove(conductor);
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