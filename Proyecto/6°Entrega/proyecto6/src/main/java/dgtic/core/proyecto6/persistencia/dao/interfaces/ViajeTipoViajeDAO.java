package dgtic.core.proyecto6.persistencia.dao.interfaces;

import java.util.List;

import dgtic.core.proyecto6.persistencia.modelo.viaje.ViajeTipoViaje;

public interface ViajeTipoViajeDAO {

    public List<ViajeTipoViaje> consulta();

    public void insertar(ViajeTipoViaje nuevo);

    public void cambiar(ViajeTipoViaje nuevo);

    public void borrar(ViajeTipoViaje nuevo);
}
