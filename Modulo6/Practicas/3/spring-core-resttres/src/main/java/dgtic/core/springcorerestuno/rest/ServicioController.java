package dgtic.core.springcorerestuno.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestController
public class ServicioController {

    @GetMapping(value = "salida", produces = MediaType.TEXT_PLAIN_VALUE)
    public String microServicioUno() {
        return "servicio en Spring";
    }

    @GetMapping(value = "salida/{parametroUno}/{parametroDos}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String servicioDos(@PathVariable("parametroUno") String p,
            @PathVariable("parametroDos") String dato) {
        return "Servicio en Spring con parametrouno= " + p +
                " , parametrodos " + dato;
    }

    @GetMapping(value = "entrada", produces = MediaType.TEXT_PLAIN_VALUE)
    public String servicioTres(@RequestParam("dato") int p,
            @RequestParam("valor") String valor) {
        return "Servicio en Spring con dato= " + p +
                " valor=" + valor;
    }

    @ExceptionHandler
    public String errorParametro(MethodArgumentTypeMismatchException ex) {
        String nombre = ex.getName();
        String tipo = ex.getRequiredType().getSimpleName();
        Object valor = ex.getValue();
        return String.format("El parámetro '%s' es tipo '%s' y el valor '%s' no es '%s'",
                nombre, tipo, valor, tipo);
    }
}
