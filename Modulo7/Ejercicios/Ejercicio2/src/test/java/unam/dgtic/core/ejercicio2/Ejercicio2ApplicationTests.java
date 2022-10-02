package unam.dgtic.core.ejercicio2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql({ "/schema.sql", "/data.sql" }) // La "/" indica la carpeta de resources.
public class Ejercicio2ApplicationTests {

    @Test
    void contextLoads() {

    }
}
