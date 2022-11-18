package dgtic.core.proyecto6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dgtic.core.proyecto6.persistencia.dao.interfaces.AgenciaDAO;
import dgtic.core.proyecto6.persistencia.dao.interfaces.TipoViajeDAO;
import dgtic.core.proyecto6.persistencia.dao.interfaces.ViajesDAO;
import dgtic.core.proyecto6.persistencia.modelo.agencia.Agencia;
import dgtic.core.proyecto6.persistencia.modelo.viaje.TipoViaje;
import dgtic.core.proyecto6.persistencia.modelo.viaje.Viaje;

@SpringBootTest
class Proyecto6ApplicationTests {

    @Autowired
    private AgenciaDAO agenciaDAO;

    @Autowired
    private TipoViajeDAO tipoViajeDAO;

    @Autowired
    private ViajesDAO viajesDAO;

    @Test
    void contextLoads() {
    }

    @Test
    void insertarAgencia() {
        Agencia agenciaNueva = new Agencia();
        agenciaNueva.setIdAgencia(4);
        agenciaNueva.setNombreAgencia("Agencia 4");
        agenciaNueva.setUbicacion("Cancún");

        // Consultar
        assertEquals(3, agenciaDAO.consultaAgencias().size());

        // Insertar
        agenciaDAO.insertarAgencia(agenciaNueva);
        assertEquals(4, agenciaDAO.consultaAgencias().size());

        // Actualizar
        agenciaNueva.setUbicacion("Acapulco");
        agenciaDAO.cambiarAgencia(agenciaNueva);
        assertEquals("Acapulco", agenciaDAO.consultaIdAgencia(
                agenciaNueva.getIdAgencia()).getUbicacion());

        // Eliminar
        agenciaDAO.borrarAgencia(agenciaNueva);
        assertEquals(3, agenciaDAO.consultaAgencias().size());

    }

    @Test
    void tipoViaje() {
        TipoViaje tipoViajeNuevo = new TipoViaje();
        tipoViajeNuevo.setIdTipoViaje(5);
        tipoViajeNuevo.setTipoViaje("Tipo viaje prueba");

        // Consultar
        assertEquals(4, tipoViajeDAO.consultaTiposViaje().size());

        // Insertar
        tipoViajeDAO.insertarTipoViaje(tipoViajeNuevo);
        assertEquals(5, tipoViajeDAO.consultaTiposViaje().size());

        // Actualizar
        tipoViajeNuevo.setTipoViaje("Nuevo tipo viaje");
        tipoViajeDAO.cambiarTipoViaje(tipoViajeNuevo);
        assertEquals("Nuevo tipo viaje", tipoViajeDAO.consultaIdTipoViaje(
                tipoViajeNuevo.getIdTipoViaje()).getTipoViaje());

        // Eliminar
        tipoViajeDAO.borrarTipoViaje(tipoViajeNuevo);
        assertEquals(4, tipoViajeDAO.consultaTiposViaje().size());

    }

    @Test
    void viaje() {
        Viaje viajeNuevo = new Viaje();
        viajeNuevo.setIdViaje(6);
        viajeNuevo.setOrigen("Monterrey");
        viajeNuevo.setDestino("Nuevo Laredo");
        viajeNuevo.setPrecio(500.0f);
        viajeNuevo.setFecha("05/Ene/2023");
        viajeNuevo.setIdAgencia(3);
        viajeNuevo.setIdTipoViaje(1);

        // Consultar
        assertEquals(5, viajesDAO.consultaViajes().size());

        // Insertar
        viajesDAO.insertarViaje(viajeNuevo);
        assertEquals(6, viajesDAO.consultaViajes().size());

        // Actualizar
        viajeNuevo.setDestino("Matamoros");
        viajesDAO.cambiarViaje(viajeNuevo);
        System.out.println(viajeNuevo);
        assertEquals("Matamoros", viajesDAO.consultaIdViaje(
                viajeNuevo.getIdViaje()).getDestino());

        // Eliminar
        viajesDAO.borrarViaje(viajeNuevo);
        assertEquals(5, viajesDAO.consultaViajes().size());
    }
}
