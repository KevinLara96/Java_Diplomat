package unam.dgtic.diplomado.controlador.servicio.viaje;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.viaje.RepositorioTipoViajeAutobus;
import unam.dgtic.diplomado.modelo.beans.viaje.TipoViajeAutobusBean;

public class ServicioTipoViajeAutobus implements RepositorioTipoViajeAutobus {

    protected EntityManager em;

    public ServicioTipoViajeAutobus(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<TipoViajeAutobusBean> obtenerTiposViajeAutobus() {
        Query query = em.createQuery("SELECT tv from TipoViajeAutobus tv\n" +
                "ORDER BY tv.idTipoViajeAutobus");

        return (Iterable<TipoViajeAutobusBean>) query.getResultList();
    }

    @Override
    public TipoViajeAutobusBean obtenerTipoViajeAutobus(Integer idTipoViajeAutobus) {
        return em.find(TipoViajeAutobusBean.class, idTipoViajeAutobus);
    }

    @Override
    public void guardarTipoViajeAutobus(TipoViajeAutobusBean viaje) throws Exception {
        em.getTransaction().begin();
        em.persist(viaje);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public void eliminarTipoViajeAutobus(Integer idTipoViajeAutobus) {
        TipoViajeAutobusBean tipoViajeAutobus = obtenerTipoViajeAutobus(idTipoViajeAutobus);
        if (tipoViajeAutobus != null) {
            em.getTransaction().begin();
            em.remove(tipoViajeAutobus);
            em.flush();
            em.getTransaction().commit();
        }
    }

    @Override
    public void actualizarTipoViajeAutobus(TipoViajeAutobusBean viajeParam) {
        TipoViajeAutobusBean tipoViajeAutobus = obtenerTipoViajeAutobus(viajeParam.getIdTipoViajeAutobus());
        if (tipoViajeAutobus != null) {
            em.getTransaction().begin();
            tipoViajeAutobus = em.merge(viajeParam);
            em.getTransaction().commit();
        }

    }
}
