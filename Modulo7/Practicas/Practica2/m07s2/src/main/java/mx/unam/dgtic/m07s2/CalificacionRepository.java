package mx.unam.dgtic.m07s2;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CalificacionRepository extends CrudRepository<Calificacion, Integer>{

    List<Calificacion> findByMateria(String materia);
    List<Calificacion> findByCalificacion(String materia);


    List<Calificacion> findByAlumnoNombre(String materia);
    List<Calificacion> findByCalificacion(String materia);
    
}
