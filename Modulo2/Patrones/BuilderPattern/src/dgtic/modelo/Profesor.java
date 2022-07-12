package dgtic.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Profesor {
    private String nombre;
    private Tipo tipo;
    private List<Departamento> departamento = new ArrayList<>();
    private List<Materias> materias = new ArrayList<>();

    private Profesor(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Profesor [departamento=" + departamento + ", materias=" + materias + ", nombre=" + nombre + ", tipo="
                + tipo + "]";
    }

    // Clases internas.
    public static class Builder {
        private Profesor profesor;

        public Builder(String nombre) {
            profesor = new Profesor(nombre);
			System.out.print("AAA" + profesor); 
        }

        public BuildBase setTipoBase(Tipo tipo) {
            profesor.tipo = tipo;
            return new Profesor.BuildBase(profesor);
        }

        public BuildAsignatura setTipoAsignatura(Tipo tipo) {
            profesor.tipo = tipo;
            return new Profesor.BuildAsignatura(profesor);
        }
    }

    public static class BuildBase {
        private Profesor profesor;

        private BuildBase(Profesor profesor) {
            this.profesor = profesor;
        }

        public BuildBase setDepartamento(Departamento... departamentos) {
            this.profesor.departamento = Arrays.asList(departamentos);
            return this;
        }

        public Profesor build() {
            return profesor;
        }
    }

    public static class BuildAsignatura {
        private Profesor profesor;

        private BuildAsignatura(Profesor profesor) {
            this.profesor = profesor;
        }

        public BuildAsignatura setMaterias(Materias... materias) {
            this.profesor.materias = Arrays.asList(materias);
            return this;
        }

        public Profesor build() {
            return profesor;
        }
    }
}
