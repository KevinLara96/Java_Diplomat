package unam.dgtic.diplomado.controlador.servicio.empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.empleado.RepositorioPuesto;
import unam.dgtic.diplomado.modelo.entidades.empleado.Puesto;

public class ServicioPuesto implements RepositorioPuesto {

    protected EntityManager em;

    public ServicioPuesto(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<Puesto> obtenerPuestos() {
        Query query = em.createQuery("SELECT p from Puesto p\n" +
                "ORDER BY p.idPuesto");

        return (Iterable<Puesto>) query.getResultList();
    }

    @Override
    public Puesto obtenerPuesto(Integer idPuesto) {
        return em.find(Puesto.class, idPuesto);
    }

    @Override
    public void guardarPuesto(Puesto puesto) throws Exception {
        em.getTransaction().begin();
        em.persist(puesto);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public void eliminarPuesto(Integer idPuesto) {
        Puesto puesto = obtenerPuesto(idPuesto);
        if (puesto != null) {
            em.getTransaction().begin();
            em.remove(puesto);
            em.flush();
            em.getTransaction().commit();
        }
    }

    @Override
    public void actualizarPuesto(Puesto puestoParam) {
        Puesto puesto = obtenerPuesto(puestoParam.getIdPuesto());
        if (puesto != null) {
            em.getTransaction().begin();
            puesto = em.merge(puestoParam);
            em.flush();
            em.getTransaction().commit();
        }

    }
}
