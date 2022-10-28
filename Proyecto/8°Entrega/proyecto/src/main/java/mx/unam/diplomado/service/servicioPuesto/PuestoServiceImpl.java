package mx.unam.diplomado.service.servicioPuesto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

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

    @Override
    public List<Puesto> getListaPuesto() {
        return repositorioPuesto.findAll();
    }

    @Override
    public Puesto cargaPorNombre(String nombre) {
        Puesto encontrado = null;
        Puesto medioContactoExample = new Puesto();
        medioContactoExample.setPuesto(nombre);
        Example<Puesto> tCExample = Example.of(medioContactoExample);
        Iterable<Puesto> it = repositorioPuesto.findAll(tCExample);
        for (Puesto mediocontacto : it) {
            encontrado = mediocontacto;
        }
        return encontrado;
    }
}
