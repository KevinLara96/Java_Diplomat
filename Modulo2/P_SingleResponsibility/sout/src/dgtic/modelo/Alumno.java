package dgtic.modelo;

import java.util.ArrayList;

import dgtic.modelo.Materia;

public class Alumno {
    private String nombre;
    private ArrayList<Materia> materias = new ArrayList<>();

    public Alumno() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<Materia> materias) {
        this.materias = materias;
    }

    @Override
    public String toString() {
        return "Alumno [Nombre=" + nombre +
                " / materias=" + materias;
    }
}