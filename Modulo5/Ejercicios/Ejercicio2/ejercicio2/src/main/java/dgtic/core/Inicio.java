package dgtic.core;

import java.util.Set;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dgtic.core.modelo.Autor;
import dgtic.core.modelo.Libro;
import dgtic.core.repositorio.intf.BaseDeDatosDAO;
import dgtic.core.servicio.ServicioDAO;

public class Inicio {
    public static void main(String[] args) {
        ConfigurableApplicationContext contexto = new AnnotationConfigApplicationContext(ServicioDAO.class);
        ServicioDAO csv = contexto.getBean(ServicioDAO.class);
        BaseDeDatosDAO serv = csv.getServicioDAO();

        System.out.println(serv.getLibros());
        System.out.println(csv.archivoCSV("Cómo programar en Java"));

        Autor autorDefault = (Autor) contexto.getBean("AutorDefault");
        System.out.println(autorDefault);
        Libro libroDefault = (Libro) contexto.getBean("LibroDefault");
        System.out.println(libroDefault);
        Libro libro = (Libro) contexto.getBean("DivinaComedia");
        System.out.println(libro);

        Set<String> tmp = serv.getLibrosStr();
        for (String titulo : tmp) {
            System.out.println(titulo);
            System.out.println(titulo.equals("Cómo programar en Java"));
        }

        contexto.close();
    }
}