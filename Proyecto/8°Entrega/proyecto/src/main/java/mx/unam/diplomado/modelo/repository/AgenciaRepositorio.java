package mx.unam.diplomado.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.unam.diplomado.modelo.entidades.Agencia;

@Repository("repositorioAgencia")
public interface AgenciaRepositorio extends JpaRepository<Agencia, Integer> {

}

/*
 * public interface AgenciaRepositorio {
 * 
 * }
 */