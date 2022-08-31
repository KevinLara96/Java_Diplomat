package dgtic.core;

import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import dgtic.core.modelo.Empleado;

public class Inicio {
    public static void main(String[] args) {
        ApplicationContext contexto = null;
        try {
            contexto = new ClassPathXmlApplicationContext(new String[] { "/dgtic/core/xml/bean-configuration.xml" });
            Empleado emp = (Empleado) contexto.getBean("empleado");
            System.out.println(emp.toString());
            if (emp.getUno() != null) {
                emp.getUno().realiza();
            } else {
                System.out.println(emp.getUno());
            }
            System.out.println("-----");
        } catch (UnsatisfiedDependencyException ex) {
            System.out.println("No se pueden crear los beans");
        }
        if (contexto != null) {
            ((ClassPathXmlApplicationContext) contexto).close();
        }
    }
}