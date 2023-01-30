package mx.unam.dgtic.m07s2;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Arrays;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class M07s2ApplicationTests06ConsultasDerivadas {

    private static final String NOMBRE = "Kevin";
    // private static final String PATERNO = "Lara";
    private static final double ESTATURA = 1.71;
    private static final double ESTATURA2 = 1.80;
    private static final String PATRON = "a";

    @Autowired
    AlumnoRepositorio repositorioAlumno;

    @Test
    void distinctTest() {
        List<Alumno> alumnos = repositorioAlumno.findAlumnoDistinctByNombre(NOMBRE);
        System.out.println("Distinct por nombre" + NOMBRE);
        alumnos.forEach(System.out::println);
    }

    @Test
    void patronesTest() {
        List<Alumno> alumnos = repositorioAlumno.findByPaternoStartingWith(PATRON);
        System.out.println("Paterno inicia con: " + PATRON);
        alumnos.forEach(System.out::println);

        alumnos = repositorioAlumno.findByPaternoEndingWith(PATRON);
        System.out.println("Paterno termina con: " + PATRON);
        alumnos.forEach(System.out::println);

        alumnos = repositorioAlumno.findByPaternoContaining(PATRON);
        System.out.println("Paterno contiene con: " + PATRON);
        alumnos.forEach(System.out::println);
    }

    @Test
    void likeTest() {
        List<Alumno> alumnos = repositorioAlumno.findByPaternoLike(PATRON);
        System.out.println("Paterno like con: " + PATRON);
        alumnos.forEach(System.out::println);

        alumnos = repositorioAlumno.findByPaternoLike(PATRON + "%");
        System.out.println("Paterno like con: " + PATRON + "%");
        alumnos.forEach(System.out::println);

        alumnos = repositorioAlumno.findByPaternoLike("_" + PATRON + "%");
        System.out.println("Paterno like con: " + PATRON + "%");
        alumnos.forEach(System.out::println);

        alumnos = repositorioAlumno.findByPaternoLike("______");
        System.out.println("Paterno like con: ______");
        alumnos.forEach(System.out::println);

        alumnos = repositorioAlumno.findByPaternoNotLike("______");
        System.out.println("Paterno not  like con: ______");
        alumnos.forEach(System.out::println);

    }

    @Test
    void comparacionTest() {
        List<Alumno> alumnos = repositorioAlumno.findByEstaturaLessThan(ESTATURA);
        System.out.println("Estatura menor que: " + ESTATURA);
        alumnos.forEach(System.out::println);

        alumnos = repositorioAlumno.findByEstaturaLessThanEqual(ESTATURA);
        System.out.println("Estatura menor o igual que: " + ESTATURA);
        alumnos.forEach(System.out::println);

        alumnos = repositorioAlumno.findByEstaturaGreaterThan(ESTATURA);
        System.out.println("Estatura mayor que: " + ESTATURA);
        alumnos.forEach(System.out::println);

        alumnos = repositorioAlumno.findByEstaturaGreaterThanEqual(ESTATURA);
        System.out.println("Estatura mayor o igual que: " + ESTATURA);
        alumnos.forEach(System.out::println);
    }

    @Test
    void comparacionLikeTest() {
        List<Alumno> alumnos = repositorioAlumno.findByEstaturaGreaterThanAndPaternoLike(ESTATURA, "%" + PATRON + "%");
        System.out.println("Estatura mayor que " + ESTATURA + " y like " + "%" + PATRON + "%");
        alumnos.forEach(System.out::println);

    }

    @Test
    void betweenTest() {
        List<Alumno> alumnos = repositorioAlumno.findByEstaturaBetween(ESTATURA, ESTATURA2);
        System.out.println("Estatura entre " + ESTATURA + " y " + ESTATURA2);
        alumnos.forEach(System.out::println);

    }

    @Test
    void inTest() {
        List<Double> estaturas = Arrays.asList(ESTATURA, ESTATURA2, 1.75);

        List<Alumno> alumnos = repositorioAlumno.findByEstaturaIn(estaturas);
        System.out.println("Estatura in: ");
        alumnos.forEach(System.out::println);

        alumnos = repositorioAlumno.findByEstaturaNotIn(estaturas);
        System.out.println("Estatura not in: ");
        alumnos.forEach(System.out::println);
    }

    @Test
    void inNombreTest() {
        List<String> nombres = Arrays.asList("Marco", "Perla", "Nadia");

        List<Alumno> alumnos = repositorioAlumno.findByNombreIn(nombres);
        System.out.println("Nombre in: ");
        alumnos.forEach(System.out::println);

        alumnos = repositorioAlumno.findByNombreNotIn(nombres);
        System.out.println("Nombre in: ");
        alumnos.forEach(System.out::println);
    }

    @Test
    void buscarFechasTest() {
        List<Alumno> alumnos;
        try {
            alumnos = repositorioAlumno.findByFnacBefore(
                    new SimpleDateFormat("yyyy-MM-dd").parse("2001-02-10"));
            System.out.println("Fecha before 2001-02-10");
            alumnos.forEach(System.out::println);

            alumnos = repositorioAlumno.findByFnacAfter(
                    new SimpleDateFormat("yyyy-MM-dd").parse("2001-02-10"));
            System.out.println("Fecha after 2001-02-10");
            alumnos.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}