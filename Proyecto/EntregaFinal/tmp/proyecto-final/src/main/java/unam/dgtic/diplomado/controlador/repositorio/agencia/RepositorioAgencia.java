package unam.dgtic.diplomado.controlador.repositorio.agencia;

import unam.dgtic.diplomado.modelo.beans.agencia.AgenciaBean;

public interface RepositorioAgencia {

    public Iterable<AgenciaBean> obtenerAgencias();

    public AgenciaBean obtenerAgencia(Integer idAgencia);

    public void guardarAgencia(AgenciaBean agencia) throws Exception;

    public void eliminarAgencia(Integer idAgencia);

    public void actualizarAgencia(AgenciaBean agenciaParam);
}
