package unam.dgtic.core.proyecto7;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import unam.dgtic.core.proyecto7.controlador.repositorios.AgenciaRepositorio;
import unam.dgtic.core.proyecto7.controlador.repositorios.PuestoRepositorio;
import unam.dgtic.core.proyecto7.modelo.agencia.Agencia;
import unam.dgtic.core.proyecto7.modelo.puesto.Puesto;

@SpringBootTest
class Proyecto7ApplicationTests {

    @Autowired
    AgenciaRepositorio repositorioAgencia;
    @Autowired
    PuestoRepositorio repositorioPuesto;

    @Test
    void pruebaAgencia() {
        Optional<Agencia> optional = repositorioAgencia.findByIdAgencia(1);
        if (optional.isPresent()) {
            System.out.println(optional.get());
        } else {
            System.out.println("No está");
        }
    }

    @Test
    void pruebaPuesto() {
        Optional<Puesto> optional = repositorioPuesto.findByIdPuesto(6);
        if (optional.isPresent()) {
            System.out.println(optional.get().getPuesto());
        } else {
            System.out.println("No está");
        }

    }
}
