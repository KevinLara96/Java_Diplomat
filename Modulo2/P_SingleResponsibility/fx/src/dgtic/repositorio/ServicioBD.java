package dgtic.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dgtic.modelo.*;

public class ServicioBD {

    public static List<Alumno> consulta() {
        String materias[] = { "Cálculo", "Álgebra", "Programación", "Lógica", "POO" };
        String nombres[] = { "María", "Pedro", "José", "Martha", "Luis", "Juan", "Samuel" };
        List<Alumno> lista = new ArrayList<>();
        Random random = new Random();

        Alumno alumno = null;
        for (int i = 0; i < nombres.length - 1; i++) {
            alumno = new Alumno();
            alumno.setNombre(nombres[i]);
            for (int j = 0; j < materias.length - 1; j++) {
                alumno.getMaterias().add(new Materia(materias[j], random.nextInt(10)));
            }
            lista.add(alumno);
        }

        return lista;
    }
}
