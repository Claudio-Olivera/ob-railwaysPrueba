package com.practica1.Laptops.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Configuración de Swagger para la documentación de API REST
 *<a href="http://localhost:8080/swagger-ui/index.html#/">...</a>
 * <p>
 * Annotations para Swagger (io.swagger.v3.oas.annotations):
 * <a href="https://docs.swagger.io/swagger-core/v2.0.0-RC3/apidocs/io/swagger/v3/oas/annotations/package-summary.html">...</a>
 * <p>
 * Especificaciones Oficiales:
 * <a href="https://swagger.io/specification/">...</a>
 * <p>
 * Más información util:
 * <a href="https://micronaut-projects.github.io/micronaut-openapi/snapshot/guide/index.html">...</a>
 */

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Tech Shop API REST")
                        .description("API REST for OB docs")
                        .version("1.0")
                        .termsOfService("http://swagger.io/terms/")
                        .contact(new Contact().email("claudioolivera753@gmail.com").name("Claudio Olivera"))
                        .license(new License().name("MIT").url("http://springdoc.org"))
                );
    }

}
