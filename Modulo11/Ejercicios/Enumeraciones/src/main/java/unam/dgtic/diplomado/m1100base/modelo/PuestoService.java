package unam.dgtic.diplomado.m1100base.modelo;

import java.util.Collection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.m1100base.dominio.puesto.Puesto;

public class PuestoService {

    protected EntityManager em;

    public PuestoService(EntityManager em) {
        this.em = em;
    }

    public Puesto findPuesto(Integer idPuesto) {
        return em.find(Puesto.class, idPuesto);
    }

    @SuppressWarnings("unchecked")
    public Collection<Puesto> findAllPuestos() {
        Query query = em.createQuery("SELECT p FROM Puesto p");

        return (Collection<Puesto>) query.getResultList();
    }

    public Puesto createPuesto(Integer idPuesto, String nombrePuesto, Integer idEmpleado) {
        Puesto puesto = new Puesto();
        puesto.setIdPuesto(idPuesto);
        puesto.setPuesto(nombrePuesto);

        em.getTransaction().begin();
        em.persist(puesto);
        em.getTransaction().commit();

        return puesto;
    }

    public void removePuesto(Integer idpuesto) {
        Puesto puesto = findPuesto(idpuesto);
        if (puesto != null) {
            em.getTransaction().begin();
            em.remove(puesto);
            em.getTransaction().commit();
        }
    }

    public Puesto cambiarNombrePuesto(Integer idPuesto, String nuevoNombrePuesto) {
        Puesto puesto = findPuesto(idPuesto);
        if (puesto != null) {
            em.getTransaction().begin();
            puesto.setPuesto(nuevoNombrePuesto);
            em.getTransaction().commit();
        }
        return puesto;
    }

}
