package dgtic.core.ejercicio2;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.*;
import org.springframework.context.annotation.*;

import dgtic.core.modelo.Autor;
import dgtic.core.modelo.Libro;
import dgtic.core.repositorio.BaseDeDatos;
import dgtic.core.servicio.ServicioDAO;

@SpringBootTest(classes = ServicioDAOTest.class)
@ComponentScan(basePackages = "dgtic.core")
class ServicioDAOTest {

    @Autowired
    private ServicioDAO servicio;
    private static Integer contadorPruebas = 0;

    @BeforeEach
    public void before() {
        contadorPruebas++;
        System.out.println("Prueba número " + contadorPruebas + " iniciando.");
    }

    @AfterEach
    public void after() {
        System.out.println("Prueba número " + contadorPruebas + " terminada.");
    }

    @Test
    @DisplayName("Prueba 1. Libro default singleton")
    void testUno() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ServicioDAO.class);
        Libro libro = (Libro) context.getBean("LibroDefault");
        Libro libro2 = (Libro) context.getBean("LibroDefault");
        assertSame(libro, libro2);
        context.close();
    }

    @Test
    @DisplayName("Prueba 2. Autor default prototype")
    void testDos() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ServicioDAO.class);
        Autor autor = (Autor) context.getBean("AutorDefault");
        Autor autor2 = (Autor) context.getBean("AutorDefault");

        assertNotSame(autor, autor2);
        context.close();
    }

    @Test
    @DisplayName("Prueba 3. Mínimo 5 libros en la base de datos.")
    void testTres() {
        Map<String, Libro> libros = BaseDeDatos.libros;
        assertTrue(
                libros.size() >= 5);
    }

    @Test
    @DisplayName("Prueba 4. Todos los libros tienen al menos un autor registrado.")
    void testCuatro() {
        for (var entry : BaseDeDatos.libros.entrySet()) {
            if (entry.getValue().getAutores().size() == 0) {
                assertTrue(false);
            }
        }
        assertTrue(true);
    }

    @Test
    @DisplayName("Prueba 5. Está la divina comedia en la Base de Datos mediante beans")
    void testCinco() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ServicioDAO.class);
        try {
            Libro libro = (Libro) context.getBean("DivinaComedia");
            assertNotNull(libro);

        } catch (Exception e) {
            assertTrue(false);
        }
        context.close();
    }

    @Test
    @DisplayName("Prueba 6. Está Cómo programa Java en la Base de datos mediante servicio.")
    void testSeis() {
        Set<String> tmp = servicio.getServicioDAO().getLibrosStr();
        for (String titulo : tmp) {
            if (titulo.equals("Cómo programar en Java")) {
                assertTrue(true);
                return;
            } else {
            }
        }
        assertTrue(false);
    }

    @Test
    @DisplayName("Prueba 7. Existe al menos un libro de Dennis Ritchie")
    void testSiete() {
        Map<String, Libro> libros = BaseDeDatos.libros;
        for (var valor : libros.entrySet()) {
            for (Autor autor : valor.getValue().getAutores()) {
                if (autor.getNombre().equals("Dennis Ritchie")) {
                    assertTrue(true);
                    return;
                }
            }
        }
        assertTrue(false);
    }

    @Test
    @DisplayName("Prueba 8. Todos los libros tienen un isbn asignado.")
    void testOcho() {
        Map<String, Libro> libros = BaseDeDatos.libros;
        for (var valor : libros.entrySet()) {
            if (valor.getValue().getIsbn() == null) {
                assertTrue(false);
            }
        }
        assertTrue(true);
    }

    @Test
    @DisplayName("Prueba 9. La consulta a la Base de Datos no debe tardar más de 1 segundo")
    void testNueve() {
        assertTimeout(java.time.Duration.ofSeconds(1), () -> {
            servicio.archivoCSV();
        });
    }

    @Test
    @DisplayName("Prueba 10. Ningún empleado deberá tener el mismo Id.")
    public void testDiez() {
        List<Libro> libros = new ArrayList<>(BaseDeDatos.libros.values());
        List<Libro> comparador = new ArrayList<>(libros);
        for (int i = 0; i < comparador.size(); i++) {
            for (int j = i + 1; j < comparador.size(); j++) {
                assertNotEquals(comparador.get(i).getIsbn(), comparador.get(j).getIsbn());
            }
        }
    }
}
