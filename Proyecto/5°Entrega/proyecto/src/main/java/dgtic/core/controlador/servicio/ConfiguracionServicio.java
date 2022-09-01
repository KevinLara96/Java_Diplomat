package dgtic.core.controlador.servicio;

import java.time.LocalDate;

import org.springframework.context.annotation.*;

import dgtic.core.modelo.entidades.autobus.Autobus;
import dgtic.core.modelo.entidades.empleado.Empleado;
import dgtic.core.modelo.entidades.viaje.Viaje;

@Configuration
@ComponentScan("dgtic.core")
public class ConfiguracionServicio {

    @Bean(name = "empleado")
    @Scope("prototype")
    public Empleado servicioEmpleado() {
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(1);
        empleado.setNombre("Empleado Bean");
        empleado.setCorreo("correo_bean@sak.com");
        empleado.setRfc("rfc_empleado_bean");
        return empleado;
    }

    @Bean(name = "viajeCorto")
    @Scope("prototype")
    public Viaje servicioViajeCorto() {
        Viaje viaje = new Viaje.Builder().setViajeCorto().build();
        viaje.setIdViaje(1);
        viaje.setOrigen("México");
        viaje.setDestino("Hidalgo");
        viaje.setFecha(LocalDate.now().toString());
        return viaje;
    }

    @Bean(name = "viajeLargo")
    @Scope("prototype")
    public Viaje servicioViajeLargo() {
        Viaje viaje = new Viaje.Builder().setViajeLargo().build();
        viaje.setIdViaje(1);
        viaje.setOrigen("México");
        viaje.setDestino("Monterrey");
        viaje.setFecha(LocalDate.now().toString());
        return viaje;
    }

    @Bean(name = "bus")
    @Scope("prototype")
    public Autobus servicioBus() {
        Autobus autobus = new Autobus.Builder().setClaseBus().build();
        autobus.setIdAutobus(1);
        autobus.setMarca("Volvo");
        autobus.setModelo("9800");
        autobus.setCapacidad(80);
        return autobus;
    }
}
