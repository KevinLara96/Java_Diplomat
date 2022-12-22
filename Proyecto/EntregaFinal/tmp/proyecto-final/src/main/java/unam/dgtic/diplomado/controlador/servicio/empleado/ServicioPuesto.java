package unam.dgtic.diplomado.controlador.servicio.empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.empleado.RepositorioPuesto;
import unam.dgtic.diplomado.modelo.entidades.empleado.PuestoEntity;

public class ServicioPuesto implements RepositorioPuesto {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyectofinal");
    private EntityManager em;

    public ServicioPuesto() {
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<PuestoEntity> obtenerPuestos() {
        em = emf.createEntityManager();

        try {
            Query query = em.createQuery("SELECT p from Puesto p\n" +
                    "ORDER BY p.idPuesto");

            return (Iterable<PuestoEntity>) query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public PuestoEntity obtenerPuesto(Integer idPuesto) {
        em = emf.createEntityManager();

        try {
            return em.find(PuestoEntity.class, idPuesto);
        } finally {
            em.close();
        }
    }

    @Override
    public void guardarPuesto(PuestoEntity puesto) throws Exception {
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(puesto);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminarPuesto(Integer idPuesto) {
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            PuestoEntity puesto = em.find(PuestoEntity.class, idPuesto);
            em.remove(puesto);
            em.flush();
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizarPuesto(PuestoEntity puestoParam) {
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(puestoParam);
            em.flush();
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }

    }
}
