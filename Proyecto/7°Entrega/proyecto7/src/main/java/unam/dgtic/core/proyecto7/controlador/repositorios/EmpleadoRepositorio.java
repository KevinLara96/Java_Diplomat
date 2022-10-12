package unam.dgtic.core.proyecto7.controlador.repositorios;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import unam.dgtic.core.proyecto7.modelo.empleado.Empleado;

public interface EmpleadoRepositorio extends CrudRepository<Empleado, Integer> {

    // Id.
    Optional<Empleado> findByIdEmpleado(Integer idEmpleado);

    List<Empleado> findAllByIdEmpleado(Integer idEmpleado);

    // Nombre.
    List<Empleado> getByNombre(String nombre);

    long countByNombre(String nombre);

    boolean existsByNombre(String nombre);

    // Correo.
    List<Empleado> getByCorreo(String correo);

    long countByCorreo(String correo);

    boolean existsByCorreo(String correo);

    // RFC.
    List<Empleado> getByRfc(String rfc);

    long countByRfc(String rfc);

    boolean existsByRfc(String rfc);

    // Salario.
    List<Empleado> getBySalario(Double salario);

    long countBySalario(Double salario);

    boolean existsBySalario(Double salario);

    // Consultas derivadas Nombre y correo.
    List<Empleado> getByNombreAndCorreo(String nombre, String correo);

    public List<Empleado> findByNombreStartingWith(String prefijo);

    public List<Empleado> findByNombreEndingWith(String sufijo);

    public List<Empleado> findByNombreContaining(String contiene);

    public List<Empleado> findByCorreoStartingWith(String prefijo);

    public List<Empleado> findByCorreoEndingWith(String sufijo);

    public List<Empleado> findByCorreoContaining(String contiene);

    // Consultas derivadas RFC.
    public List<Empleado> findByRfcStartingWith(String prefijo);

    public List<Empleado> findByRfcEndingWith(String sufijo);

    public List<Empleado> findByRfcContaining(String contiene);

    // Consultas derivadas salario.
    public List<Empleado> findBySalarioLessThan(Double salario);

    public List<Empleado> findBySalarioLessThanEqual(Double salario);

    public List<Empleado> findBySalarioGreaterThan(Double salario);

    public List<Empleado> findBySalarioGreaterThanEqual(Double salario);

    public List<Empleado> findBySalarioBetween(Double salarioIni, Double salarioFin);

    /*
     * Persistencia.
     */
    @Transactional
    public void deleteByIdEmpleado(Integer idEmpleado);

    @Transactional
    public void deleteByNombre(String nombre);

    @Transactional
    public void deleteByRfc(String rfc);

    /*
     * Named queries.
     */
    List<Empleado> buscarTodos();
}
