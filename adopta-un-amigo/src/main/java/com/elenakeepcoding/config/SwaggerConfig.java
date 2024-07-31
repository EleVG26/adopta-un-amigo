package com.elenakeepcoding.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(apiInfo())
        		.select()
                .apis(RequestHandlerSelectors.basePackage("com.elenakeepcoding.web.api"))
                .paths(PathSelectors.any())
                .build();
    }
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Documentación de la app de: Adopta un amigo")
				.description("Información completa sobre la API REST para consumo de clientes de todo tipo")
				.termsOfServiceUrl("www.localhost:8080")
				.contact(new Contact("Elena Vargas Grisales", "https://www.linkedin.com/in/elena-vargas-grisales-06b907179/", "ele92gris@gmail.com"))
				.version("1.0")
				.build();
	}
	

}
