package unam.dgtic.diplomado.controlador.servicio.viaje;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.viaje.RepositorioTipoViajeAutobus;
import unam.dgtic.diplomado.modelo.entidades.viaje.TipoViajeAutobusEntity;

public class ServicioTipoViajeAutobus implements RepositorioTipoViajeAutobus {

    protected EntityManager em;

    public ServicioTipoViajeAutobus(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<TipoViajeAutobusEntity> obtenerTiposViajeAutobus() {
        Query query = em.createQuery("SELECT tv from TipoViajeAutobus tv\n" +
                "ORDER BY tv.idTipoViajeAutobus");

        return (Iterable<TipoViajeAutobusEntity>) query.getResultList();
    }

    @Override
    public TipoViajeAutobusEntity obtenerTipoViajeAutobus(Integer idTipoViajeAutobus) {
        return em.find(TipoViajeAutobusEntity.class, idTipoViajeAutobus);
    }

    @Override
    public void guardarTipoViajeAutobus(TipoViajeAutobusEntity viaje) throws Exception {
        em.getTransaction().begin();
        em.persist(viaje);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public void eliminarTipoViajeAutobus(Integer idTipoViajeAutobus) {
        TipoViajeAutobusEntity tipoViajeAutobus = obtenerTipoViajeAutobus(idTipoViajeAutobus);
        if (tipoViajeAutobus != null) {
            em.getTransaction().begin();
            em.remove(tipoViajeAutobus);
            em.flush();
            em.getTransaction().commit();
        }
    }

    @Override
    public void actualizarTipoViajeAutobus(TipoViajeAutobusEntity viajeParam) {
        TipoViajeAutobusEntity tipoViajeAutobus = obtenerTipoViajeAutobus(viajeParam.getIdTipoViajeAutobus());
        if (tipoViajeAutobus != null) {
            em.getTransaction().begin();
            tipoViajeAutobus = em.merge(viajeParam);
            em.getTransaction().commit();
        }

    }
}
