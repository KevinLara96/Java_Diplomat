package dgtic.core.vista.inicio;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dgtic.core.baseDatos.intf.BaseDeDatosDAO;
import dgtic.core.controlador.servicio.ServicioDAO;
import dgtic.core.modelo.entidades.autobus.Autobus;
import dgtic.core.modelo.entidades.empleado.Empleado;
import dgtic.core.modelo.entidades.viaje.Viaje;

public class Inicio_Beans {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ServicioDAO.class);
        ServicioDAO csv = context.getBean(ServicioDAO.class);
        BaseDeDatosDAO bd = csv.getServicioDAO();
        System.out.println("Acceso mediante la Base de Datos:");
        System.out.println(bd.getDestinos());
        System.out.println("------------------------");

        System.out.println("\nAcceso mediante archivo CSV:");
        System.out.println(csv.archivoCSVAutobuses());
        System.out.println("-------------------------");
        System.out.println(csv.archivoCSVEmpleados());
        System.out.println("-------------------------");
        System.out.println(csv.archivoCSVDestinos());
        System.out.println("-------------------------");

        Empleado empleado = (Empleado) context.getBean("empleado");
        System.out.println(empleado);

        Viaje viajeCorto = (Viaje) context.getBean("viajeCorto");
        System.out.println(viajeCorto);

        Viaje viajeLargo = (Viaje) context.getBean("viajeLargo");
        System.out.println(viajeLargo);

        Autobus autobus = (Autobus) context.getBean("bus");
        System.out.println(autobus);

        context.close();
    }

}
