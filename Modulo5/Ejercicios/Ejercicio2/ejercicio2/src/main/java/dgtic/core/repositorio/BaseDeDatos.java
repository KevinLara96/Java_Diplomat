package dgtic.core.repositorio;

import java.util.*;

import dgtic.core.modelo.Autor;
import dgtic.core.modelo.Libro;

public class BaseDeDatos {

    public static Map<String, Libro> libros = new HashMap<>();

    static {
        Set<Autor> autores = new HashSet<>();
        Autor autor;
        Libro libro;

        autor = new Autor("Dennis G. Zill", "50");
        autores.add(autor);
        autor = new Autor("Michael R. Cullen", "60");
        autores.add(autor);
        autor = new Autor("Warren S. Wright", "45");
        autores.add(autor);
        libro = new Libro("Matemáticas Avanzadas para Ingeniería", "1234", "Cengage Learning", autores);
        libros.put(libro.getTitulo(), libro);

        autores = new HashSet<>();
        autor = new Autor("Paul Deitel", "45");
        autores.add(autor);
        autor = new Autor("Harvey Deitel", "55");
        autores.add(autor);
        libro = new Libro("Cómo programar en Java", "2345", "Pearson", autores);
        libros.put(libro.getTitulo(), libro);

        autores = new HashSet<>();
        autor = new Autor("Biran Kernighan", "39");
        autores.add(autor);
        autor = new Autor("Dennis Ritchie", "45");
        autores.add(autor);
        libro = new Libro("The C Programming Language", "3456", "Pearson", autores);
        libros.put(libro.getTitulo(), libro);

        autores = new HashSet<>();
        autor = new Autor("Alfredo Moreno Muñoz", "39");
        autores.add(autor);
        autor = new Autor("Sheila Córcoles Córcoles", "38");
        autores.add(autor);
        libro = new Libro("Aprende Python en un fin de semana", "4567", "Pearson", autores);
        libros.put(libro.getTitulo(), libro);

        autores = new HashSet<>();
        autor = new Autor("Juan Pablo Cardona", "50");
        autores.add(autor);
        autor = new Autor("John Jairo Leal", "53");
        autores.add(autor);
        autor = new Autor("Juan Camilo Vásquez", "49");
        autores.add(autor);
        libro = new Libro("Cálculo Integral. Técnicas de Integración", "5678", "Ediciones de la U", autores);
        libros.put(libro.getTitulo(), libro);

    }
}