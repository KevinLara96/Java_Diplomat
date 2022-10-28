package mx.unam.diplomado.service.servicioViaje;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.unam.diplomado.modelo.entidades.viaje.Viaje;
import mx.unam.diplomado.modelo.repository.viajeRepositorio.ViajeRepositorio;

public class ViajeServiceImpl implements ViajeService {

    @Autowired
    private ViajeRepositorio repositorioViaje;

    @Override
    public List<Viaje> cargaViajes() {
        return repositorioViaje.findAll();
    }

    @Override
    public void guardaViaje(Viaje viaje) {

    }

    @Override
    public Viaje cargaViaje(Integer id) {
        return null;
    }

    @Override
    public void eliminaViaje(Integer id) {

    }

}
