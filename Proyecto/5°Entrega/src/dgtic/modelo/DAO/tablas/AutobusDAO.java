package dgtic.modelo.DAO.tablas;

import java.util.List;

import dgtic.modelo.entidades.autobus.Autobus;

public interface AutobusDAO {
    Autobus cargaAutobusPorId(Integer id);

    // Autobus cargaAutobusPorIdNQ(Integer id);

    List<Autobus> cargaAutobuses();

    void guardaAutobus(Autobus autobus);

    void actualizaAutobus(Autobus autobus);

    void eliminaAutobus(Autobus autobus);
}
