package mx.unam.diplomado.service.servicioPuesto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import mx.unam.diplomado.modelo.entidades.puesto.Puesto;
import mx.unam.diplomado.modelo.repository.puestoRepositorio.PuestoRepositorio;

public class PuestoServiceImpl implements PuestoService {
    @Autowired
    private PuestoRepositorio repositorioPuesto;

    @Override
    public List<Puesto> cargaPuestos() {
        return repositorioPuesto.findAll();
    }

    @Override
    public void guardaPuesto(Puesto puesto) {
        repositorioPuesto.save(puesto);
    }

    @Override
    public Optional<Puesto> cargaPuesto(Integer idPuesto) {
        return repositorioPuesto.findById(idPuesto);
    }

    @Override
    public void eliminaPuesto(Integer idPuesto) {
        repositorioPuesto.deleteById(idPuesto);
    }
}
