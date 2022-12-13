package unam.dgtic.diplomado.controlador.servicio.cliente;

import java.util.Iterable;
import java.uitl.Date;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import unam.dgtic.diplomado.modelo.entidades.cliente.Orden;

public class ServicioOrden{

	protected EntityManager em;

	public ServicioOrden(EntityManager em){
		super();
		this.em = em;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Iterable<Orden> obtenerOrdens(){
		Query query = em.createQuery("SELECT c from Orden c\n" + 
				"ORDER BY c.idOrden");

		return (Iterable<Orden>) query.getResultList();
	}

	@Override
	public Orden obtenerOrden(Integer idOrden){
		return em.find(Orden.class, idOrden);
	}

	@Override
	public void guardarOrden(Orden agencia) throws Exception{
		em.getTransaction().begin();
		em.persist(agencia);
		em.getTransaction().commit();
	}

	@Override
	public Boolean eliminarOrden(Integer idOrden){
		Orden orden = obtenerOrden(idOrden);
		if(cliente != null){
			em.remove(cliente);
			return true;
		}
	}
}
