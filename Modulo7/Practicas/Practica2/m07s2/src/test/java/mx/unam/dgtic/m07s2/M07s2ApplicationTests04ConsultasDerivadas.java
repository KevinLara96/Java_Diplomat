package mx.unam.dgtic.m07s2;

import java.text.SimpleDateFormat;
import java.util.List;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class M07s2ApplicationTests04ConsultasDerivadas {

    private static final String NOMBRE = "Kevin";
    private static final String PATERNO = "Lara";
    private static final double ESTATURA = 1.71;

    @Autowired
    AlumnoRepositorio repositorioAlumno;

    @Test
    void buscarPorPaternoTest() {
        Iterable<Alumno> iterable = repositorioAlumno.searchByPaterno(PATERNO);
        System.out.println("Buscar por paterno.");
        iterable.forEach(System.out::println);
    }

    @Test
    void buscarPorEstaturaTest() {
        Iterable<Alumno> iterable = repositorioAlumno.streamByEstatura(ESTATURA);
        System.out.println("Buscar por paterno.");
        iterable.forEach(System.out::println);
    }

    @Test
    void buscarFechaTest() {
        List<Alumno> alumnos;
        System.out.println("Buscar por fecha.");

        try {
            alumnos = repositorioAlumno.getByFnac(new SimpleDateFormat("yyyy-mm-dd").parse("2001-03-20"));
            System.out.println(alumnos);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void buscarPorNombreAndPaternoTest() {
        long nalu = repositorioAlumno.countByNombreAndPaterno(NOMBRE, PATERNO);
        System.out.println("Número de alumnos con el nombre y el paterno " + NOMBRE +
                " " + PATERNO + ": " + nalu);

        Iterable<Alumno> iterable = repositorioAlumno.getByNombreAndPaterno(NOMBRE, PATERNO);
        System.out.println("Buscar por nombre y paterno.");
        iterable.forEach(System.out::println);
    }

    @Test
    void buscarPorNombreOrPaternoTest() {
        long nalu = repositorioAlumno.countByNombreAndPaterno(NOMBRE, PATERNO);
        System.out.println("Número de alumnos con el nombre y el paterno " + NOMBRE +
                " " + PATERNO + ": " + nalu);

        Iterable<Alumno> iterable = repositorioAlumno.getByNombreAndPaterno(NOMBRE, PATERNO);
        System.out.println("Buscar por nombre y paterno.");
        iterable.forEach(System.out::println);
    }

    @Test
    void buscaPorNombreAndPaternoOrEstatura() {
        long nalu = repositorioAlumno.countByNombreAndPaternoOrEstatura(NOMBRE, PATERNO, ESTATURA);
        System.out.println("Número de alumnos con el nombre y el paterno o la estatura: " +
                NOMBRE + " " + PATERNO + " " + ESTATURA + ": " + nalu);

        Iterable<Alumno> iterable = repositorioAlumno.readByNombreAndPaternoOrEstatura(NOMBRE, PATERNO, ESTATURA);
        System.out.println("Busca por Nombre y paterno o estatura: ");
        iterable.forEach(System.out::println);
    }
}