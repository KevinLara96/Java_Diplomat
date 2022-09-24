package mx.unam.dgtic.m07s3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class M07s3ApplicationTest03DTO {
    @Autowired
    AlumnoRepositorio repositorioAlumno;

    @Autowired
    CalificacionRepository repositorioCalificacion;

    @Test
    void buscarTodosNativeQueryTest() {
        Iterable<AlumnoCalificacionDTO> iterable = repositorioAlumno.findAlumnoCalificacionDTO();

        iterable.forEach(System.out::println);
    }
}
