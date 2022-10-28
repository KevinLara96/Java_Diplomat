package mx.unam.diplomado.controller;

import org.springframework.beans.factory.annotation.Autowired;

import mx.unam.diplomado.service.AgenciaService;
import mx.unam.diplomado.service.EmpleadoService;
import mx.unam.diplomado.service.PuestoService;

public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private AgenciaService agenciaService;

    @Autowired
    private PuestoService puestoService;

}
