package unam.dgtic.diplomado.m1100base.modelo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.m1100base.dominio.viaje.TipoViaje;
import unam.dgtic.diplomado.m1100base.dominio.viaje.Viaje;

public class ViajeService {

    protected EntityManager em;

    @Autowired
    private AgenciaService agenciaService;

    public ViajeService(EntityManager em) {
        this.em = em;
    }

    public Viaje findViaje(Integer idViaje) {
        return em.find(Viaje.class, idViaje);
    }

    @SuppressWarnings("unchecked")
    public Collection<Viaje> findAllViajes() {
        Query query = em.createQuery("SELECT v FROM Viaje v");

        return (Collection<Viaje>) query.getResultList();
    }

    public Viaje createViajeNew(Integer idViaje, String origen, String destino, Float precio,
            String fecha, Integer idAgencia, String tipoViajeStr) {
        TipoViaje tipoViaje = new TipoViaje();
        tipoViaje.setTipoViaje(tipoViajeStr);

        Viaje viaje = new Viaje();
        viaje.setIdViaje(idViaje);
        viaje.setOrigen(origen);
        viaje.setDestino(destino);
        viaje.setPrecio(precio);
        viaje.setFecha(fecha);
        viaje.setAgencia(agenciaService.findAgencia(idAgencia));
        viaje.setTipoViaje(tipoViaje);

        em.getTransaction().begin();
        em.persist(viaje);
        em.getTransaction().commit();

        return viaje;
    }

    public Viaje createViaje(Viaje viajeNuevo) {
        em.getTransaction().begin();
        em.persist(viajeNuevo);
        em.getTransaction().commit();

        return viajeNuevo;
    }

    public void removeViaje(Integer idViaje) {
        Viaje viaje = findViaje(idViaje);
        if (viaje != null) {
            em.getTransaction().begin();
            em.remove(viaje);
            em.getTransaction().commit();
        }
    }

    public Viaje cambiarPrecioViaje(Integer idViaje, Float precioNuevo) {
        Viaje viaje = findViaje(idViaje);
        if (viaje != null) {
            em.getTransaction().begin();
            viaje.setPrecio(precioNuevo);
            em.getTransaction().commit();
        }
        return viaje;
    }
}