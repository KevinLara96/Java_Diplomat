package mx.unam.diplomado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import mx.unam.diplomado.modelo.entidades.Empleado;
import mx.unam.diplomado.modelo.repository.EmpleadoRepositorio;

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

    @Override
    public List<Empleado> getListaEmpleado() {
        return repositorioEmpleado.findAll();
    }

    @Override
    public Empleado cargaPorNombre(String nombre) {
        Empleado encontrado = null;
        Empleado medioContactoExample = new Empleado();
        medioContactoExample.setNombre(nombre);
        Example<Empleado> tCExample = Example.of(medioContactoExample);
        Iterable<Empleado> it = repositorioEmpleado.findAll(tCExample);
        for (Empleado mediocontacto : it) {
            encontrado = mediocontacto;
        }
        return encontrado;
    }

}
