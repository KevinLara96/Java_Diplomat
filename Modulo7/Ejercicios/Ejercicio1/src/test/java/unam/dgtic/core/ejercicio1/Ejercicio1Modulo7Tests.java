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
        Optional<Automovil> automovil = repositorioAutomovil.findByIdAutomovil(10);
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
    void pruebaMarcaTest() {
        Iterable<Automovil> iterable = repositorioAutomovil.getByMarca("Subaru");
        System.out.println("Buscar por marca.");
        iterable.forEach(System.out::println);
    }

    @Test
    void pruebaCantidadMarcaTest() {
        long numero = repositorioAutomovil.countByMarca("Dodge");
        System.out.println("Contar por marca.");
        System.out.println(numero);
    }

    @Test
    void pruebaModeloTest() {
        Iterable<Automovil> iterable = repositorioAutomovil.getByModelo("WRX STi");
        System.out.println("Busca por modelo.");

        iterable.forEach(System.out::println);
    }

    @Test
    void pruebaCantidadModeloTest() {
        long numero = repositorioAutomovil.countByModelo("León");
        System.out.println("Cantidad por modelo: León");
        System.out.println(numero);
    }

    @Test
    void pruebaMarcaLikeTest() {
        String patron = "%u";
        Iterable<Automovil> iterable = repositorioAutomovil.findByMarcaLike(patron);
        System.out.println("Marca like.");
        iterable.forEach(System.out::println);
    }

    @Test
    void pruebaModeloPrefijoTest() {
        String prefijo = "A";
        Iterable<Automovil> iterable = repositorioAutomovil.findByModeloStartingWith(prefijo);
        System.out.println("Modelo starting with.");

        iterable.forEach(System.out::println);
    }

    @Test
    void pruebaTopTorqueTest() {
        Iterable<Automovil> iterable = repositorioAutomovil.findTop2ByTorque(650);
        System.out.println("Top2 de torque");
        iterable.forEach(System.out::println);
    }

    @Test
    void pruebaPotenciaMarcaTest() {
        Iterable<Automovil> iterable = repositorioAutomovil.findByMarcaOrderByPotencia("Subaru");
        iterable.forEach(System.out::println);
    }

    @Test
    void pruebaTorqueBetweenTest() {
        Iterable<Automovil> iterable = repositorioAutomovil.findByTorqueBetween(250, 500);
        iterable.forEach(System.out::println);
    }

    @Test
    void pruebaColoresIn() {
        List<String> colores = new ArrayList<>();
        colores.add("Rojo");
        colores.add("Negro");
        colores.add("Naranja");
        Iterable<Automovil> iterable = repositorioAutomovil.findByColorIn(colores);

        System.out.println("Colores in:");
        iterable.forEach(System.out::println);
    }

    /*
     * Pruebas persistencia.
     */

    @Test
    void insertaElementoTest() {
        Automovil automovil = new Automovil(8, "Nueva marca", "Nuevo modelo", "Rojo", 306, 280);
        Optional<Automovil> optional = repositorioAutomovil.findById(8);
        System.out.println("Insertar auto.");

        if (optional.isPresent()) {
            System.out.println(optional.get());
        } else {
            repositorioAutomovil.save(automovil);
        }
    }

    @Test
    void eliminarElementoTest() {
        repositorioAutomovil.deleteById(20);
    }

    @Test
    void actualizarElementoTest() {
        Optional<Automovil> optional = repositorioAutomovil.findById(9);

        if (optional.isPresent()) {
            optional.get().setColor("Café");
            repositorioAutomovil.save(optional.get());
        }
    }
}
