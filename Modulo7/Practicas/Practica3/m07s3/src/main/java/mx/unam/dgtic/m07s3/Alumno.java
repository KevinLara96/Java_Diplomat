package mx.unam.dgtic.m07s3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQuery(name = "Alumno.buscarAltos", query = "Select a from Alumno a where a.estatura > 1.70")
// Siempre debemos referirnos a las proiedades de la clase, no los campos de
// la BD.

@NamedQuery(name = "Alumno.buscarAltosConFecha", query = "Select a from Alumno a where a.estatura > 1.70 and a.fnac > :fecha")

@NamedQuery(name = "Alumno.buscarPorNombre", query = "Select a from Alumno a where a.nombre = ?1")

@NamedQuery(name = "Alumno.buscarPorNombreYPaterno", query = "Select a from Alumno a where a.nombre = ?1 and a.paterno = ?2")

@NamedNativeQuery(name = "Alumno.buscarAltosMayorPromedio", query = "select * from Alumnos where estatura > " +
        "(select avg(estatura) from Alumnos", resultClass = Alumno.class)

@NamedQuery(name = "Alumno.buscarTodosConCalificaciones", query = "select distinct a from Alumno a JOIN FETCH a.calificaciones")

@Entity
@Table(name = "Alumnos")
public class Alumno {

    @Id
    private String matricula;
    private String nombre;
    private String paterno;
    private Date fnac;
    private double estatura;
    @OneToMany(mappedBy = "alumno")
    private List<Calificacion> calificaciones = new ArrayList<>();

    public Alumno() {
        super();
    }

    public Alumno(String matricula, String nombre, String paterno, Date fnac, double estatura) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.paterno = paterno;
        this.fnac = fnac;
        this.estatura = estatura;
    }

    public Alumno(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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

    public Date getFnac() {
        return fnac;
    }

    public void setFnac(Date fnac) {
        this.fnac = fnac;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }

    @Override
    public String toString() {
        return "Alumno [estatura=" + estatura + ", fnac=" + fnac + ", matricula=" + matricula + ", nombre=" + nombre
                + ", paterno=" + paterno + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
        Alumno other = (Alumno) obj;
        if (matricula == null) {
            if (other.matricula != null)
                return false;
        } else if (!matricula.equals(other.matricula))
            return false;
        return true;
    }

}
