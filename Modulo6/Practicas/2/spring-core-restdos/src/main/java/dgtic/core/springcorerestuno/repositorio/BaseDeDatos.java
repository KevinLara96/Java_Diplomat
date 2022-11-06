package dgtic.core.springcorerestuno.repositorio;

import java.util.ArrayList;
import java.util.List;

import dgtic.core.springcorerestuno.modelo.Materia;
import dgtic.core.springcorerestuno.modelo.Estudiante;

public class BaseDeDatos {

    public static List<Estudiante> estudiante = new ArrayList<>();

    static {
        Estudiante est = new Estudiante("A1", "Rosa", "19", new Materia(1, "Lógica", 10),
                new Materia(1, "Programación", 9));

        estudiante.add(est);

        est = new Estudiante("A2", "Mario", "18", new Materia(1, "Lógica", 10),
                new Materia(1, "Programación", 9),
                new Materia(3, "Álgebra", 9));
        estudiante.add(est);

        est = new Estudiante("A3", "Rebeca", "22", new Materia(1, "Lógica", 10),
                new Materia(3, "Álgebra", 9));
        estudiante.add(est);
    }
}
