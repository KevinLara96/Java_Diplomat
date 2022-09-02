package dgtic.core.baseDatos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import dgtic.core.modelo.entidades.agencia.Agencia;
import dgtic.core.modelo.entidades.agencia.asignaciones.ConductorAutobus;
import dgtic.core.modelo.entidades.agencia.asignaciones.ConductorViaje;
import dgtic.core.modelo.entidades.autobus.Autobus;
import dgtic.core.modelo.entidades.autobus.ClaseBus;
import dgtic.core.modelo.entidades.autobus.ClaseTuribus;
import dgtic.core.modelo.entidades.empleado.Empleado;
import dgtic.core.modelo.entidades.viaje.TipoTour;
import dgtic.core.modelo.entidades.viaje.TipoViaje;
import dgtic.core.modelo.entidades.viaje.Viaje;

public class BaseDeDatos {
    public static Set<Empleado> empleados = new HashSet<>();
    public static Set<Autobus> autobuses = new HashSet<>();
    public static Set<Viaje> destinos = new HashSet<>();
    public static Agencia agencia = new Agencia();
    public static Set<ConductorAutobus> conductorAutobus = new HashSet<>();
    public static Set<ConductorViaje> conductorViaje = new HashSet<>();

    static {
        Empleado empleado;
        Autobus autobus;
        Viaje viaje;

        /* Conductores */
        empleado = new Empleado("Empleado 1", "correo1@sak.com", "contrasena1", "rfc1", 10000.0f);
        empleado.setAgencia(agencia);
        empleados.add(empleado);

        empleado = new Empleado("Empleado 2", "correo2@sak.com", "contrasena2", "rfc2", 20000.0f);
        empleado.setAgencia(agencia);
        empleados.add(empleado);

        empleado = new Empleado("Empleado 3", "correo3@sak.com", "contrasena3", "rfc3", 30000.0f);
        empleado.setAgencia(agencia);
        empleados.add(empleado);

        empleado = new Empleado("Empleado 4", "correo4@sak.com", "contrasena4", "rfc4", 40000.0f);
        empleado.setAgencia(agencia);
        empleados.add(empleado);

        empleado = new Empleado("Empleado 5", "correo5@sak.com", "contrasena5", "rfc5", 50000.0f);
        empleado.setAgencia(agencia);
        empleados.add(empleado);

        /* Destinos */
        viaje = new Viaje(1, "México", "Monterrey", 1000.0f, 100, LocalDate.now().toString());
        viaje.setTipoTour(new TipoTour());
        viaje.setTipoViaje(new TipoViaje());
        viaje.setAgencia(agencia);
        destinos.add(viaje);

        viaje = new Viaje(1, "México", "Guadalajara", 2000.0f, 200, LocalDate.now().toString());
        viaje.setTipoTour(new TipoTour());
        viaje.setTipoViaje(new TipoViaje());
        viaje.setAgencia(agencia);
        destinos.add(viaje);

        viaje = new Viaje(1, "México", "Tijuana", 3000.0f, 300, LocalDate.now().toString());
        viaje.setTipoTour(new TipoTour());
        viaje.setTipoViaje(new TipoViaje());
        viaje.setAgencia(agencia);
        destinos.add(viaje);

        viaje = new Viaje(1, "México", "Oaxaca", 4000.0f, 400, LocalDate.now().toString());
        viaje.setTipoTour(new TipoTour());
        viaje.setTipoViaje(new TipoViaje());
        viaje.setAgencia(agencia);
        destinos.add(viaje);

        viaje = new Viaje(1, "México", "Ciudad Juárez", 5000.0f, 500, LocalDate.now().toString());
        viaje.setTipoTour(new TipoTour());
        viaje.setTipoViaje(new TipoViaje());
        viaje.setAgencia(agencia);
        destinos.add(viaje);

        /* Autobuses. */
        autobus = new Autobus(1, "Sigma", "Mercedes Benz", 100);
        autobus.setClaseBus(new ClaseBus());
        autobus.setClaseTuribus(new ClaseTuribus());
        autobus.setAgencia(agencia);
        autobuses.add(autobus);

        autobus = new Autobus(1, "Torino", "Mercedes Benz", 200);
        autobus.setClaseBus(new ClaseBus());
        autobus.setClaseTuribus(new ClaseTuribus());
        autobus.setAgencia(agencia);
        autobuses.add(autobus);

        autobus = new Autobus(1, "9800", "Volvo", 300);
        autobus.setClaseBus(new ClaseBus());
        autobus.setClaseTuribus(new ClaseTuribus());
        autobus.setAgencia(agencia);
        autobuses.add(autobus);

        autobus = new Autobus(1, "9700", "Volvo", 400);
        autobus.setClaseBus(new ClaseBus());
        autobus.setClaseTuribus(new ClaseTuribus());
        autobus.setAgencia(agencia);
        autobuses.add(autobus);

        autobus = new Autobus(1, "ProCity", "Volvo", 500);
        autobus.setClaseBus(new ClaseBus());
        autobus.setClaseTuribus(new ClaseTuribus());
        autobus.setAgencia(agencia);
        autobuses.add(autobus);

        /* Agencia */
        agencia.setAutobuses(autobuses);
        agencia.setEmpleados(empleados);
        agencia.setDestinos(destinos);
    }
}