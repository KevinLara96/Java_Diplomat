package dgtic.pruebas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = { ServicioDAOTest.class })
public class ServicioDAOTest {
    @Test
    public void textUno() {
        String esperado = "Spring";
        String actual = "spring";
        assertEquals(esperado, actual, "Cadenas no iguales");
    }
}