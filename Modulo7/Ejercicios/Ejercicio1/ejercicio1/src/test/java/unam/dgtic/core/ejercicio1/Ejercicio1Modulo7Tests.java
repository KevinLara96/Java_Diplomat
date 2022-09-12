package unam.dgtic.core.ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Ejercicio1Modulo7Tests {

    @Autowired
    AutomovilRepositorio repositorioAutomovil;

    /*
     * Pruebas de consultas a la base de datos.
     */
    @Test
    void pruebaIdTest() {
        Optional<Automovil> automovil = repositorioAutomovil.findByIdAutomovil(12);
        System.out.println("Buscar por Id.");
        if (automovil.isPresent()) {
            System.out.println(automovil);
        } else {
            System.out.println("Id no existente.");
        }
    }

    @Test
    void pruebaListaIdTest() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(6);
        ids.add(9);
        Iterable<Automovil> iterable = repositorioAutomovil.findAllById(ids);
        iterable.forEach(System.out::println);
    }

    @Test
    void pruebaIdNotTest() {
        Iterable<Automovil> iterable = repositorioAutomovil.findByIdAutomovilNot(1);
        System.out.println("Id not.");
        iterable.forEach(System.out::println);

    }

    @Test
    void pruebaMarcaTest() {
        Iterable<Automovil> iterable = repositorioAutomovil.getByMarca("Subaru");
        System.out.println("Buscar por marca.");
        iterable.forEach(System.out::println);
    }

    @Test
    void pruebaMarcaNotTest() {
        Iterable<Automovil> iterable = repositorioAutomovil.getByMarcaNot("Cupra");
        System.out.println("Buscar por marca not.");
        iterable.forEach(System.out::println);
    }

    @Test
    void pruebaNumeroMarcaTest() {
        long numero = repositorioAutomovil.countByMarca("Dodge");
        System.out.println("Contar por marca.");
        System.out.println(numero);
    }

    @Test
    void pruebaModeloTest() {
        Optional<Automovil> automovil = repositorioAutomovil.getByModelo("WRX STi");
        System.out.println("Busca por modelo.");

        if (automovil.isPresent()) {
            System.out.println(automovil.get());
        } else {
            System.out.println("Modelo no encontrado.");
        }
    }
}
