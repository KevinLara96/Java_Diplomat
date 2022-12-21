package unam.dgtic.diplomado.controlador.repositorio.agencia;

import unam.dgtic.diplomado.modelo.beans.agencia.AgenciaBean;
import unam.dgtic.diplomado.modelo.entidades.agencia.Agencia;

public interface RepositorioAgencia {

    public Iterable<Agencia> obtenerAgencias();

    public AgenciaBean obtenerAgencia(Integer idAgencia);

    public void guardarAgencia(AgenciaBean agencia) throws Exception;

    public void eliminarAgencia(Integer idAgencia);

    public void actualizarAgencia(AgenciaBean agenciaParam);
}
