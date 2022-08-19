package dgtic.inicio;

import dgtic.modelo.CalificaExamenes;
import dgtic.modelo.ExplicarClases;
import dgtic.modelo.Profesor;
import dgtic.modelo.Reportes;
import dgtic.modelo.Responsabilidades;

public class MetodoTres {
    public static void main(String[] args) {
        Profesor profesor = new Profesor();
        profesor.setNombre("nombre");

        ExplicarClases exp = new ExplicarClases();
        CalificaExamenes cal = new CalificaExamenes();
        Reportes reportes = new Reportes();

        profesor.getResponsabilidad().add(exp);
        profesor.getResponsabilidad().add(cal);
        profesor.getResponsabilidad().add(reportes);

        System.out.println(profesor.getNombre());
        for (Responsabilidades resp : profesor.getResponsabilidad()) {
            System.out.println("--");
            resp.realizar();
        }
    }
}
