package dgtic.servicio;

import java.util.List;
import java.util.stream.Collectors;

import dgtic.modelo.*;

public class Exportaciones {
    public String exportarCSV(List<Materia> materias) {
        return materias.stream().map(
                m -> m.getNombre() + "," + m.getCalificacion()).collect(Collectors.joining("\n"));
    }
}
