package dgtic.core.repositorio.intf;

import java.util.Map;
import java.util.Set;

import dgtic.core.modelo.Autor;
import dgtic.core.modelo.Libro;

public interface BaseDeDatosDAO {
    public Set<Autor> getAutores(Libro libro);

    public Map<Libro, Set<Autor>> getLibros();
}
