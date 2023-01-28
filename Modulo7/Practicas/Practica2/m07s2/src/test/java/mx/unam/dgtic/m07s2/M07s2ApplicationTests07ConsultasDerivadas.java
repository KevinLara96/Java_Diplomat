package mx.unam.dgtic.m07s2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class M07s2ApplicationTests07ConsultasDerivadas {

    private static final String NOMBRE = "Kevin";
    private static final double ESTATURA = 1.60;
    private static final double ESTATURA2 = 1.70;
    private static final String PATRON = "%A";
    private static final String MATRICULA = "1A";

    @Autowired
    AlumnoRepositorio repositorioAlumno;

    @Test
    void deletePorNombreTest() {
        boolean existeNombre = repositorioAlumno.existsByNombre(NOMBRE);
        System.out.println("Existe nombre: " + NOMBRE);

        if (existeNombre) {
            List<Alumno> alumnos = repositorioAlumno.deleteByNombre(NOMBRE);
            System.out.println("Alumnos eliminados: ");
            alumnos.forEach(System.out::println);
        }
    }

    @Test
    void matriculaLikeTest() {
        List<Alumno> alumnos = repositorioAlumno.findByMatriculaLike(PATRON);
        System.out.println("Alumnos like con matrícula: " + PATRON);
        alumnos.forEach(System.out::println);
    }

    @Test
    void betweenTest() {
        List<Alumno> alumnos = repositorioAlumno.findByEstaturaBetween(ESTATURA,
                ESTATURA2);
        System.out.println("Estatura entre " + ESTATURA + " y " + ESTATURA2);
        alumnos.forEach(System.out::println);

    }

    @Test
    void inTest() {
        List<String> matriculas = Arrays.asList("1A", "1B", "1C");

        List<Alumno> alumnos = repositorioAlumno.findByMatriculaIn(matriculas);
        System.out.println("Matrículas in: ");
        alumnos.forEach(System.out::println);

        alumnos = repositorioAlumno.findByMatriculaNotIn(matriculas);
        System.out.println("Estatura not in: ");
        alumnos.forEach(System.out::println);
    }

    @Test
    void buscarUnoTest() {
        Optional<Alumno> optional = repositorioAlumno.findById("2A");
        System.out.println("Buscar por matrícula.");

        if (optional.isPresent())
            System.out.println(optional.get().toString());
        else
            System.out.println("Matrícula no localizada.");
    }

    @Test
    void deletePorMatriculaTest() {
        boolean existeMatricula = repositorioAlumno.existsByMatricula(MATRICULA);
        System.out.println("Existe matrícula: " + MATRICULA);

        if (existeMatricula) {
            List<Alumno> alumnos = repositorioAlumno.deleteByMatricula(MATRICULA);
            System.out.println("Alumnos eliminados: ");
            alumnos.forEach(System.out::println);
        }
    }

    @Test
    void deletePorEstatura() {
        boolean existeEstatura = repositorioAlumno.existsByEstatura(ESTATURA);
        System.out.println("Existe matrícula: " + MATRICULA);

        if (existeEstatura) {
            List<Alumno> alumnos = repositorioAlumno.deleteByEstatura(ESTATURA);
            System.out.println("Alumnos eliminados: ");
            alumnos.forEach(System.out::println);
        }

    }
}