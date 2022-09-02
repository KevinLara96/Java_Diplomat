package dgtic.pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import dgtic.core.controlador.servicio.ServicioDAO;
import dgtic.core.excepciones.AgenciaVacia;
import dgtic.core.modelo.entidades.agencia.Agencia;
import dgtic.core.modelo.entidades.agencia.asignaciones.ConductorAutobus;
import dgtic.core.modelo.entidades.agencia.asignaciones.ConductorViaje;
import dgtic.core.modelo.entidades.empleado.Empleado;
import dgtic.core.modelo.entidades.viaje.Viaje;

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
    @DisplayName("Prueba 1. Agencia Singleton.")
    public void testUno() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ServicioDAO.class);

        // Agencia agencia = new Agencia();
        Agencia agencia = (Agencia) context.getBean("agencia");
        Agencia agencia2 = (Agencia) context.getBean("agencia");
        assertSame(agencia, agencia2);
        context.close();
    }

    @Test
    @DisplayName("Prueba 3. Agencia Equals.")
    public void testDos() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ServicioDAO.class);

        Agencia agencia = new Agencia();
        agencia.setIdAgencia(1);
        agencia.setNombreAgencia("Autobuses Kevin");
        agencia.setUbicacion("Ciudad de México");

        Agencia agencia2 = (Agencia) context.getBean("agencia");
        assertEquals(agencia, agencia2);

        context.close();
    }

    @Test
    @DisplayName("Prueba 3. Viaje Largo no nulo.")
    public void testTres() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ServicioDAO.class);
        Viaje viaje = (Viaje) context.getBean("viajeLargo");

        assertNotNull(viaje);
        context.close();
    }

    @Test
    @DisplayName("Prueba 4. Viaje Medio Nulo.")
    public void testCuatro() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ServicioDAO.class);
        Viaje viaje = null;
        try {
            viaje = (Viaje) context.getBean("viajeMedio");
        } catch (Exception e) {
            assertNull(viaje);
        }

        context.close();
    }

    @Test
    @DisplayName("Prueba 5. Hay empleados en la Base de Datos.")
    public void testCinco() {
        Set<Empleado> set = servicio.getServicioDAO().getEmpleados();

        assertFalse(set.isEmpty());
    }

    @Test
    @DisplayName("Prueba 6. Hay destinos ofertados en la Base de Datos.")
    public void testSeis() {
        Set<Viaje> viajes = servicio.getServicioDAO().getDestinos();

        assertFalse(viajes.isEmpty());
    }

    @Test
    @DisplayName("Prueba 7. No hay asignaciones de ningún conductor")
    public void testSiete() {
        Set<ConductorAutobus> conductorAutobuses = servicio.getServicioDAO().getAutobusesAsignados();
        Set<ConductorViaje> conductorViajes = servicio.getServicioDAO().getViajesAsignados();

        assertAll(
                () -> {
                    assertTrue(conductorAutobuses.isEmpty());
                },
                () -> {
                    assertTrue(conductorViajes.isEmpty());
                });
    }

    @Test
    @DisplayName("Prueba 8. Se verifica el tiempo de consulta de todos los CSV.")
    public void testOcho() {
        assertTimeout(java.time.Duration.ofSeconds(1), () -> {
            servicio.archivoCSVAutobuses();
            servicio.archivoCSVDestinos();
            servicio.archivoCSVEmpleados();
        });
    }

    @Test
    @DisplayName("Prueba 9. Se verifica que no exista una agencia sin nombre mediante excepciones.")
    public void testNueve() {
        // ConfigurableApplicationContext context = new
        // AnnotationConfigApplicationContext(ServicioDAO.class);
        Agencia agencia = new Agencia();
        Exception exp = assertThrows(AgenciaVacia.class, () -> {
            agencia.getNombreAgencia();
        });

        assertEquals("Agencia sin nombre.", exp.getMessage());
    }

    @Test
    @DisplayName("Prueba 10. Ningún empleado deberá tener el mismo Id.")
    public void testDiez() {
        Set<Empleado> empleados = servicio.getServicioDAO().getEmpleados();
        List<Empleado> comparador = new ArrayList<>(empleados);
        for (int i = 0; i < comparador.size(); i++) {
            for (int j = i + 1; j < comparador.size(); j++) {
                assertNotEquals(comparador.get(i), comparador.get(j));
            }
        }
    }
}
