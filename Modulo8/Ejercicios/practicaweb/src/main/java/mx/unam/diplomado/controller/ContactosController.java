package mx.unam.diplomado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mx.unam.diplomado.form.ContactoForm;
import mx.unam.diplomado.modelo.entidades.Contacto;
import mx.unam.diplomado.modelo.entidades.TipoContacto;
import mx.unam.diplomado.service.ContactoService;
import mx.unam.diplomado.service.TipoContactoService;

@Controller
@RequestMapping("/contactos")
public class ContactosController {
	
	@Autowired
	private ContactoService contactoService;
	
	@Autowired
	private TipoContactoService tipoContactoService;
	
	@RequestMapping("/inicio")
	public String inicio(Model model) {
		model.addAttribute("contactos", contactoService.cargaContactos());
		return "contactos";
	}
	
	@RequestMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("contacto", new ContactoForm());
		return "contactoForm";
	}
	
	@RequestMapping(value = "/guardaContacto", method = RequestMethod.POST)
	public String guarda(ContactoForm contactoForm) {
		Contacto contacto = new Contacto();
		contacto.setNombre(contactoForm.getNombre());
		contacto.setApellidos(contactoForm.getApellidos());
		contacto.setEdad(34);
		contacto.setDireccion("mi direccion");
		TipoContacto tipoContacto = tipoContactoService.cargaPorNombre("Familiar");
		contacto.setTipoContacto(tipoContacto);
		contactoService.guardaContacto(contacto);
		return "redirect:/contactos/inicio";
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("contactoId") Integer contactoId) {
		contactoService.eliminaContacto(contactoId);
		return "redirect:/contactos/inicio";
	}

}
