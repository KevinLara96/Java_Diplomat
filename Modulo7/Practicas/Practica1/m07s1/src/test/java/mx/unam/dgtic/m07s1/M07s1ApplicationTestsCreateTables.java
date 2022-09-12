package mx.unam.dgtic.m07s1;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql({ "/schema.sql", "/data.sql" }) // La "/" indica la carpeta de resources.
public class M07s1ApplicationTestsCreateTables {

    @Test
    void contextLoads() {

    }
}
