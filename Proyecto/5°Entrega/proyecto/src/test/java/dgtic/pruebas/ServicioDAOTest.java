package dgtic.pruebas;

import static org.mockito.ArgumentMatchers.contains;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import dgtic.core.controlador.servicio.ServicioDAO;

@SpringBootTest(classes = { ServicioDAOTest.class })
@ComponentScan(basePackages = "dgtic.core")
public class ServicioDAOTest {

    @Autowired
    private ServicioDAO servicio;
    private Integer contadorPruebas = 0;

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
    @DisplayName("Prueba 1. Nombre empleado.")
    public void testUno() {

    }
}
