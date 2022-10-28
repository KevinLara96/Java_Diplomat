package mx.unam.diplomado.modelo.repository.empleadoRepositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.unam.diplomado.modelo.entidades.empleado.Empleado;

@Repository("repositorioEmpleado")
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {

}

/*
 * public interface EmpleadoRepositorio {
 * 
 * }
 */
