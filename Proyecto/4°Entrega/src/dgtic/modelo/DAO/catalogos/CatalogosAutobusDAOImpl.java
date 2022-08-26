package dgtic.modelo.DAO.catalogos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import dgtic.modelo.entidades.autobus.ClaseBus;
import dgtic.modelo.entidades.autobus.ClaseTuribus;
import dgtic.modelo.hibernate.HibernateUtil;

public class CatalogosAutobusDAOImpl implements CatalogosAutobusDAO {

    private static CatalogosAutobusDAOImpl instance;

    private CatalogosAutobusDAOImpl() {

    }

    public static CatalogosAutobusDAOImpl getInstance() {
        if (instance == null) {
            instance = new CatalogosAutobusDAOImpl();
        }
        return instance;
    }

    @Override
    public List<ClaseBus> cargaClasesBus() {
        List<ClaseBus> catalogo = null;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            catalogo = session.createQuery("from claseBus", ClaseBus.class).getResultList();
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
    public ClaseBus cargaClasesBusPorId(Integer id) {
        ClaseBus claseBus = null;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            claseBus = session.get(ClaseBus.class, id);
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
    public List<ClaseTuribus> cargaClasesTuribus() {
        List<ClaseTuribus> catalogo = null;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            catalogo = session.createQuery("from claseTuribus", ClaseTuribus.class).getResultList();
            // catalogo = session.createQuery("SELECT c FROM claseTuribus c ;").list();
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
    public ClaseTuribus cargaClasesTuribusPorId(Integer id) {
        ClaseTuribus claseTuribus = null;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            claseTuribus = session.get(ClaseTuribus.class, id);
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
        return claseTuribus;
    }

}
