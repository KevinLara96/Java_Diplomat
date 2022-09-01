package dgtic.core.vista.inicio;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dgtic.core.baseDatos.intf.BaseDeDatosDAO;
import dgtic.core.controlador.servicio.ServicioDAO;

public class Inicio_v2 {
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

        context.close();
    }

}
