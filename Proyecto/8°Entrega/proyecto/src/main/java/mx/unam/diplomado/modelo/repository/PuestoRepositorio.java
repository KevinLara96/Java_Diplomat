package mx.unam.diplomado.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.unam.diplomado.modelo.entidades.puesto.Puesto;

@Repository("repositorioPuesto")
public interface PuestoRepositorio extends JpaRepository<Puesto, Integer> {

}
/*
 * public interface PuestoRepositorio {
 * 
 * }
 */
