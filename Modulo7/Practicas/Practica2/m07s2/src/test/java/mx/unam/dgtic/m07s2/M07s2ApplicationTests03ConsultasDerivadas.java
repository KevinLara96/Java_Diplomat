package mx.unam.dgtic.m07s2;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class M07s2ApplicationTests03ConsultasDerivadas {

    private static String NOMBRE = "Kevin";

    @Autowired
    AlumnoRepositorio repositorioAlumno;

    @Test
    void buscarPorNombreTest() {

        long nalu = repositorioAlumno.countByNombre(NOMBRE);
        System.out.println("Número de alumnos con el nombre " + NOMBRE + " " + nalu);
        Iterable<Alumno> iterable = repositorioAlumno.getByNombre(NOMBRE);

        System.out.println("Buscar por nombre.");
        iterable.forEach(System.out::println);
    }

    @Test
    void buscarPorNombreNotTest() {
        long nalu = repositorioAlumno.countByNombreNot(NOMBRE);
        System.out.println("Número de alumnos con el nombre " + NOMBRE + ": " + nalu);

        Iterable<Alumno> iterable = repositorioAlumno.getByNombreNot(NOMBRE);
        System.err.println("Buscar por nombre: ");
        iterable.forEach(System.out::println);
    }
}