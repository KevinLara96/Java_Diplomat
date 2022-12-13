package unam.dgtic.diplomado.controlador.repositorio.agencia;

import unam.dgtic.diplomado.modelo.entidades.agencia.Agencia;

public interface RepositorioAgencia {

    public Iterable<Agencia> findAllAgencias();

    public Agencia findAgencia(Integer idAgencia);

    public void createAgencia(Agencia agenciaNueva) throws Exception;
}
