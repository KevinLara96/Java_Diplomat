package unam.dgtic.diplomado.controlador.servicio.empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.empleado.RepositorioPuesto;
import unam.dgtic.diplomado.modelo.beans.empleado.PuestoBean;

public class ServicioPuesto implements RepositorioPuesto {

    protected EntityManager em;

    public ServicioPuesto(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<PuestoBean> obtenerPuestos() {
        Query query = em.createQuery("SELECT p from Puesto p\n" +
                "ORDER BY p.idPuesto");

        return (Iterable<PuestoBean>) query.getResultList();
    }

    @Override
    public PuestoBean obtenerPuesto(Integer idPuesto) {
        return em.find(PuestoBean.class, idPuesto);
    }

    @Override
    public void guardarPuesto(PuestoBean puesto) throws Exception {
        em.getTransaction().begin();
        em.persist(puesto);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public void eliminarPuesto(Integer idPuesto) {
        PuestoBean puesto = obtenerPuesto(idPuesto);
        if (puesto != null) {
            em.getTransaction().begin();
            em.remove(puesto);
            em.flush();
            em.getTransaction().commit();
        }
    }

    @Override
    public void actualizarPuesto(PuestoBean puestoParam) {
        PuestoBean puesto = obtenerPuesto(puestoParam.getIdPuesto());
        if (puesto != null) {
            em.getTransaction().begin();
            puesto = em.merge(puestoParam);
            em.flush();
            em.getTransaction().commit();
        }

    }
}
