package unam.dgtic.diplomado.controlador.repositorio.agencia;

import unam.dgtic.diplomado.modelo.entidades.agencia.AgenciaEntity;

public interface RepositorioAgencia {

    public Iterable<AgenciaEntity> obtenerAgencias();

    public AgenciaEntity obtenerAgencia(Integer idAgencia);

    public boolean guardarAgencia(AgenciaEntity agencia) throws Exception;

    public boolean eliminarAgencia(Integer idAgencia) throws Exception;

    public boolean actualizarAgencia(AgenciaEntity agenciaParam) throws Exception;
}
