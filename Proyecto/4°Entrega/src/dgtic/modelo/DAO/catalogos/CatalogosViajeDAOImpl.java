package dgtic.modelo.DAO.catalogos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import dgtic.modelo.entidades.viaje.*;
import dgtic.modelo.hibernate.HibernateUtil;

public class CatalogosViajeDAOImpl implements CatalogosViajeDAO {

    private static CatalogosViajeDAOImpl instance;

    private CatalogosViajeDAOImpl() {

    }

    public static CatalogosViajeDAOImpl getInstance() {
        if (instance == null) {
            instance = new CatalogosViajeDAOImpl();
        }
        return instance;
    }

    @Override
    public List<TipoViaje> cargaTipoViaje() {
        List<TipoViaje> catalogo = null;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            catalogo = session.createQuery("from tipoViaje", TipoViaje.class).getResultList();
            // catalogo = session.createQuery("SELECT c FROM claseBus c;").list();
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
    public TipoViaje cargaTipoViajePorId(Integer id) {
        TipoViaje claseBus = null;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            claseBus = session.get(TipoViaje.class, id);
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
        return claseBus;
    }

    @Override
    public List<TipoTour> cargaTipoTour() {
        List<TipoTour> catalogo = null;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            catalogo = session.createQuery("from tipoTour", TipoTour.class).getResultList();
            // catalogo = session.createQuery("SELECT c FROM claseBus c;").list();
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
    public TipoTour cargaTipoTourPorId(Integer id) {
        TipoTour claseBus = null;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            claseBus = session.get(TipoTour.class, id);
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
        return claseBus;
    }
}
