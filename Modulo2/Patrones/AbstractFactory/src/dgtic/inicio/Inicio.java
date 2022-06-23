package dgtic.inicio;

import dgtic.repositorio.implementacion.FactoryNoSQL;
import dgtic.repositorio.implementacion.FactoryRelacional;
import dgtic.repositorio.interfaces.RepositorioAbstractFactory;
import dgtic.repositorio.interfaces.RepositorioMaterias;
import dgtic.repositorio.interfaces.RepositorioProfesores;

public class Inicio {
    public static void main(String[] args) {
        RepositorioAbstractFactory factory = new FactoryRelacional();
        RepositorioProfesores rep = factory.crearRepositorioProfesores();
        rep.listaProfesores();

        RepositorioAbstractFactory factoryDos = new FactoryNoSQL();
        RepositorioMaterias repDos = factoryDos.crearRepositorioMaterias();
        repDos.listaMaterias();
    }
}
