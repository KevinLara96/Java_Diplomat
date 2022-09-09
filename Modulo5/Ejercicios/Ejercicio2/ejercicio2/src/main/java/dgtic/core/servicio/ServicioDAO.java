package dgtic.core.servicio;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import dgtic.core.modelo.Autor;
import dgtic.core.modelo.Libro;
import dgtic.core.repositorio.intf.BaseDeDatosDAO;

@Component
@ComponentScan(basePackages = "dgtic.core")
public class ServicioDAO {
    @Autowired
    @Qualifier("BaseDeDatosDAOImpl")
    private BaseDeDatosDAO servicioDAO;

    @Autowired
    public ServicioDAO(BaseDeDatosDAO servicioDAO) {
        this.servicioDAO = servicioDAO;
    }

    public void setServicioDAO(BaseDeDatosDAO servicioDAO) {
        this.servicioDAO = servicioDAO;
    }

    public BaseDeDatosDAO getServicioDAO() {
        return servicioDAO;
    }

    public String archivoCSV(String titulo) {
        StringBuilder str = new StringBuilder("");
        str.append(titulo).append(": ");
        for (Autor autor : servicioDAO.getAutores(titulo)) {
            str.append(autor.getNombre());
            str.append(";");
        }

        return str.toString();
    }

    public String archivoCSV() {
        StringBuilder str = new StringBuilder("");
        for (String libro : servicioDAO.getLibrosStr()) {
            str.append("Título: ").append(libro).append("\n");
        }

        return str.toString();
    }

    @Bean(name = "LibroDefault")
    @Scope("singleton")
    public Libro servicioLibro() {
        Libro libro = new Libro();
        Set<Autor> autores = new HashSet<>();
        autores.add(new Autor("Sin nombre", "0"));
        libro.setAutores(autores);
        libro.setTitulo("Sin título.");
        libro.setEditorial("Sin editorial.");
        libro.setIsbn("0");

        return libro;
    }

    @Bean(name = "AutorDefault")
    @Scope("prototype")
    public Autor servicioAutor() {
        Autor autor = new Autor();
        autor.setNombres("Sin nombre");
        autor.setEdad("0");

        return autor;
    }

    @Bean(name = "DivinaComedia")
    @Scope("singleton")
    public Libro divinaComedia() {
        Libro libro = new Libro();
        Set<Autor> autores = new HashSet<>();
        autores.add(new Autor("Dante Alighieri", "N.A"));
        libro.setTitulo("La Divina Comedia");
        libro.setAutores(autores);
        libro.setEditorial("N.A");
        libro.setIsbn("N.A");

        return libro;
    }
}
