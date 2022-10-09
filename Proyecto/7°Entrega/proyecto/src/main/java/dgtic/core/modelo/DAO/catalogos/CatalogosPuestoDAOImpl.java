package dgtic.core.modelo.DAO.catalogos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import dgtic.core.modelo.entidades.puesto.Puesto;
import dgtic.core.modelo.hibernate.HibernateUtil;

public class CatalogosPuestoDAOImpl implements CatalogosPuestoDAO {

    private static CatalogosPuestoDAOImpl instance;

    private CatalogosPuestoDAOImpl() {

    }

    public static CatalogosPuestoDAOImpl getInstance() {
        if (instance == null) {
            instance = new CatalogosPuestoDAOImpl();
        }
        return instance;
    }

    @Override
    public List<Puesto> cargaPuestos() {
        List<Puesto> catalogo = null;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            catalogo = session.createQuery("from puesto", Puesto.class).getResultList();
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
    public Puesto cargaPuestoPorId(Integer id) {
        Puesto puesto = null;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            puesto = session.get(Puesto.class, id);
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
        return puesto;
    }
}