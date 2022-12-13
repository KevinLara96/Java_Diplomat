package unam.dgtic.diplomado.controlador.servicio.empleado;

import java.util.Iterable;
import java.uitl.Date;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import unam.dgtic.diplomado.modelo.entidades.empleado.Empleado;

public class ServicioEmpleado{

	protected EntityManager em;

	public ServicioEmpleado(EntityManager em){
		super();
		this.em = em;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Iterable<Empleado> obtenerEmpleados(){
		Query query = em.createQuery("SELECT a from Empleado a\n" + 
				"ORDER BY a.idEmpleado");

		return (Iterable<Empleado>) query.getResultList();
	}

	@Override
	public Empleado obtenerEmpleado(Integer idEmpleado){
		return em.find(Empleado.class, idEmpleado);
	}

	@Override
	public void guardarEmpleado(Empleado agencia) throws Exception{
		em.getTransaction().begin();
		em.persist(agencia);
		em.getTransaction().commit();
	}

	@Override
	public Boolean eliminarEmpleado(Integer idEmpleado){
		Empleado agencia = obtenerEmpleado(idEmpleado);
		if(agencia != null){
			em.remove(agencia);
			return true;
		}
	}
}
