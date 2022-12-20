package unam.dgtic.diplomado.controlador.repositorio.empleado;

import unam.dgtic.diplomado.modelo.beans.empleado.PuestoBean;

public interface RepositorioPuesto {

    public Iterable<PuestoBean> obtenerPuestos();

    public PuestoBean obtenerPuesto(Integer idPuesto);

    public void guardarPuesto(PuestoBean puesto) throws Exception;

    public void eliminarPuesto(Integer idPuesto);

    public void actualizarPuesto(PuestoBean puestoParam);
}
