package dgtic.vista.inicio.principal;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import dgtic.controlador.servicio.catalogos.ServiciosCatalogoPuestoImpl;
import dgtic.controlador.servicio.catalogos.ServiciosCatalogosAutobusImpl;
import dgtic.controlador.servicio.catalogos.ServiciosCatalogosViajeImpl;
import dgtic.controlador.servicio.tablas.ServiciosAgencia;
import dgtic.controlador.servicio.tablas.ServiciosAgenciaImpl;
import dgtic.modelo.entidades.agencia.Agencia;
import dgtic.modelo.entidades.autobus.Autobus;
import dgtic.modelo.entidades.empleado.Empleado;
import dgtic.modelo.entidades.viaje.Viaje;
import dgtic.modelo.hibernate.HibernateUtil;

public class Inicio {
    public static void main(String[] args) throws InterruptedException {

        /*
         * Se crea una nueva instancia de la Agencia.
         * (No puede existir una agencia sin destinos,
         * empleados ni autobuses.)
         */
        System.out.println("Creando agencia...");
        Agencia agencia = Agencia.getInstancia();
        agencia.setIdAgencia(1);
        agencia.setNombreAgencia("Autobuses Kevin.");
        agencia.setUbicacion("Ciudad de México, México");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Iniciando Base de Datos...");
        HibernateUtil.init();

        /* Se crea el usuario administrador base. */
        System.out.println("\n");
        System.out.println("Creando administrador sys ...");
        Empleado sys = new Empleado();
        sys.setIdEmpleado(1);
        sys.setNombre("sys");
        sys.setCorreo("sys@sak.com");
        sys.setContrasena("system1");
        sys.setRfc("");
        sys.setSalario(0.00f);
        ServiciosCatalogoPuestoImpl servicioPuesto = ServiciosCatalogoPuestoImpl.getInstance();
        sys.setPuesto(servicioPuesto.cargaPuestoPorId(1));
        agencia.getEmpleados().add(sys);
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Usuario sys creado.");

        /* Se crea un nuevo destino. */
        Viaje viaje = new Viaje.Builder(1, "México", "Monterrey", 3500.00f, 700, LocalDate.now().toString())
                .setViajeCorto().build();

        ServiciosCatalogosViajeImpl servicioViaje = ServiciosCatalogosViajeImpl.getInstance();
        viaje.setTipoViaje(servicioViaje.cargaTipoViajePorId(1));
        viaje.setTipoTour(servicioViaje.cargaTipoTourPorId(4));
        agencia.getDestinos().add(viaje);

        /* Se crea un nuevo autobús. */
        Autobus autobus = new Autobus.Builder(1, "AMG", "Mercedes", 90).setClaseBus().build();
        ServiciosCatalogosAutobusImpl servicioAutobus = ServiciosCatalogosAutobusImpl.getInstance();
        autobus.setClaseBus(servicioAutobus.cargaClasesBusPorId(3));
        autobus.setClaseTuribus(servicioAutobus.cargaClaseTuribusPorId(4));
        agencia.getAutobuses().add(autobus);

        ServiciosAgencia servicio = ServiciosAgenciaImpl.getInstance();
        servicio.guardaAgencia(agencia);
        System.out.println("Agencia creada.\n");

    }
}
