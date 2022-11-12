package dgtic.core.proyecto6.persistencia.dao.interfaces;

import java.util.List;

import dgtic.core.proyecto6.persistencia.modelo.agencia.Agencia;

public interface AgenciaDAO {

    public List<Agencia> consultaAgencias();

    public Agencia consultaIdAgencia(Integer idAgencia);

    public void insertarAgencia(Agencia agencia);

    public void cambiarAgencia(Agencia agencia);

    public void borrarAgencia(Agencia agencia);
}
