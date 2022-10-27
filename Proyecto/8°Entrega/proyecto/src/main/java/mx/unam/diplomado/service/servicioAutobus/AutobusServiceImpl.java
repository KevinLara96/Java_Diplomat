package mx.unam.diplomado.service.servicioAutobus;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import mx.unam.diplomado.modelo.entidades.autobus.Autobus;
import mx.unam.diplomado.modelo.repository.autobusRepositorio.AutobusRepositorio;

public class AutobusServiceImpl implements AutobusService {

    @Autowired
    private AutobusRepositorio repositorioAutobus;

    @Override
    public List<Autobus> cargaAutobuses() {
        return null;
    }

    @Override
    public void guardaAutobus(Autobus autobus) {

    }

    @Override
    public Optional<Autobus> cargaAutobus(Integer idAutobus) {
        return null;
    }

    @Override
    public void eliminaAutobus(Integer idAutobus) {

    }

}