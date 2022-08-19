package dgtic.core;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import dgtic.core.modelo.Persona;

public class Inicio {
    public static void main(String[] args) {
        Resource rec = new ClassPathResource("/dgtic/core/xml/bean-configuration.xml");
        BeanFactory fac = new XmlBeanFactory(rec);
        Persona persona = (Persona) fac.getBean("persona");
        System.out.println(persona);
        System.out.println(fac.isSingleton("persona"));
        System.out.println(fac.getBean("persona") instanceof Persona);
        System.out.println(fac.isTypeMatch("persona", persona.getClass()));
        System.out.println(fac.getAliases("persona").length > 0);
    }
}
