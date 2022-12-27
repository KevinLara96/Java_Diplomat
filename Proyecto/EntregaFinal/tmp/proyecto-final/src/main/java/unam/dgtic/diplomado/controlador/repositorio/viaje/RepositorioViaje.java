package unam.dgtic.diplomado.controlador.repositorio.viaje;

import unam.dgtic.diplomado.modelo.entidades.viaje.ViajeEntity;

public interface RepositorioViaje {

    public Iterable<ViajeEntity> obtenerViajes();

    public ViajeEntity obtenerViaje(Integer idViaje);

    public boolean guardarViaje(ViajeEntity viaje) throws Exception;

    public boolean eliminarViaje(Integer idViaje) throws Exception;

    public boolean actualizarViaje(ViajeEntity viajeParam) throws Exception;
}
