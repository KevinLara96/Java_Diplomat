package dgtic.core.modelo.DAO.tablas;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import dgtic.core.modelo.entidades.empleado.Empleado;
import dgtic.core.modelo.hibernate.HibernateUtil;

public class EmpleadoDAOImpl implements EmpleadoDAO {
    private static EmpleadoDAOImpl instance;

    private EmpleadoDAOImpl() {
    }

    public static EmpleadoDAOImpl getInstance() {
        if (instance == null) {
            instance = new EmpleadoDAOImpl();
        }
        return instance;
    }

    /*
     * @Override
     * public Empleado cargaEmpleadoPorIdNQ(Integer id) {
     * Empleado empleado = null;
     * try {
     * 
     * Session session = HibernateUtil.getSessionFactory().openSession();
     * 
     * // se inicia una transaccion
     * session.beginTransaction();
     * empleado = (Empleado) session
     * .createNamedQuery("empleadoById", Empleado.class)
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
     * return empleado;
     * }
     */

    @Override
    public Empleado cargaEmpleadoPorId(Integer id) {
        Empleado empleado = null;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            empleado = session.get(Empleado.class, id);
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
        return empleado;
    }

    @Override
    public List<Empleado> cargaEmpleados() {
        List<Empleado> catalogo = null;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            catalogo = session.createQuery("from Empleado", Empleado.class).getResultList();
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
    public void guardaEmpleado(Empleado empleado) {
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            session.save(empleado);
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
    public void actualizaEmpleado(Empleado empleado) {
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            session.update(empleado);
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
    public void eliminaEmpleado(Empleado empleado) {
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();

            // se inicia una transaccion
            session.beginTransaction();
            session.remove(empleado);
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
