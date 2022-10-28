package mx.unam.diplomado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import mx.unam.diplomado.modelo.entidades.Viaje;
import mx.unam.diplomado.modelo.repository.ViajeRepositorio;

public class ViajeServiceImpl implements ViajeService {

    @Autowired
    private ViajeRepositorio repositorioViaje;

    @Override
    public List<Viaje> cargaViajes() {
        return repositorioViaje.findAll();
    }

    @Override
    public void guardaViaje(Viaje viaje) {
        repositorioViaje.save(viaje);
    }

    @Override
    public Optional<Viaje> cargaViaje(Integer idViaje) {
        return repositorioViaje.findById(idViaje);
    }

    @Override
    public void eliminaViaje(Integer idViaje) {
        repositorioViaje.deleteById(idViaje);
    }

}
