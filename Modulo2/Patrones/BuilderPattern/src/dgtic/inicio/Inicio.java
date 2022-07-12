package dgtic.inicio;

import dgtic.modelo.Departamento;
import dgtic.modelo.Materias;
import dgtic.modelo.Profesor;
import dgtic.modelo.Tipo;

public class Inicio {
    public static void main(String[] args) {
        Profesor profesorBase = new Profesor.Builder("Juan").setTipoBase(Tipo.BASE)
                .setDepartamento(Departamento.COMPUTACION).build();

        System.out.print(profesorBase);

        Profesor profesorAsignatura = new Profesor.Builder("Carlos").setTipoAsignatura(Tipo.ASIGNATURA)
                .setMaterias(Materias.ALGEBRA, Materias.CALCULO).build();

        System.out.println(profesorAsignatura);
    }
}
