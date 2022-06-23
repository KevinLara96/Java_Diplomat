package dgtic.repositorio.implementacion;

import dgtic.repositorio.interfaces.RepositorioAbstractFactory;
import dgtic.repositorio.interfaces.RepositorioMaterias;
import dgtic.repositorio.interfaces.RepositorioProfesores;

public class FactoryProfesores implements RepositorioAbstractFactory {

    @Override
    public RepositorioProfesores crearRepositorioProfesores() {
        return new RepositorioProfesorRelacional();
    }

    @Override
    public RepositorioMaterias crearRepositorioMaterias() {
        return new RepositorioMateriasRelacional()};
}

}
