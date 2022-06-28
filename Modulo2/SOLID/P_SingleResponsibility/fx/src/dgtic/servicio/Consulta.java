package dgtic.servicio;

import java.util.ArrayList;
import java.util.List;

import dgtic.modelo.Alumno;
import dgtic.modelo.Materia;
import static java.util.stream.Collectors.toList;

public class Consulta {
    public List<Materia> buscarCalificaciones(Alumno alumno) {
        List<Materia> materias = new ArrayList<>();
        materias = (List<Materia>) alumno.getMaterias().stream().filter(mat -> (mat.getCalificacion() >= 5))
                .collect(toList());

        return materias;
    }
}
