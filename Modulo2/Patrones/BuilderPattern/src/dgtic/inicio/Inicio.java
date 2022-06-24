package dgtic.inicio;

import dgtic.modelo.Departamento;
import dgtic.modelo.Materias;
import dgtic.modelo.Profesor;
import dgtic.modelo.Tipo;

public class Inicio {
    public static void main(String[] args) {
        Profesor profesor = new Profesor.Builder("Juan").setTipoBase(Tipo.BASE)
                .setDepartamento(Departamento.COMPUTACION).build();

        System.out.println(profesor);

        Profesor pr = new Profesor.Builder("Carlos").setTipoAsignatura(Tipo.ASIGNATURA)
                .setMaterias(Materias.ALGEBRA, Materias.CALCULO).build();

        System.out.println(pr);
    }
}
