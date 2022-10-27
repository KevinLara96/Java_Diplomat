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
    public Optional<Agencia> findByIdAgencia(Integer idAgencia) {
        return Optional.empty();
    }

    @Override
    public List<Agencia> findAllByIdAgencia(Integer idAgencia) {
        return null;
    }

}
