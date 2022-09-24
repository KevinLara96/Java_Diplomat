package mx.unam.dgtic.m07s3;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class M07s3ApplicationTest02NamedNativeQuery {

    @Autowired
    AlumnoRepositorio repositorioAlumno;

    @Test
    void buscarAltosMayorPromedioTest() {
        double estaturaPromedio = repositorioAlumno.buscarEstaturaPromedioAlumnos();
        Iterable<Alumno> iterable = repositorioAlumno.buscarAltos();

        System.out.println("Estatura promedio: " + estaturaPromedio);
        iterable.forEach(System.out::println);
    }

    @Test
    void buscarPorNombreNamedQueryTest() {
        Iterable<Alumno> iterable = repositorioAlumno.buscarPorNombre("Kevin");
        iterable.forEach(System.out::println);

        iterable = repositorioAlumno.buscarPorNombreYPaterno("Kevin", "Lara");
        iterable.forEach(System.out::println);
    }

    @Test
    void buscarTodosNativeQueryTest() {
        Iterable<Alumno> iterable = repositorioAlumno.buscarAlumnoConCalificacion();
        iterable.forEach(System.out::println);

        iterable = repositorioAlumno.buscarPorNombreYPaternoNative("Kevin", "Lara");
        iterable.forEach(System.out::println);
    }

    @Test
    void buscarTodosConCalificacionesTest() {
        Iterable<Alumno> iterable = repositorioAlumno.buscarTodosConCalificaciones();
        iterable.forEach(System.out::println);

        for (Alumno a : iterable) {
            System.out.println(a);
            List<Calificacion> calificaciones = a.getCalificaciones();
            for (Calificacion cal : calificaciones) {
                System.out.println(cal);
            }
        }
    }
}