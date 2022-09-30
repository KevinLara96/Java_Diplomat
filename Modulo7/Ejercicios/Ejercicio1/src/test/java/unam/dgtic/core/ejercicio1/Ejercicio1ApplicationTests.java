package unam.dgtic.core.ejercicio1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql({ "/schema.sql", "/data.sql" }) // La "/" indica la carpeta de resources.
public class Ejercicio1ApplicationTests {

    @Test
    void contextLoads() {

    }
}
