package mx.unam.diplomado.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import mx.unam.diplomado.modelo.viaje.Viaje;

public interface ViajeRepositorio extends CrudRepository<Viaje, Integer> {

    // Id.
    Optional<Viaje> findByIdViaje(Integer idViaje);

    List<Viaje> findAllByIdViaje(Integer idViaje);

    // Origen.
    List<Viaje> getByOrigen(String origen);

    long countByOrigen(String origen);

    boolean existsByOrigen(String origen);

    // Destino.
    List<Viaje> getByDestino(String destino);

    long countByDestino(String destino);

    boolean existsByDestino(String destino);

    // fecha.
    List<Viaje> getByFecha(String fecha);

    long countByFecha(String fecha);

    boolean existsByFecha(String fecha);

    // Precio.
    List<Viaje> getByPrecio(Double precio);

    long countByPrecio(Double precio);

    boolean existsByPrecio(Double precio);

    // Consultas derivadas Origen y destino.
    List<Viaje> getByOrigenAndDestino(String origen, String destino);

    // Consultas derivadas precio.
    public List<Viaje> findByPrecioLessThan(Double precio);

    public List<Viaje> findByPrecioLessThanEqual(Double precio);

    public List<Viaje> findByPrecioGreaterThan(Double precio);

    public List<Viaje> findByPrecioGreaterThanEqual(Double precio);

    public List<Viaje> findByPrecioBetween(Double precioIni, Double precioFin);

    /*
     * Persistencia.
     */
    @Transactional
    void deleteByIdViaje(Integer idViaje);

    @Transactional
    void deleteByOrigenAndDestino(String origen, String destino);

    /*
     * Named Queries
     */
    List<Viaje> buscarTodos();
}
