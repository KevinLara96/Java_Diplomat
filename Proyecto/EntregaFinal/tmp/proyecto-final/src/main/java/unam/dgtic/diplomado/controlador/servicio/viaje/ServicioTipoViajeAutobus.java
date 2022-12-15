package unam.dgtic.diplomado.controlador.servicio.viaje;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.viaje.RepositorioTipoViajeAutobus;
import unam.dgtic.diplomado.modelo.entidades.viaje.TipoViajeAutobus;

public class ServicioTipoViajeAutobus implements RepositorioTipoViajeAutobus {

    protected EntityManager em;

    public ServicioTipoViajeAutobus(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<TipoViajeAutobus> obtenerTiposViajeAutobus() {
        Query query = em.createQuery("SELECT tv from TipoViajeAutobus tv\n" +
                "ORDER BY tv.idTipoViajeAutobus");

        return (Iterable<TipoViajeAutobus>) query.getResultList();
    }

    @Override
    public TipoViajeAutobus obtenerTipoViajeAutobus(Integer idTipoViajeAutobus) {
        return em.find(TipoViajeAutobus.class, idTipoViajeAutobus);
    }

    @Override
    public void guardarTipoViajeAutobus(TipoViajeAutobus viaje) throws Exception {
        em.getTransaction().begin();
        em.persist(viaje);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public void eliminarTipoViajeAutobus(Integer idTipoViajeAutobus) {
        TipoViajeAutobus tipoViajeAutobus = obtenerTipoViajeAutobus(idTipoViajeAutobus);
        if (tipoViajeAutobus != null) {
            em.getTransaction().begin();
            em.remove(tipoViajeAutobus);
            em.flush();
            em.getTransaction().commit();
        }
    }

    @Override
    public void actualizarTipoViajeAutobus(TipoViajeAutobus viajeParam) {
        TipoViajeAutobus tipoViajeAutobus = obtenerTipoViajeAutobus(viajeParam.getIdTipoViajeAutobus());
        if (tipoViajeAutobus != null) {
            em.getTransaction().begin();
            tipoViajeAutobus = em.merge(viajeParam);
            em.getTransaction().commit();
        }

    }
}
