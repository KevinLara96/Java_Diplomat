package dgtic.core;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import dgtic.core.modelo.Estudiante;
import dgtic.core.repositorio.intf.BaseDeDatosDAO;
import dgtic.core.repositorio.impl.BaseDeDatosDAOImpl;

public class Inicio {
    public static void main(String[] args) {
        ConfigurableApplicationContext contexto = new AnnotationConfigApplicationContext(BaseDeDatosDAOImpl.class);
        BaseDeDatosDAO serv = (BaseDeDatosDAO) contexto.getBean("baseDeDatosDAO");
        System.out.println(serv.getEstudiantes("ico"));
        System.out.println("------");
        Estudiante est = serv.getEstudiante("ime", "126");
        System.out.println(est);
        contexto.close();
    }
}