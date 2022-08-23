package dgtic.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import dgtic.core.modelo.Empleado;
import dgtic.core.servicio.Servicio;

public class Inicio {
    public static void main(String[] args) {
        ApplicationContext contexto = new ClassPathXmlApplicationContext(
                new String[] { "/dgtic/core/xml/bean-configuration.xml", "/dgtic/core/xml/bean-services.xml" });
        Empleado emp = (Empleado) contexto.getBean("empleado");
        System.out.println("+++++");
        Servicio serv = (Servicio) contexto.getBean("servicio");
        ((ClassPathXmlApplicationContext) contexto).close();
    }
}