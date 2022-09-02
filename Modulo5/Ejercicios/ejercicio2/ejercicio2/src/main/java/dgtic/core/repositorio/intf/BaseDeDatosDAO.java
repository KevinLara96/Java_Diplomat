package dgtic.core.repositorio.intf;

import java.util.Set;

import dgtic.core.modelo.Autor;

public interface BaseDeDatosDAO {
    public Set<Autor> getAutores(String titulo);

    public Set<String> getLibros();
}
