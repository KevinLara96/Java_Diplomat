package mx.unam.diplomado.modelo.repository.autobusRepositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.unam.diplomado.modelo.entidades.autobus.Autobus;

@Repository("repositorioAutobus")
public interface AutobusRepositorio extends JpaRepository<Autobus, Integer> {

}

/*
 * public interface AutobusRepositorio{
 * 
 * }
 */