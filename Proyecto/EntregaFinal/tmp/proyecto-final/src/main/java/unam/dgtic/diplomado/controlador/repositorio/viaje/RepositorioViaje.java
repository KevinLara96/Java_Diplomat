package unam.dgtic.diplomado.controlador.repositorio.viaje;

import unam.dgtic.diplomado.modelo.entidades.viaje.ViajeEntity;

public interface RepositorioViaje {

    public Iterable<ViajeEntity> obtenerViajes();

    public ViajeEntity obtenerViaje(Integer idViaje);

    public void guardarViaje(ViajeEntity viaje) throws Exception;

    public void eliminarViaje(Integer idViaje);

    public void actualizarViaje(ViajeEntity viajeParam);
}
