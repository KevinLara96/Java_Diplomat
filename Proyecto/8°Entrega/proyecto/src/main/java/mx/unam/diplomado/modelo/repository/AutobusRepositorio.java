package mx.unam.diplomado.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.unam.diplomado.modelo.entidades.Autobus;

@Repository("repositorioAutobus")
public interface AutobusRepositorio extends JpaRepository<Autobus, Integer> {

}

/*
 * public interface AutobusRepositorio{
 * 
 * }
 */