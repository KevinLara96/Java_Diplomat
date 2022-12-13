package unam.dgtic.diplomado.controlador.repositorio.viaje;

import unam.dgtic.diplomado.modelo.entidades.viaje.Viaje;

public interface RepositorioViaje {

    public Iterable<Viaje> obtenerViajes();

    public Viaje obtenerViaje(Integer idViaje);

    public void crearViaje(Viaje agenciaNueva) throws Exception;

    public void eliminarViaje();
}
