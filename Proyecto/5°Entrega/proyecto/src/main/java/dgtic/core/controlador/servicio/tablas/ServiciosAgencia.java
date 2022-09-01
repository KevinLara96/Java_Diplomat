package dgtic.core.controlador.servicio.tablas;

import dgtic.core.modelo.entidades.agencia.Agencia;

public interface ServiciosAgencia {
    Agencia cargaAgencia();

    void guardaAgencia(Agencia agencia);

    void actualizaAgencia(Agencia agencia);

    void eliminaAgencia(Agencia agencia);
}
