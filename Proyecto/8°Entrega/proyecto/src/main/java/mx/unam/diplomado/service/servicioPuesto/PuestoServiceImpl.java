package mx.unam.diplomado.service.servicioPuesto;

import java.util.List;

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

    }

    @Override
    public Puesto cargaPuesto(Integer id) {
        return null;
    }

    @Override
    public void eliminaPuesto(Integer id) {

    }
}
