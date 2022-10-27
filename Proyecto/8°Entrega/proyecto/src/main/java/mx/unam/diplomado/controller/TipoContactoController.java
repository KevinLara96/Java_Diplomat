package mx.unam.diplomado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.unam.diplomado.modelo.entidades.TipoContacto;
import mx.unam.diplomado.service.TipoContactoService;

@Controller
public class TipoContactoController {

    @Autowired
    private TipoContactoService service;

    @ResponseBody
    @RequestMapping(value = { "/jsonTipoContacto" })
    public List<TipoContacto> tipoContactoJson() {
        return service.getListaTipoContacto();
    }

}
