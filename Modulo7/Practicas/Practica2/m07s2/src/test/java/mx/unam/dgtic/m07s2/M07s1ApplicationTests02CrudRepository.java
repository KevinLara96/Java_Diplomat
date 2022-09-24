package mx.unam.dgtic.m07s2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

//import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class M07s1ApplicationTests02CrudRepository {

    @Autowired
    AlumnoRepositorio repositorioAlumno;

    @Test
    void buscarTodosTest() {
        Iterable<Alumno> iterable = repositorioAlumno.findAll();
        List<Alumno> alumnos = new ArrayList<>();
        System.out.println("Buscar todos los alumnos");
        iterable.forEach(alumnos::add);
        alumnos.forEach(System.out::println);

        assertThat(alumnos.size(), greaterThan(6));
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
    void insertarUnoTest() {
        Alumno alumno = new Alumno(
                "1F", "Kevin", "Lara", new Date(), 1.71);
        repositorioAlumno.save(alumno);

        Optional<Alumno> optional = repositorioAlumno.findById("1F");
        System.out.println("Insertar alumno.");

        if (optional.isPresent())
            System.out.println(optional.get().toString());
        else
            System.out.println("Matrícula no localizada.");
    }

    @Test
    void actualizarUnoTest() {

        Optional<Alumno> optional = repositorioAlumno.findById("3B");
        System.out.println("Actualizar alumno.");

        if (optional.isPresent()) {
            Alumno alumno = optional.get();
            alumno.setPaterno("Avenida");
            alumno.setEstatura(1.62);
            repositorioAlumno.save(alumno);

            optional = repositorioAlumno.findById("3B");
            System.out.println(optional.get().toString());
        }
    }

    @Test
    void eliminarUnoTest() {
        repositorioAlumno.deleteById("1A");

        Alumno alumno = new Alumno("1A");
        repositorioAlumno.delete(alumno);
    }

    @Test
    void buscarVariosTest() {
        Iterable<Alumno> iterable = repositorioAlumno.findAllById(List.of("2A", "4A", "5A", "15A"));
        List<Alumno> miLista = new ArrayList<>();

        System.out.println("Buscar varios.");
        iterable.forEach(miLista::add);
        iterable.forEach(System.out::println);
    }

    @Test
    void insertarVariosTest() {
        List<Alumno> miLista = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            miLista.add(new Alumno(i + "N", "Marco " + i, "Polo " + i, new Date(), 1.6 + (i / 10)));
        }

        System.out.println("Alumnos antes de insertar varios: " + repositorioAlumno.count());
        repositorioAlumno.saveAll(miLista);
        System.out.println("Alumnos después de insertar varios: " + repositorioAlumno.count());
    }
}
