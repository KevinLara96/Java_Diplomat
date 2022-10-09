package dgtic.core.modelo.DAO.tablas;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import dgtic.core.modelo.entidades.agencia.asignaciones.ConductorViaje;
import dgtic.core.modelo.hibernate.HibernateUtil;

public class ConductorViajeDAOImpl implements ConductorViajeDAO {
    private static ConductorViajeDAOImpl instance;

    private ConductorViajeDAOImpl() {
    }

    public static ConductorViajeDAOImpl getInstance() {
        if (instance == null) {
            instance = new ConductorViajeDAOImpl();
        }
        return instance;
    }

    /*
     * @Override
     * public ConductorViaje cargaConductorViajePorIdNQ(Integer id) {
     * ConductorViaje conductorViaje = null;
     * try {
     * 
     * Session session = HibernateUtil.getSessionFactory().openSession();
     * 
     * // se inicia una transaccion
     * session.beginTransaction();
     * conductorViaje = (ConductorViaje) session
     * .createNamedQuery("conductorViajeById", ConductorViaje.class)
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
     * return conductorViaje;
     * }
     */

    @Override
    public ConductorViaje cargaConductorViajePorId(Integer id) {
        ConductorViaje conductorViaje = null;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            conductorViaje = session.get(ConductorViaje.class, id);
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
        return conductorViaje;
    }

    @Override
    public List<ConductorViaje> cargaConductorViajes() {
        List<ConductorViaje> catalogo = null;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            catalogo = session.createQuery("from conductorViaje", ConductorViaje.class).getResultList();
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
    public void guardaConductorViaje(ConductorViaje conductorViaje) {
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            session.save(conductorViaje);
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
    public void actualizaConductorViaje(ConductorViaje conductorViaje) {
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            session.update(conductorViaje);
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
    public void eliminaConductorViaje(ConductorViaje conductorViaje) {
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            session.remove(conductorViaje);
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
