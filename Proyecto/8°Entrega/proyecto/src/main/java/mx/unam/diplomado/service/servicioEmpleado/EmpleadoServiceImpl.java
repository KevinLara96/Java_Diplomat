package mx.unam.diplomado.service.servicioEmpleado;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import mx.unam.diplomado.modelo.entidades.empleado.Empleado;
import mx.unam.diplomado.modelo.repository.empleadoRepositorio.EmpleadoRepositorio;

public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepositorio repositorioEmpleado;

    @Override
    public List<Empleado> cargaEmpleados() {
        return repositorioEmpleado.findAll();
    }

    @Override
    public void guardaEmpleado(Empleado empleado) {
        repositorioEmpleado.save(empleado);
    }

    @Override
    public Optional<Empleado> cargaEmpleado(Integer idEmpleado) {
        return repositorioEmpleado.findById(idEmpleado);
    }

    @Override
    public void eliminaEmpleado(Integer idEmpleado) {
        repositorioEmpleado.deleteById(idEmpleado);
    }

}
