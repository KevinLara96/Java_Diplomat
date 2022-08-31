package dgtic.modelo.DAO.tablas;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import dgtic.modelo.entidades.viaje.Viaje;
import dgtic.modelo.hibernate.HibernateUtil;

public class ViajeDAOImpl implements ViajeDAO {

    private static ViajeDAOImpl instance;

    private ViajeDAOImpl() {
    }

    public static ViajeDAOImpl getInstance() {
        if (instance == null) {
            instance = new ViajeDAOImpl();
        }
        return instance;
    }

    /*
     * @Override
     * public Viaje cargaViajePorIdNQ(Integer id) {
     * Viaje viaje = null;
     * try {
     * 
     * Session session = HibernateUtil.getSessionFactory().openSession();
     * 
     * // se inicia una transaccion
     * session.beginTransaction();
     * viaje = (Viaje) session
     * .createNamedQuery("viajeById", Viaje.class)
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
     * return viaje;
     * }
     */

    @Override
    public Viaje cargaViajePorId(Integer id) {
        Viaje viaje = null;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            viaje = session.get(Viaje.class, id);
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
        return viaje;
    }

    @Override
    public List<Viaje> cargaViajes() {
        List<Viaje> catalogo = null;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            catalogo = session.createQuery("from viaje", Viaje.class).getResultList();
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
    public void guardaViaje(Viaje viaje) {
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            session.save(viaje);
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
    public void actualizaViaje(Viaje viaje) {
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            session.update(viaje);
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
    public void eliminaViaje(Viaje viaje) {
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            session.remove(viaje);
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
