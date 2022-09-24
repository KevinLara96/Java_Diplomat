package mx.unam.dgtic.m07s3;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class M07s3ApplicationTest04PagingAndSorting {

    @Autowired
    AlumnoPagingAndSortingRepository repositorioAlumno;

    @Autowired
    CalificacionRepository repositorioCalificacion;

    @Test
    void buscarTodosOrderByTest() {
        Iterable<Alumno> iterable = repositorioAlumno.findByOrderByNombre();
        iterable.forEach(System.out::println);

        iterable = repositorioAlumno.findByOrderByNombreDescPaternoDesc();
        iterable.forEach(System.out::println);
    }

    @Test
    void buscarByEstaturaPageableTest() {
        Pageable pag1 = PageRequest.of(0, 5);
        Iterable<Alumno> alumno = repositorioAlumno.findAllByEstatura(1.6, pag1);
        alumno.forEach(System.out::println);

        Pageable pag2 = PageRequest.of(1, 5);
        alumno = repositorioAlumno.findAllByEstatura(1.6, pag2);
        alumno.forEach(System.out::println);
    }

    @Test
    void buscarTodosPageableTest() {
        Pageable pag1 = PageRequest.of(0, 5, Sort.by("nombre").ascending());
        Iterable<Alumno> alumno = repositorioAlumno.findAll(pag1);
        alumno.forEach(System.out::println);

        Pageable pag2 = PageRequest.of(1, 5, Sort.by("estatura").descending());
        alumno = repositorioAlumno.findAll(pag2);
        alumno.forEach(System.out::println);
    }

    @Test
    void buscarTodosPaginasTest() {
        Pageable pagina;
        Iterable<Alumno> iterable;

        for (int i = 0; i <= 4; i++) {
            System.out.println("Página " + i);
            pagina = PageRequest.of(i, 5, Sort.by("nombre").descending());

            iterable = repositorioAlumno.findAll(pagina);
            iterable.forEach(System.out::println);
        }
    }
}
