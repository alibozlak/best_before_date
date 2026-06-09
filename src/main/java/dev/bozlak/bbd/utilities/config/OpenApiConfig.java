package dev.bozlak.bbd.utilities.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        // 1. JWT Security Scheme Configuration (Bearer Authentication)
        SecurityScheme securityScheme = new SecurityScheme()
                .name("Bearer Authentication")
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
                .description("Please enter your JWT token obtained from the login endpoint. " +
                        "(You do not need to prefix it with 'Bearer ', the system will handle it automatically.)");

        // Apply the security requirement globally to all endpoints
        SecurityRequirement securityRequirement = new SecurityRequirement().addList("Bearer Authentication");

        // 2. API Metadata & Identity Information
        Info info = new Info()
                .title("Best Before Date API for Hard Discount Model Supermarkets")
                .version("0.0.1")
                .description("A comprehensive backend system designed for retail stores to manage product expiration dates, " +
                        "store tracking, waste operations, and staff activity logging.")
                .contact(new Contact()
                        .name("Ali Bozlak")
                        .url("https://github.com/alibozlak"));

        // 3. Environment Servers Configuration
        Server devServer = new Server()
                .url("http://localhost:8080")
                .description("Development Environment (Localhost)");

        // Merge all configurations into the OpenAPI object for Spring Context
        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer))
                .components(new Components().addSecuritySchemes("Bearer Authentication", securityScheme))
                .addSecurityItem(securityRequirement);
    }
}