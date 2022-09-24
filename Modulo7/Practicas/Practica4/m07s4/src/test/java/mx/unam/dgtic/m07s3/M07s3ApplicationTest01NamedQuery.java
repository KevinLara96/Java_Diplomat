package mx.unam.dgtic.m07s3;

import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class M07s3ApplicationTest01NamedQuery {

    @Autowired
    AlumnoRepositorio repositorioAlumno;

    @Test
    void buscarAltosTest() {
        Iterable<Alumno> iterable = repositorioAlumno.buscarAltos();
        iterable.forEach(System.out::println);

        try {
            iterable = repositorioAlumno.buscarAltosConFecha(
                    new SimpleDateFormat("yyyy-MM-dd").parse("2001-01-01"));
            iterable.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void buscarPorNombreNamedQueryTest() {
        Iterable<Alumno> iterable = repositorioAlumno.buscarPorNombre("Kevin");
        iterable.forEach(System.out::println);

        iterable = repositorioAlumno.buscarPorNombreYPaterno("Kevin", "Lara");
        iterable.forEach(System.out::println);
    }
}