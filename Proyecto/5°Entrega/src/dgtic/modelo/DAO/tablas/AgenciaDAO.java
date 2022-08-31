package dgtic.modelo.DAO.tablas;

import dgtic.modelo.entidades.agencia.Agencia;

public interface AgenciaDAO {
    Agencia cargaAgencia();

    // Agencia cargaAgenciaPorIdNQ(Integer id);

    void guardaAgencia(Agencia agencia);

    void actualizaAgencia(Agencia agencia);

    void eliminaAgencia(Agencia agencia);
}
