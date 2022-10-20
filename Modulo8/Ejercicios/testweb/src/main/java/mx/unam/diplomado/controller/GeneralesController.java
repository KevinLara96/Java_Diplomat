package mx.unam.diplomado.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.unam.diplomado.data.FormatoDato;

@Controller
@RequestMapping("/generales")
public class GeneralesController {
	
	@ResponseBody
	@RequestMapping(value = "/params", method = RequestMethod.GET)
	public Map<String, Object> parametrosGet(@RequestParam("param1") String param1, @RequestParam(name = "param2", required = false) Integer param2) {
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("param1", param1);
		parametros.put("param2", param2);
		return parametros;
	}
	
	@RequestMapping("/recursos")
	public String recursos(Model model) {
	    return "recursos";
	}
	
	@RequestMapping("/formatos")
	public String formatos(Model model) {
		FormatoDato formato = new FormatoDato();
		formato.setFecha(new Date());
		formato.setSalario(new BigDecimal("1500.00"));
		model.addAttribute("formato", formato);
	    return "formateo";
	}
	
	@RequestMapping("/mensajes")
	public String mensajes(Model model) {
	    return "mensajes";
	}

}
