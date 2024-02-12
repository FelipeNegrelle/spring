package com.server.server.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(
                new Info()
                        .title("RESTful API with Spring Boot 3.0.2")
                        .version("1.0")
                        .description("RESTful API with Spring Boot 3.0.2")
                        .termsOfService("http://swagger.io/terms/")
                        .license(
                                new io.swagger.v3.oas.models.info.License()
                                        .name("Apache 2.0")
                                        .url("http://springdoc.org")
                        )
        );
    }
}
