package unam.dgtic.diplomado.controlador.servicio.empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.empleado.RepositorioPuesto;
import unam.dgtic.diplomado.modelo.entidades.empleado.PuestoEntity;

public class ServicioPuesto implements RepositorioPuesto {

    protected EntityManager em;

    public ServicioPuesto(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<PuestoEntity> obtenerPuestos() {
        Query query = em.createQuery("SELECT p from Puesto p\n" +
                "ORDER BY p.idPuesto");

        return (Iterable<PuestoEntity>) query.getResultList();
    }

    @Override
    public PuestoEntity obtenerPuesto(Integer idPuesto) {
        return em.find(PuestoEntity.class, idPuesto);
    }

    @Override
    public void guardarPuesto(PuestoEntity puesto) throws Exception {
        em.getTransaction().begin();
        em.persist(puesto);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public void eliminarPuesto(Integer idPuesto) {
        PuestoEntity puesto = obtenerPuesto(idPuesto);
        if (puesto != null) {
            em.getTransaction().begin();
            em.remove(puesto);
            em.flush();
            em.getTransaction().commit();
        }
    }

    @Override
    public void actualizarPuesto(PuestoEntity puestoParam) {
        PuestoEntity puesto = obtenerPuesto(puestoParam.getIdPuesto());
        if (puesto != null) {
            em.getTransaction().begin();
            puesto = em.merge(puestoParam);
            em.flush();
            em.getTransaction().commit();
        }

    }
}
