package dgtic.core.springcorerestbd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dgtic.core.springcorerestbd.persistence.dao.EstudianteDao;
import dgtic.core.springcorerestbd.persistence.modelo.Estudiante;

@SpringBootTest
class SpringCoreRestbdApplicationTests {

    @Autowired
    private EstudianteDao estudiante;

    @Test
    void contextLoads() {
    }

    @Test
    void estudiante() {
        assertEquals(5, estudiante.consulta().size());
        String actual = estudiante.consultaId("A00").getNombre();
        assertEquals("Rosa", actual);
        Estudiante es = new Estudiante();
        es.setCuenta("A05");
        es.setNombre("DGTIC");
        es.setEdad(23);
        // insertar
        estudiante.insertar(es);
        assertEquals(6, estudiante.consulta().size());
        // actualizar
        es.setNombre("DGTIC 2");
        estudiante.cambiar(es);
        assertEquals("DGTIC 2", estudiante.consultaId(es.getCuenta()).getNombre());
        // borrar
        estudiante.borrar(es);
        assertEquals(5, estudiante.consulta().size());
    }
}
