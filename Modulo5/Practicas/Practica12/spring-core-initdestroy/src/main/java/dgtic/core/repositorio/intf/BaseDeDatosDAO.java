package dgtic.core.repositorio.intf;

import java.util.*;

import dgtic.core.modelo.*;

public interface BaseDeDatosDAO {
    public List<Estudiante> getEstudiantes(String carrera);

    public Estudiante getEstudiante(String carrera, String matricula);
}
