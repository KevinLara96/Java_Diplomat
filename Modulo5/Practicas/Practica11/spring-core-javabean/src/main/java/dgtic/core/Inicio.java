package dgtic.core;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dgtic.core.modelo.Estudiante;
import dgtic.core.modelo.Materia;
import dgtic.core.servicio.ConfiguracionServicio;

public class Inicio {
    public static void main(String[] args) {
        ConfigurableApplicationContext contexto = new AnnotationConfigApplicationContext(ConfiguracionServicio.class);
        Estudiante estudiante = (Estudiante) contexto.getBean("estudiante", Estudiante.class);
        Estudiante estudianteDos = (Estudiante) contexto.getBean("estudiante", Estudiante.class);
        System.out.println(estudiante.toString());
        System.out.println(estudianteDos.toString());
        // cambiar propiedad a estudianteDos
        estudianteDos.setNombre("Martha");
        System.out.println("-------");
        System.out.println(estudiante.toString());
        System.out.println(estudianteDos.toString());
        System.out.println("-------");
        Materia materia = (Materia) contexto.getBean("materia");
        Materia materiaDos = (Materia) contexto.getBean("materiaDos");
        System.out.println(materia.toString());
        System.out.println(materiaDos.toString());
        contexto.close();
    }
}