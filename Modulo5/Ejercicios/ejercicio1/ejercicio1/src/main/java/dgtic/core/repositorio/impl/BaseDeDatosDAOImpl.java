package dgtic.core.repositorio.impl;

import java.util.*;

import org.springframework.stereotype.Component;

import dgtic.core.modelo.Autor;
import dgtic.core.repositorio.BaseDeDatos;
import dgtic.core.repositorio.intf.BaseDeDatosDAO;

@Component("BaseDeDatosDAOImpl")
public class BaseDeDatosDAOImpl implements BaseDeDatosDAO {

    @Override
    public Set<Autor> getAutores(String titulo) {

        return BaseDeDatos.libros.get(titulo).getAutores();
    }

    @Override
    public Set<String> getLibros() {
        return BaseDeDatos.libros.keySet();
    }

}
