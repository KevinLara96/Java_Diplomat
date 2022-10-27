package mx.unam.diplomado.service.servicioEmpleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.unam.diplomado.modelo.entidades.empleado.Empleado;
import mx.unam.diplomado.modelo.repository.empleadoRepositorio.EmpleadoRepositorio;

public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepositorio repositorioEmpleado;

    @Override
    public List<Empleado> cargaEmpleados() {
        return null;
    }

    @Override
    public void guardaEmpleado(Empleado empleado) {

    }

    @Override
    public Empleado cargaEmpleado(Integer id) {
        return null;
    }

    @Override
    public void eliminaEmpleado(Integer id) {

    }

}
