package mx.unam.diplomado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import mx.unam.diplomado.modelo.entidades.Agencia;
import mx.unam.diplomado.modelo.repository.AgenciaRepositorio;

public class AgenciaServiceImpl implements AgenciaService {

    @Autowired
    private AgenciaRepositorio repositorioAgencia;

    @Override
    public List<Agencia> cargaAgencias() {
        return repositorioAgencia.findAll();
    }

    @Override
    public void guardaAgencia(Agencia agencia) {
        repositorioAgencia.save(agencia);
    }

    @Override
    public Optional<Agencia> cargaAgencia(Integer idAgencia) {
        return repositorioAgencia.findById(idAgencia);
    }

    @Override
    public void eliminaAgencia(Integer idAgencia) {
        repositorioAgencia.deleteById(idAgencia);
    }

    @Override
    public List<Agencia> getListaAgencia() {
        return repositorioAgencia.findAll();
    }

    @Override
    public Agencia cargaPorNombre(String nombre) {
        Agencia encontrado = null;
        Agencia medioContactoExample = new Agencia();
        medioContactoExample.setNombreAgencia(nombre);
        Example<Agencia> tCExample = Example.of(medioContactoExample);
        Iterable<Agencia> it = repositorioAgencia.findAll(tCExample);
        for (Agencia mediocontacto : it) {
            encontrado = mediocontacto;
        }
        return encontrado;
    }

}
