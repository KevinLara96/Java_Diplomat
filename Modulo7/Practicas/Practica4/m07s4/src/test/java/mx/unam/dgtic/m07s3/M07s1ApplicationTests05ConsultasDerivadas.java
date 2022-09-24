package mx.unam.dgtic.m07s3;

import java.util.List;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class M07s1ApplicationTests05ConsultasDerivadas {

    private static final String NOMBRE = "Kevin";
    private static final String PATERNO = "Lara";
    private static final double ESTATURA = 1.71;

    @Autowired
    AlumnoRepositorio repositorioAlumno;

    @Test
    void distinctTest() {
        List<Alumno> alumnos = repositorioAlumno.findAlumnoDistinctByNombre(NOMBRE);
        System.out.println("Distinct por nombre" + NOMBRE);
        alumnos.forEach(System.out::println);
    }

    @Test
    void topTest() {
        List<Alumno> alumnos = repositorioAlumno.findTop2ByEstatura(ESTATURA);
        System.out.println("Top 3 por estatura: ");
        alumnos.forEach(System.out::println);
    }

    @Test
    void orderByPaternoTest() {
        List<Alumno> alumnos = repositorioAlumno.findByNombreOrderByPaterno(NOMBRE);
        System.out.println("Ordenado por paterno ASC.");
        alumnos.forEach(System.out::println);

        alumnos = repositorioAlumno.findByNombreOrderByPaternoDesc(NOMBRE);
        System.out.println("Ordenado por paterno DESC.");
        alumnos.forEach(System.out::println);
    }

    @Test
    void orderByEstaturaTest() {
        List<Alumno> alumnos = repositorioAlumno.findFirstByOrderByEstatura();
        System.out.println("First ordenado por estatura ASC");
        alumnos.forEach(System.out::println);

        alumnos = repositorioAlumno.findTopByOrderByEstaturaDesc();
        System.out.println("First ordenado por estatura DESC");
        alumnos.forEach(System.out::println);
    }

    @Test
    void existeNombreTest() {
        boolean siAlumno = repositorioAlumno.existsByNombre(NOMBRE);
        System.out.println("Existe alumno por nombre: " + NOMBRE);

        if (siAlumno) {
            List<Alumno> alumnos = repositorioAlumno.getByNombre(NOMBRE);
            System.out.println("Existe alumno por nombre:");
            alumnos.forEach(System.out::println);
        }
    }

    @Test
    void existeNombreYPaternoTest() {
        boolean siAlumno = repositorioAlumno.existsByNombreAndPaterno(NOMBRE, PATERNO);
        System.out.println("Existe alumno por nombre y paterno: " + NOMBRE + " " + PATERNO + ": " + siAlumno);

        if (siAlumno) {
            List<Alumno> alumnos = repositorioAlumno.getByNombreAndPaterno(NOMBRE, PATERNO);
            System.out.println("Existe alumno por nombre y paterno:");
            alumnos.forEach(System.out::println);
        }
    }

    @Test
    void paternoNullTest() {
        List<Alumno> alumnos = repositorioAlumno.findByPaternoIsNull();
        System.out.println("Paterno Null");
        alumnos.forEach(System.out::println);

        alumnos = repositorioAlumno.findByPaternoIsNotNull();
        System.out.println("Paterno Not Null");
        alumnos.forEach(System.out::println);
    }
}