package unam.dgtic.diplomado.controlador.servicio.cliente;

import java.util.Iterable;
import java.uitl.Date;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import unam.dgtic.diplomado.modelo.entidades.cliente.Cliente;

public class ServicioCliente{

	protected EntityManager em;

	public ServicioCliente(EntityManager em){
		super();
		this.em = em;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Iterable<Cliente> obtenerClientes(){
		Query query = em.createQuery("SELECT c from Cliente c\n" + 
				"ORDER BY c.idCliente");

		return (Iterable<Cliente>) query.getResultList();
	}

	@Override
	public Cliente obtenerCliente(Integer idCliente){
		return em.find(Cliente.class, idCliente);
	}

	@Override
	public void guardarCliente(Cliente agencia) throws Exception{
		em.getTransaction().begin();
		em.persist(agencia);
		em.getTransaction().commit();
	}

	@Override
	public Boolean eliminarCliente(Integer idCliente){
		Cliente cliente = obtenerCliente(idCliente);
		if(cliente != null){
			em.remove(cliente);
			return true;
		}
	}
}
