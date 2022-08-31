package dgtic.baseDatos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dgtic.modelo.entidades.autobus.Autobus;
import dgtic.modelo.entidades.empleado.Empleado;
import dgtic.modelo.entidades.viaje.Viaje;

public class BaseDeDatos {
    public static List<Empleado> empleados = new ArrayList<>();
    public static List<Autobus> autobuses = new ArrayList<>();
    public static Map<Empleado, Viaje> conductorViaje = new HashMap<>();

    static {
        Empleado empleado;
        Autobus autobus;
        Viaje viaje;

        empleado = new Empleado("Empleado 1", "correo1@sak.com", "contrasena1", "rfc1", 10000.0f);
        viaje = new Viaje(1, "Origen 1", "Destino 1", 1000.0f, 100, LocalDate.now().toString());
        empleados.add(empleado);
        conductorViaje.put(empleado, viaje);

        empleado = new Empleado("Empleado 2", "correo2@sak.com", "contrasena2", "rfc2", 20000.0f);
        viaje = new Viaje(1, "Origen 2", "Destino 2", 2000.0f, 200, LocalDate.now().toString());
        empleados.add(empleado);
        conductorViaje.put(empleado, viaje);

        empleado = new Empleado("Empleado 3", "correo3@sak.com", "contrasena3", "rfc3", 30000.0f);
        viaje = new Viaje(1, "Origen 3", "Destino 3", 3000.0f, 300, LocalDate.now().toString());
        empleados.add(empleado);
        conductorViaje.put(empleado, viaje);

        empleado = new Empleado("Empleado 4", "correo4@sak.com", "contrasena4", "rfc4", 40000.0f);
        viaje = new Viaje(1, "Origen 4", "Destino 4", 4000.0f, 400, LocalDate.now().toString());
        empleados.add(empleado);
        conductorViaje.put(empleado, viaje);

        empleado = new Empleado("Empleado 5", "correo5@sak.com", "contrasena5", "rfc5", 50000.0f);
        viaje = new Viaje(1, "Origen 5", "Destino 5", 5000.0f, 500, LocalDate.now().toString());
        empleados.add(empleado);
        conductorViaje.put(empleado, viaje);

        autobus = new Autobus(1, "Modelo1", "Marca1", 100);
        autobuses.add(autobus);
        autobus = new Autobus(1, "Modelo2", "Marca2", 200);
        autobuses.add(autobus);
        autobus = new Autobus(1, "Modelo3", "Marca3", 300);
        autobuses.add(autobus);
        autobus = new Autobus(1, "Modelo4", "Marca4", 400);
        autobuses.add(autobus);
        autobus = new Autobus(1, "Modelo5", "Marca5", 500);
        autobuses.add(autobus);

    }
}