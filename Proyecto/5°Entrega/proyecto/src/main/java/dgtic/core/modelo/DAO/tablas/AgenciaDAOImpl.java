package dgtic.core.modelo.DAO.tablas;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import dgtic.core.modelo.entidades.agencia.Agencia;
import dgtic.core.modelo.hibernate.HibernateUtil;

public class AgenciaDAOImpl implements AgenciaDAO {
    private static AgenciaDAOImpl instance;

    private AgenciaDAOImpl() {
    }

    public static AgenciaDAOImpl getInstance() {
        if (instance == null) {
            instance = new AgenciaDAOImpl();
        }
        return instance;
    }

    /*
     * @Override
     * public Agencia cargaAgenciaPorIdNQ(Integer id) {
     * Agencia agencia = null;
     * try {
     * 
     * Session session = HibernateUtil.getSessionFactory().openSession();
     * 
     * // se inicia una transaccion
     * session.beginTransaction();
     * agencia = (Agencia) session
     * .createNamedQuery("agenciaById", Agencia.class)
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
     * return agencia;
     * }
     */

    @Override
    public Agencia cargaAgencia() {
        Agencia agencia = null;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            agencia = session.get(Agencia.class, 1);
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
        return agencia;
    }

    @Override
    public void guardaAgencia(Agencia agencia) {
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            session.save(agencia);
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
    public void actualizaAgencia(Agencia agencia) {
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            session.update(agencia);
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
    public void eliminaAgencia(Agencia agencia) {
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            session.remove(agencia);
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
