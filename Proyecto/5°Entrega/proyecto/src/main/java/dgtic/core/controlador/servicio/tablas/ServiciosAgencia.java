package dgtic.controlador.servicio.tablas;

import dgtic.modelo.entidades.agencia.Agencia;

public interface ServiciosAgencia {
    Agencia cargaAgencia();

    void guardaAgencia(Agencia agencia);

    void actualizaAgencia(Agencia agencia);

    void eliminaAgencia(Agencia agencia);
}
