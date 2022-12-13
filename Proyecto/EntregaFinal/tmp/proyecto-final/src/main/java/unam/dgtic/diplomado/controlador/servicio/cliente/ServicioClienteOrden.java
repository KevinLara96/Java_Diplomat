package unam.dgtic.diplomado.controlador.servicio.cliente;

import java.util.Iterable;
import java.uitl.Date;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import unam.dgtic.diplomado.modelo.entidades.cliente.ClienteOrden;

public class ServicioClienteOrden{

	protected EntityManager em;

	public ServicioClienteOrden(EntityManager em){
		super();
		this.em = em;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Iterable<ClienteOrden> obtenerClientesOrdenes(){
		Query query = em.createQuery("SELECT c from ClienteOrden c\n" + 
				"ORDER BY c.idClienteOrden");

		return (Iterable<ClienteOrden>) query.getResultList();
	}

	@Override
	public ClienteOrden obtenerClienteOrden(Integer idClienteOrden){
		return em.find(ClienteOrden.class, idClienteOrden);
	}

	@Override
	public void guardarClienteOrden(ClienteOrden agencia) throws Exception{
		em.getTransaction().begin();
		em.persist(agencia);
		em.getTransaction().commit();
	}

	@Override
	public Boolean eliminarClienteOrden(Integer idClienteOrden){
		ClienteOrden cliente = obtenerClienteOrden(idClienteOrden);
		if(cliente != null){
			em.remove(cliente);
			return true;
		}
	}
}
