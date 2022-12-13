package unam.dgtic.diplomado.controlador.servicio.agencia;

import java.util.Iterable;
import java.uitl.Date;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import unam.dgtic.diplomado.modelo.entidades.agencia.Agencia;

public class ServicioAgencia{

	protected EntityManager em;

	public ServicioAgencia(EntityManager em){
		super();
		this.em = em;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Iterable<Agencia> obtenerAgencias(){
		Query query = em.createQuery("SELECT a from Agencia a\n" + 
				"ORDER BY a.idAgencia");

		return (Iterable<Agencia>) query.getResultList();
	}

	@Override
	public Agencia obtenerAgencia(Integer idAgencia){
		return em.find(Agencia.class, idAgencia);
	}

	@Override
	public void guardarAgencia(Agencia agencia) throws Exception{
		em.getTransaction().begin();
		em.persist(agencia);
		em.getTransaction().commit();
	}

	@Override
	public Boolean eliminarAgencia(Integer idAgencia){
		Agencia agencia = obtenerAgencia(idAgencia);
		if(agencia != null){
			em.remove(agencia);
			return true;
		}
	}
}
