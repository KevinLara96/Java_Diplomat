package mx.unam.diplomado.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
@ComponentScan(basePackages="mx.unam.diplomado")
@EnableWebMvc
public class MvcConfiguration implements WebMvcConfigurer {

	/*@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}*/
	
	//registro de vistas
	@Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }
	
	//resolver para bean
	@Bean
    public ViewResolver viewResolver() {
      BeanNameViewResolver resolver = new BeanNameViewResolver();
      resolver.setOrder(1);
      return resolver;
    }

	//view para json
    @Bean
    public View jsonView() {
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        view.setPrettyPrint(true);
        return view;
    }
    
    //resolver para properties
    @Bean
    public ViewResolver resourceBundleViewResolver() {
        ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();
        viewResolver.setBasename("views");
        viewResolver.setOrder(2);
        return viewResolver;
    }
    
    //registro para internacionalizacion
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }
	
    //registro de recursos estaticos
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/")
			.setCacheControl(CacheControl.maxAge(60, TimeUnit.MINUTES) //manejo del cache
		        .noTransform()
		        .mustRevalidate());
	}

	
	
}
