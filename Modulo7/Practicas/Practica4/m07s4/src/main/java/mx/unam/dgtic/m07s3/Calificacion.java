package mx.unam.dgtic.m07s3;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Calificaciones")
public class Calificacion {

    @Id
    private int id;
    private String materia;
    private int calificacion;

    @ManyToOne
    @JoinColumn(name = "alumnos_matricula")
    private Alumno alumno;

    public Calificacion() {
        super();
    }

    public Calificacion(String materia) {
        super();
        this.materia = materia;
    }

    public Calificacion(int calificacion) {
        super();
        this.calificacion = calificacion;
    }

    public Calificacion(String materia, int calificacion) {
        super();
        this.materia = materia;
        this.calificacion = calificacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Calificacion [id=" + id + ", materia=" + materia + ", calificacion=" + calificacion + ", alumno="
                + alumno + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Calificacion other = (Calificacion) obj;
        if (id != other.id)
            return false;
        return true;
    }

}