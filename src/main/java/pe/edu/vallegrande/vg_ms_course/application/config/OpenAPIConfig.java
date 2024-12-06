package pe.edu.vallegrande.vg_ms_course.application.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
public class OpenAPIConfig implements WebFluxConfigurer {

    @Bean
    public OpenAPI studentServiceAPI() {
        return new OpenAPI()
                .info(new Info().title("API de Servicio de Curso")
                        .description("Esta es la API REST para el Servicio de Curso")
                        .version("v0.0.1")
                        .license(new License().name("Valle Grande")))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentación Wiki del Servicio de Curso")
                        .url("https://vallegrande.edu.pe/docs"));
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*");
    }

}