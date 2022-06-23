package dgtic.repositorio.implementacion;

import dgtic.repositorio.interfaces.RepositorioAbstractFactory;
import dgtic.repositorio.interfaces.RepositorioMaterias;
import dgtic.repositorio.interfaces.RepositorioProfesores;

public class FactoryNoSQL implements RepositorioAbstractFactory {

    @Override
    public RepositorioProfesores crearRepositorioProfesores() {
        return new RepositorioProfesorNoSQL();
    }

    @Override
    public RepositorioMaterias crearRepositorioMaterias() {
        return new RepositorioMateriasNoSQL() {

        };
    }

}
