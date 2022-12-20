package unam.dgtic.diplomado.controlador.repositorio.agencia;

import unam.dgtic.diplomado.modelo.beans.agencia.Agencia;

public interface RepositorioAgencia {

    public Iterable<Agencia> obtenerAgencias();

    public Agencia obtenerAgencia(Integer idAgencia);

    public void guardarAgencia(Agencia agencia) throws Exception;

    public void eliminarAgencia(Integer idAgencia);

    public void actualizarAgencia(Agencia agenciaParam);
}
