package mx.unam.dgtic.m07s3;

public class AlumnoCalificacionDTO {
    private String nombre;
    private String paterno;
    private String materia;
    private int calificacion;

    public AlumnoCalificacionDTO() {
    }

    public AlumnoCalificacionDTO(String nombre, String paterno, String materia, int calificacion) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materia = materia;
        this.calificacion = calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
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
        return "AlumnoCalificacionDTO [calificacion=" + calificacion + ", materia=" + materia + ", nombre=" + nombre
                + ", paterno=" + paterno + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + calificacion;
        result = prime * result + ((materia == null) ? 0 : materia.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((paterno == null) ? 0 : paterno.hashCode());
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
        AlumnoCalificacionDTO other = (AlumnoCalificacionDTO) obj;
        if (calificacion != other.calificacion)
            return false;
        if (materia == null) {
            if (other.materia != null)
                return false;
        } else if (!materia.equals(other.materia))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (paterno == null) {
            if (other.paterno != null)
                return false;
        } else if (!paterno.equals(other.paterno))
            return false;
        return true;
    }

}
