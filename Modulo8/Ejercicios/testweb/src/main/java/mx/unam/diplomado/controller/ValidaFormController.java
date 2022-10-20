package mx.unam.diplomado.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mx.unam.diplomado.data.Usuario;

@Controller
@RequestMapping("/validaForm")
public class ValidaFormController {
	
	@RequestMapping("/inicio")
    public String showUserForm(Model model){
        model.addAttribute("usuario", new Usuario());
        return "usuarioForm";
    }

    @RequestMapping("/crear")
    public ModelAndView createUser(@Valid Usuario user, BindingResult result) {
        ModelAndView model = new ModelAndView();
        model.addObject("usuario", user);
        model.setViewName(result.hasErrors() ? "usuarioForm" : "usuario");
        
        return model;
    }

}
