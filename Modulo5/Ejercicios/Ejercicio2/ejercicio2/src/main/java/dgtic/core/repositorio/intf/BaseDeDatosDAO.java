package dgtic.core.repositorio.intf;

import java.util.Set;

import dgtic.core.modelo.Autor;
import dgtic.core.modelo.Libro;

public interface BaseDeDatosDAO {
    public Set<Autor> getAutores(String titulo);

    public Set<String> getLibrosStr();

    public Set<Libro> getLibros();
}
