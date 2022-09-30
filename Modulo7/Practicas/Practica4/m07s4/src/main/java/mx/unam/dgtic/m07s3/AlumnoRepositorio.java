package mx.unam.dgtic.m07s3;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AlumnoRepositorio extends PagingAndSortingRepository<Alumno, String> {// Clase y el tipo de la llave
                                                                                       // primaria

    // Consultas derivadas.
    // Búsquedas.

    // findByNombre(String nombre)
    // getByNombre(String nombre)
    // searchByNombre(String nombre)
    // streamByNOmbre (String nombre)
    // readByNombre(String nombre)
    // queryByNombre (String nombre)

    public List<Alumno> getByNombre(String nombre);

    public List<Alumno> getByNombreNot(String nombre);

    public long countByNombre(String nombre);

    public long countByNombreNot(String nombre);

    public List<Alumno> searchByPaterno(String nombre);

    public List<Alumno> streamByEstatura(double estatura);

    public List<Alumno> getByFnac(Date fecha);

    public List<Alumno> getByNombreAndPaterno(String nombre, String paterno);

    public List<Alumno> getByNombreOrPaterno(String nombre, String paterno);

    public List<Alumno> readByNombreAndPaternoOrEstatura(String nombre, String paterno, double estatura);

    public long countByNombreAndPaterno(String nombre, String paterno);

    public long countByNombreOrPaterno(String nombre, String paterno);

    public long countByNombreAndPaternoOrEstatura(String nombre, String paterno, double estatura);

    public List<Alumno> findAlumnoDistinctByNombre(String nombre);

    public List<Alumno> findTop2ByEstatura(double estatura);

    public List<Alumno> findByNombreOrderByPaterno(String nombre);

    public List<Alumno> findByNombreOrderByPaternoDesc(String nombre);

    public List<Alumno> findFirstByOrderByEstatura();

    public List<Alumno> findTopByOrderByEstaturaDesc();

    public boolean existsByNombre(String nombre);

    public boolean existsByNombreAndPaterno(String nombre, String paterno);

    public List<Alumno> findByPaternoIsNull();

    public List<Alumno> findByPaternoIsNotNull();

    public List<Alumno> findByPaternoStartingWith(String prefijo);

    public List<Alumno> findByPaternoEndingWith(String sufijo);

    public List<Alumno> findByPaternoContaining(String contiene);

    public List<Alumno> findByNombreContaining(String contiene);

    public List<Alumno> findByPaternoLike(String contiene);

    public List<Alumno> findByPaternoNotLike(String contiene);

    public List<Alumno> findByEstaturaLessThan(double estatura);

    public List<Alumno> findByEstaturaLessThanEqual(double estatura);

    public List<Alumno> findByEstaturaGreaterThan(double estatura);

    public List<Alumno> findByEstaturaGreaterThanEqual(double estatura);

    public List<Alumno> findByEstaturaGreaterThanAndPaternoLike(double estatura, String patron);

    public List<Alumno> findByEstaturaBetween(double estaturaIni, double estaturaFin);

    public List<Alumno> findByEstaturaIn(Collection<Double> estaturas);

    public List<Alumno> findByEstaturaNotIn(Collection<Double> estaturas);

    public List<Alumno> findByNombreIn(Collection<String> nombres);

    public List<Alumno> findByNombreNotIn(Collection<String> nombres);

    public List<Alumno> findByFnacAfter(Date fecha);

    public List<Alumno> findByFnacBefore(Date fecha);

    @Transactional
    public List<Alumno> deleteByNombre(String nombre);
    // public List<Alumno> removeByNombre(String nombre);

    public List<Alumno> findByMatriculaLike(String patron);

    public List<Alumno> findByMatriculaIn(Collection<String> matriculas);

    public List<Alumno> findByMatriculaNotIn(Collection<String> matriculas);

    @Transactional
    public List<Alumno> deleteByMatricula(String matricula);

    public boolean existsByMatricula(String matricula);

    @Transactional
    public List<Alumno> deleteByEstatura(double estatura);

    public boolean existsByEstatura(double estatura);

    /* Named queries. */
    public List<Alumno> buscarAltos(); // Debe llamarse igual que en la anotación del POJO.

    public List<Alumno> buscarAltosConFecha(Date fecha); // fecha, ya que se están usando placeholders.

    public List<Alumno> buscarPorNombre(String nombre);

    public List<Alumno> buscarPorNombreYPaterno(String nombre, String paterno);

    /* Named Native Query */
    public List<Alumno> buscarAltosMayorPromedio();

    // Query en repositorio usando JPQL.
    @Query("select avg(a.estatura) from Alumno a")
    public double buscarEstaturaPromedioAlumnos();

    // Query en repositorio usando SQL.
    @Query(value = "select distinct a.* from Alumnos a\n" +
            "join Calificaciones c on  (a.matricula = c.alumnos_matricula)\n" +
            "order by nombre", nativeQuery = true)
    public List<Alumno> buscarAlumnoConCalificacion();

    @Query(value = "select * from Alumnos a " +
            "where nombre = ? and paterno = ? " +
            "order by nombre, paterno", nativeQuery = true)
    public List<Alumno> buscarPorNombreYPaternoNative(String nombre, String paterno);

    // Join Fetch.
    public List<Alumno> buscarTodosConCalificaciones();

    // DTO.
    @Query(value = "select distinct new mx.unam.dgtic.m07s3.AlumnoCalificacionDTO(" +
            "a.nombre, a.paterno, c.materia, c.calificacion) " +
            "from Alumno a, Calificacion c " +
            "where a.matricula = c.alumno")
    public List<AlumnoCalificacionDTO> findAlumnoCalificacionDTO();
}
