package unam.dgtic.diplomado.controlador.repositorio.agencia;

import unam.dgtic.diplomado.modelo.entidades.agencia.AgenciaEntity;

public interface RepositorioAgencia {

    public Iterable<AgenciaEntity> obtenerAgencias();

    public AgenciaEntity obtenerAgencia(Integer idAgencia);

    public void guardarAgencia(AgenciaEntity agencia) throws Exception;

    public void eliminarAgencia(Integer idAgencia);

    public void actualizarAgencia(AgenciaEntity agenciaParam);
}
