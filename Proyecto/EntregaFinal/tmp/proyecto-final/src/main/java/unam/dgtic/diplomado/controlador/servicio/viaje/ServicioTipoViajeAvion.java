package unam.dgtic.diplomado.controlador.servicio.viaje;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.viaje.RepositorioTipoViajeAvion;
import unam.dgtic.diplomado.modelo.entidades.viaje.TipoViajeAvionEntity;

public class ServicioTipoViajeAvion implements RepositorioTipoViajeAvion {

    protected EntityManager em;

    public ServicioTipoViajeAvion(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<TipoViajeAvionEntity> obtenerTiposViajeAvion() {
        Query query = em.createQuery("SELECT tv from TipoViajeAvion tv\n" +
                "ORDER BY tv.idTipoViajeAvion");

        return (Iterable<TipoViajeAvionEntity>) query.getResultList();
    }

    @Override
    public TipoViajeAvionEntity obtenerTipoViajeAvion(Integer idTipoViajeAvion) {
        return em.find(TipoViajeAvionEntity.class, idTipoViajeAvion);
    }

    @Override
    public void guardarTipoViajeAvion(TipoViajeAvionEntity tipoViajeAvion) throws Exception {
        em.getTransaction().begin();
        em.persist(tipoViajeAvion);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public void eliminarTipoViajeAvion(Integer idTipoViajeAvion) {
        TipoViajeAvionEntity tipoViajeAvion = obtenerTipoViajeAvion(idTipoViajeAvion);
        if (tipoViajeAvion != null) {
            em.getTransaction().begin();
            em.remove(tipoViajeAvion);
            em.flush();
            em.getTransaction().commit();
        }
    }

    @Override
    public void actualizarTipoViajeAvion(TipoViajeAvionEntity tipoViajeAvionParam) {
        TipoViajeAvionEntity tipoViajeAvion = obtenerTipoViajeAvion(tipoViajeAvionParam.getIdTipoViajeAvion());
        if (tipoViajeAvion != null) {
            em.getTransaction().begin();
            tipoViajeAvion = em.merge(tipoViajeAvion);
            em.getTransaction().commit();
        }

    }
}
