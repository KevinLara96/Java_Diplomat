package unam.dgtic.diplomado.m1100base.modelo;

import java.util.Collection;
import java.util.Date;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import unam.dgtic.diplomado.m1100base.dominio.Alumno;

public class AlumnoService {

    protected EntityManager em;

    public AlumnoService(EntityManager em) {
        super();
        this.em = em;
    }

    public Alumno findAlumno(String matricula) {

        return em.find(Alumno.class, matricula);
    }

    @SuppressWarnings("unchecked")
    public Collection<Alumno> findAllAlumnos() {
        Query query = em.createQuery("SELECT a from Alumno a");

        return (Collection<Alumno>) query.getResultList();
    }

    public Alumno createAlumno(String matricula, String nombre,
            String paterno, Date fnac, Double estatura) {
        Alumno alumno = new Alumno(matricula);
        alumno.setNombre(nombre);
        alumno.setPaterno(paterno);
        alumno.setFnac(fnac);
        alumno.setEstatura(estatura);

        em.persist(alumno);

        return alumno;
    }

    public void removeAlumno(String matricula) {

        Alumno alumno = findAlumno(matricula);
        if (alumno != null) {
            em.remove(alumno);
        }
    }

    public Alumno raiseAlumnoEstatura(String matricula, Long raise) {

        Alumno alumno = findAlumno(matricula);
        if (alumno != null) {
            alumno.setEstatura(alumno.getEstatura() + raise);
        }

        return alumno;
    }
}
