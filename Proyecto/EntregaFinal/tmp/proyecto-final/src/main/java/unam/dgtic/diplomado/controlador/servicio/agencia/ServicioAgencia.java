package unam.dgtic.diplomado.controlador.servicio.agencia;

//import jakarta.ejb.LocalBean;
//import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.agencia.RepositorioAgencia;
import unam.dgtic.diplomado.modelo.entidades.agencia.AgenciaEntity;

//@Stateless
//@LocalBean
public class ServicioAgencia implements RepositorioAgencia {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyectofinal");
    private EntityManager em;

    public ServicioAgencia() {

    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<AgenciaEntity> obtenerAgencias() {
        em = emf.createEntityManager();

        try {
            Query query = em.createQuery("SELECT a from AgenciaEntity a\n" +
                    "ORDER BY a.idAgencia");
            return (Iterable<AgenciaEntity>) query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public AgenciaEntity obtenerAgencia(Integer idAgencia) {
        em = emf.createEntityManager();

        try {
            return em.find(AgenciaEntity.class, idAgencia);
        } finally {
            em.close();
        }
    }

    @Override
    public boolean guardarAgencia(AgenciaEntity agencia) throws Exception {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(agencia);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            em.close();
        }
        return true;
    }

    @Override
    public boolean eliminarAgencia(Integer idAgencia) throws Exception {
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            AgenciaEntity agencia = em.find(AgenciaEntity.class, idAgencia);
            em.remove(agencia);
            em.flush();
            em.getTransaction().commit();
            if (agencia != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public boolean actualizarAgencia(AgenciaEntity agenciaParam) throws Exception {
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(agenciaParam);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            em.close();
        }

        return true;
    }
}