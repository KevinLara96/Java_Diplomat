package dgtic.core.servicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import dgtic.core.modelo.Estudiante;

@Configuration
@ImportResource(locations = { "classpath:/dgtic/core/xml/*.xml" })
@ComponentScan(basePackages = "dgtic.core")
public class ConfiguracionServicio {
    @Bean(name = "estudiante")
    @Scope("prototype")
    public Estudiante servicioEstudiante() {
        Estudiante est = new Estudiante();
        est.setNombre("Pedro");
        est.setEdad(13);
        return est;
    }
}

/*
 * @Bean(name = "materia")
 * 
 * @Scope("prototype")
 * public Materia servicioMateria() {
 * Materia materia = new Materia();
 * materia.setNombre("EDA");
 * materia.setCreditos(10);
 * 
 * return materia;
 * }
 * }
 */