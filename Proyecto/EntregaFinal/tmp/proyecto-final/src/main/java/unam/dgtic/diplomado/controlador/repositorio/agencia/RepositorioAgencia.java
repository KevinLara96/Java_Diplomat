package unam.dgtic.diplomado.controlador.repositorio.agencia;

import unam.dgtic.diplomado.modelo.entidades.agencia.Agencia;

public interface RepositorioAgencia {

    public Iterable<Agencia> obtenerAgencias();

    public Agencia obtenerAgencia(Integer idAgencia);

    public void guardarAgencia(Agencia agenciaNueva) throws Exception;

    public void eliminarAgencia();
}
