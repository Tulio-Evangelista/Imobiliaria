package com.Java.Imobiliaria.configuration;


import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenAPI() {

        Contact contact = new Contact();
        contact.setName("Tulio");
        contact.setEmail("tulio-evangelista@Outlook.com");

        Info info = new Info()
                .title("API de Imobiliaria")
                .description("API para gerenciar uma imobiliaria")
                .version("v1")
                .contact(contact);

        return new OpenAPI().info(info);
    }


}
