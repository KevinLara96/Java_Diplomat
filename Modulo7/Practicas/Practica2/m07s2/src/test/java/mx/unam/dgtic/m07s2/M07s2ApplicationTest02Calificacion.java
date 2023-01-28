package mx.unam.dgtic.m07s2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class M07s2ApplicationTest02Calificacion {

    @Autowired
    CalificacionRepository repositorioCalificacion;

    @Test
    void buscarTodosCalificacionTest() {
        Iterable<Calificacion> iterable = repositorioCalificacion.findAll();
        iterable.forEach(System.out::println);
    }

    @Test
    void buscarCalificacionPorAlumnoNombreTest() {
        Iterable<Calificacion> iterable = repositorioCalificacion.findByAlumnoNombre("Kevin");
        iterable.forEach(System.out::println);
    }
}
