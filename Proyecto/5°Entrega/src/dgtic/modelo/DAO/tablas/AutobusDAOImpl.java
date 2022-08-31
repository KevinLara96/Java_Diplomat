package dgtic.modelo.DAO.tablas;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import dgtic.modelo.entidades.autobus.Autobus;
import dgtic.modelo.hibernate.HibernateUtil;

public class AutobusDAOImpl implements AutobusDAO {
    private static AutobusDAOImpl instance;

    private AutobusDAOImpl() {
    }

    public static AutobusDAOImpl getInstance() {
        if (instance == null) {
            instance = new AutobusDAOImpl();
        }
        return instance;
    }

    /*
     * @Override
     * public Autobus cargaAutobusPorIdNQ(Integer id) {
     * Autobus autobus = null;
     * try {
     * 
     * Session session = HibernateUtil.getSessionFactory().openSession();
     * 
     * // se inicia una transaccion
     * session.beginTransaction();
     * autobus = (Autobus) session
     * .createNamedQuery("autobusById", Autobus.class)
     * .setParameter("id", id)
     * .getSingleResult();
     * // se realiza el commit
     * session.getTransaction().commit();
     * // se cierra la session hibernate
     * session.close();
     * } catch (Exception e) {
     * e.printStackTrace();
     * StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
     * }
     * return autobus;
     * }
     */

    @Override
    public Autobus cargaAutobusPorId(Integer id) {
        Autobus autobus = null;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            autobus = session.get(Autobus.class, id);
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
        return autobus;
    }

    @Override
    public List<Autobus> cargaAutobuses() {
        List<Autobus> catalogo = null;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            catalogo = session.createQuery("from autobus", Autobus.class).getResultList();
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }

        return catalogo;
    }

    @Override
    public void guardaAutobus(Autobus autobus) {
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            session.save(autobus);
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
    }

    @Override
    public void actualizaAutobus(Autobus autobus) {
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            session.update(autobus);
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
    }

    @Override
    public void eliminaAutobus(Autobus autobus) {
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            session.remove(autobus);
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
    }
}
