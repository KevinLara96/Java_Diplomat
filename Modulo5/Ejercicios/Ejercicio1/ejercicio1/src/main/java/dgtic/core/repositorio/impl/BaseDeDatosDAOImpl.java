package dgtic.core.repositorio.impl;

import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import dgtic.core.modelo.Autor;
import dgtic.core.modelo.Libro;
import dgtic.core.repositorio.BaseDeDatos;
import dgtic.core.repositorio.intf.BaseDeDatosDAO;

@Component("BaseDeDatosDAOImpl")
public class BaseDeDatosDAOImpl implements BaseDeDatosDAO {

    @Override
    public Set<Autor> getAutores(Libro libro) {

        return BaseDeDatos.libros.get(libro);
    }

    @Override
    public Map<Libro, Set<Autor>> getLibros() {
        return BaseDeDatos.libros;
    }

}
