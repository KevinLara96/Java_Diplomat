package mx.unam.diplomado.modelo.repository.viajeRepositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.unam.diplomado.modelo.entidades.viaje.Viaje;

@Repository("repositorioViaje")
public interface ViajeRepositorio extends JpaRepository<Viaje, Integer> {

}
/*
 * public interface ViajeRepositorio {
 * 
 * }
 */
