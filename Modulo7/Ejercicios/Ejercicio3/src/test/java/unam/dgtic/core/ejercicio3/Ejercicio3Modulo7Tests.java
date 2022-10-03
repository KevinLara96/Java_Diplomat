package unam.dgtic.core.ejercicio3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
public class Ejercicio3Modulo7Tests {

    @Autowired
    AutomovilRepositorio repositorioAutomovil;

    @Autowired
    AutomovilPagingAndSortingRepository repositorioAutomovilPS;

    @Test
    void namedQueryNativeTest() {
        Iterable<Automovil> iterable = repositorioAutomovil.buscarTodosConDueno();
        iterable.forEach(System.out::println);

    }

    @Test
    void namedQueryRapidosTest() {
        Iterable<Automovil> iterable = repositorioAutomovil.buscarRapidos();
        iterable.forEach(System.out::println);

    }

    @Test
    void namedQueryColorTest() {
        Iterable<Automovil> iterable = repositorioAutomovil.buscarPorColor();
        iterable.forEach(System.out::println);
    }

    @Test
    void buscarDTOTest() {
        Iterable<AutomovilDTO> iterable = repositorioAutomovil.findAutomovilDTO();

        iterable.forEach(System.out::println);
    }

    @Test
    void buscarTodosOrderByTest() {
        Iterable<Automovil> iterable = repositorioAutomovilPS.findByOrderByMarca();
        iterable.forEach(System.out::println);

        iterable = repositorioAutomovilPS.findByOrderByMarcaDescModeloDesc();
        iterable.forEach(System.out::println);
    }

    @Test
    void buscarByPotenciaPageableTest() {
        Pageable pag1 = PageRequest.of(0, 5);
        Iterable<Automovil> automovi = repositorioAutomovilPS.findAllByPotencia(280, pag1);
        automovi.forEach(System.out::println);

        Pageable pag2 = PageRequest.of(1, 5);
        automovi = repositorioAutomovilPS.findAllByPotencia(717, pag2);
        automovi.forEach(System.out::println);
    }

    @Test
    void buscarTodosPageableTest() {
        Pageable pag1 = PageRequest.of(0, 2, Sort.by("marca").ascending());
        Iterable<Automovil> automovi = repositorioAutomovilPS.findAll(pag1);
        automovi.forEach(System.out::println);

        Pageable pag2 = PageRequest.of(1, 2, Sort.by("modelo").descending());
        automovi = repositorioAutomovilPS.findAll(pag2);
        automovi.forEach(System.out::println);
    }

    @Test
    void buscarTodosPaginasTest() {
        Pageable pagina;
        Iterable<Automovil> iterable;

        for (int i = 0; i <= 4; i++) {
            System.out.println("Página " + i);
            pagina = PageRequest.of(i, 2, Sort.by("color").descending());

            iterable = repositorioAutomovilPS.findAll(pagina);
            iterable.forEach(System.out::println);
        }
    }
}