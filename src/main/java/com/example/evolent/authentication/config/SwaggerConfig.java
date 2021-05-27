package com.example.evolent.authentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    public static final String AUTHORIZATION_HEADER = "Authorization";

    @Bean
    public Docket api() {
        ParameterBuilder authHeader = new ParameterBuilder();
        authHeader
                .name(AUTHORIZATION_HEADER)
                .modelRef(new ModelRef("string"))
                .description(
                        "Bearer ${Access Token}. You have to obtain access token from auth0 with proper audience field.")
                .parameterType("header")
                .build();
        List<Parameter> authParameter = new ArrayList<>();
        authParameter.add(authHeader.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(authParameter)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.evolent"))
                .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
