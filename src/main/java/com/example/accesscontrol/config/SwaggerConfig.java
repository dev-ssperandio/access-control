package com.example.accesscontrol.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Access Control - Rest API")
                        .description("Example of using Spring Boot REST API")
                        .version("1.0")
                        .termsOfService("Terms of use: Open Source")
                        .contact(new Contact()
                                .name("Sidney Ribeiro Sperandio")
                                .url("https://www.linkedin.com/in/sidneysperandio/")
                                .email("dev.ssperandio@gmail.com"))
                        .license(new io.swagger.v3.oas.models.info.License()
                                .name("License - My Company")
                                .url("https://github.com/dev-ssperandio/access-control.git"))
                );
    }
}
