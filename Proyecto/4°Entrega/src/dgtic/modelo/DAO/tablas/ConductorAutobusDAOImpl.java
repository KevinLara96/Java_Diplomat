package dgtic.modelo.DAO.tablas;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import dgtic.modelo.entidades.agencia.asignaciones.ConductorAutobus;
import dgtic.modelo.hibernate.HibernateUtil;

public class ConductorAutobusDAOImpl implements ConductorAutobusDAO {

    private static ConductorAutobusDAOImpl instance;

    private ConductorAutobusDAOImpl() {
    }

    public static ConductorAutobusDAOImpl getInstance() {
        if (instance == null) {
            instance = new ConductorAutobusDAOImpl();
        }
        return instance;
    }

    /*
     * @Override
     * public ConductorAutobus cargaConductorAutobusPorIdNQ(Integer id) {
     * ConductorAutobus conductorAutobus = null;
     * try {
     * 
     * Session session = HibernateUtil.getSessionFactory().openSession();
     * 
     * // se inicia una transaccion
     * session.beginTransaction();
     * conductorAutobus = (ConductorAutobus) session
     * .createNamedQuery("conductorAutobusById", ConductorAutobus.class)
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
     * return conductorAutobus;
     * }
     */

    @Override
    public ConductorAutobus cargaConductorAutobusPorId(Integer id) {
        ConductorAutobus conductorAutobus = null;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            conductorAutobus = session.get(ConductorAutobus.class, id);
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
        return conductorAutobus;
    }

    @Override
    public List<ConductorAutobus> cargaAutobusesAsignados() {
        List<ConductorAutobus> catalogo = null;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            catalogo = session.createQuery("from conductorAutobus", ConductorAutobus.class).getResultList();
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
    public void guardaConductorAutobus(ConductorAutobus conductorAutobus) {
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            session.save(conductorAutobus);
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
    public void actualizaConductorAutobus(ConductorAutobus conductorAutobus) {
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            session.update(conductorAutobus);
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
    public void eliminaConductorAutobus(ConductorAutobus conductorAutobus) {
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            session.remove(conductorAutobus);
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
