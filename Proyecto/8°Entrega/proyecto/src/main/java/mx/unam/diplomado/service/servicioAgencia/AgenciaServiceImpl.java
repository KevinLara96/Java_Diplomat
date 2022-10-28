package mx.unam.diplomado.service.servicioAgencia;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import mx.unam.diplomado.modelo.entidades.agencia.Agencia;
import mx.unam.diplomado.modelo.repository.agenciaRepositorio.AgenciaRepositorio;

public class AgenciaServiceImpl implements AgenciaService {

    @Autowired
    private AgenciaRepositorio repositorioAgencia;

    @Override
    public List<Agencia> cargaAgencias() {
        return repositorioAgencia.findAll();
    }

    @Override
    public void guardaAgencia(Agencia autobus) {

    }

    @Override
    public Optional<Agencia> cargaAgencia(Integer idAgencia) {
        return Optional.empty();
    }

    @Override
    public void eliminaAgencia(Integer idAgencia) {

    }

}
