package unam.dgtic.core.ejercicio3;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql({ "/schema.sql", "/data.sql" }) // La "/" indica la carpeta de resources.
public class Ejercicio3ApplicationTests {

    // @Test
    void contextLoads() {

    }
}
