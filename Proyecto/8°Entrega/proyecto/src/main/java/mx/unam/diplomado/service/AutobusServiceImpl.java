package mx.unam.diplomado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import mx.unam.diplomado.modelo.entidades.autobus.Autobus;
import mx.unam.diplomado.modelo.repository.AutobusRepositorio;

public class AutobusServiceImpl implements AutobusService {

    @Autowired
    private AutobusRepositorio repositorioAutobus;

    @Override
    public List<Autobus> cargaAutobuses() {
        return repositorioAutobus.findAll();
    }

    @Override
    public void guardaAutobus(Autobus autobus) {
        repositorioAutobus.save(autobus);
    }

    @Override
    public Optional<Autobus> cargaAutobus(Integer idAutobus) {
        return repositorioAutobus.findById(idAutobus);
    }

    @Override
    public void eliminaAutobus(Integer idAutobus) {
        repositorioAutobus.deleteById(idAutobus);
    }

    @Override
    public List<Autobus> getListaAutobus() {
        return repositorioAutobus.findAll();
    }

    @Override
    public Autobus cargaPorNombre(String nombre) {
        Autobus encontrado = null;
        Autobus medioContactoExample = new Autobus();
        medioContactoExample.setModelo(nombre);
        Example<Autobus> tCExample = Example.of(medioContactoExample);
        Iterable<Autobus> it = repositorioAutobus.findAll(tCExample);
        for (Autobus mediocontacto : it) {
            encontrado = mediocontacto;
        }
        return encontrado;
    }

}