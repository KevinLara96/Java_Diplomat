package dgtic.core.vista.inicio;

import java.time.LocalDate;

import dgtic.core.controlador.servicio.catalogos.ServiciosCatalogoPuestoImpl;
import dgtic.core.controlador.servicio.catalogos.ServiciosCatalogosAutobusImpl;
import dgtic.core.controlador.servicio.catalogos.ServiciosCatalogosViajeImpl;
import dgtic.core.controlador.servicio.tablas.ServiciosAgencia;
import dgtic.core.controlador.servicio.tablas.ServiciosAgenciaImpl;
import dgtic.core.controlador.servicio.tablas.ServiciosAutobusImpl;
import dgtic.core.controlador.servicio.tablas.ServiciosEmpleadoImpl;
import dgtic.core.controlador.servicio.tablas.ServiciosViajeImpl;
import dgtic.core.modelo.entidades.agencia.Agencia;
import dgtic.core.modelo.entidades.autobus.Autobus;
import dgtic.core.modelo.entidades.empleado.Empleado;
import dgtic.core.modelo.entidades.viaje.Viaje;
import dgtic.core.modelo.hibernate.HibernateUtil;

public class Inicio {
    /**
     * Este método se usa únicamente para la persistencia con hibernate.
     * Para la ejecucicón del proyecto, referirse a la Clase Inicio_v2.
     * 
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        /*
         * Se crea una nueva instancia de la Agencia.
         * (No puede existir una agencia sin destinos,
         * empleados ni autobuses.)
         */
        System.out.println("Creando agencia...");
        Agencia agencia = new Agencia();
        agencia.setIdAgencia(1);
        agencia.setNombreAgencia("Autobuses Kevin.");
        agencia.setUbicacion("Ciudad de México, México");
        System.out.println("Iniciando Base de Datos...");
        HibernateUtil.init();
        ServiciosAgencia servicio = ServiciosAgenciaImpl.getInstance();
        servicio.guardaAgencia(agencia);

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
        sys.setAgencia(agencia);
        ServiciosEmpleadoImpl servicioEmpleado = ServiciosEmpleadoImpl.getInstance();
        servicioEmpleado.guardaEmpleado(sys);
        System.out.println("Usuario sys creado.");

        /* Se crea un nuevo destino. */
        Viaje viaje = new Viaje.Builder(1, "México", "Monterrey", 3500.00f, 700, LocalDate.now().toString())
                .setViajeCorto().build();
        ServiciosCatalogosViajeImpl servicioViajeCat = ServiciosCatalogosViajeImpl.getInstance();
        viaje.setTipoViaje(servicioViajeCat.cargaTipoViajePorId(1));
        viaje.setTipoTour(servicioViajeCat.cargaTipoTourPorId(4));
        agencia.getDestinos().add(viaje);
        viaje.setAgencia(agencia);
        ServiciosViajeImpl servicioViaje = ServiciosViajeImpl.getInstance();
        servicioViaje.guardaViaje(viaje);
        System.out.println("Nuevo destino guardado.");

        /* Se crea un nuevo autobús. */
        Autobus autobus = new Autobus.Builder(1, "AMG", "Mercedes", 90).setClaseBus().build();
        ServiciosCatalogosAutobusImpl servicioAutobusCat = ServiciosCatalogosAutobusImpl.getInstance();
        autobus.setClaseBus(servicioAutobusCat.cargaClasesBusPorId(3));
        autobus.setClaseTuribus(servicioAutobusCat.cargaClaseTuribusPorId(4));
        agencia.getAutobuses().add(autobus);
        autobus.setAgencia(agencia);
        ServiciosAutobusImpl servicioAutobus = ServiciosAutobusImpl.getInstance();
        servicioAutobus.guardaAutobus(autobus);

        servicio.actualizaAgencia(agencia);
        System.out.println("Agencia creada.\n");

    }
}
