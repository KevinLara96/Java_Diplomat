package unam.dgtic.diplomado.controlador.repositorio.viaje;

import unam.dgtic.diplomado.modelo.beans.viaje.ViajeBean;

public interface RepositorioViaje {

    public Iterable<ViajeBean> obtenerViajes();

    public ViajeBean obtenerViaje(Integer idViaje);

    public void guardarViaje(ViajeBean viaje) throws Exception;

    public void eliminarViaje(Integer idViaje);

    public void actualizarViaje(ViajeBean viajeParam);
}
