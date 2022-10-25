package com.jojiapp.springswagger.config;

import org.springframework.context.annotation.*;
import org.springframework.http.*;
import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.*;
import springfox.documentation.spring.web.plugins.*;

import java.util.*;

@Configuration
public class SwaggerConfig {

    private static final String TITLE = "[Spring Swagger] REST API";
    private static final String DESCRIPTION = "[Spring Swagger] BackEnd REST API Details";
    private static final String NAME = "[jojiapp]";
    private static final String URL = "https://github.com/jojiapp";
    private static final String EMAIL = "jojiapp@gmail.com";
    private static final String VERSION = "1.0";

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.OAS_30)
                .consumes(getConsumeContentTypes())
                .produces(getProduceContentTypes())
                .useDefaultResponseMessages(false)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jojiapp.springswagger"))
                .paths(PathSelectors.ant("/**"))

                .build();
    }

    private Set<String> getConsumeContentTypes() {

        Set<String> consumes = new HashSet<>();
        consumes.add(MediaType.APPLICATION_JSON_VALUE);
        consumes.add(MediaType.APPLICATION_FORM_URLENCODED_VALUE);
        return consumes;
    }

    private Set<String> getProduceContentTypes() {

        Set<String> produces = new HashSet<>();
        produces.add(MediaType.APPLICATION_JSON_VALUE);
        return produces;
    }

    private ApiInfo getApiInfo() {

        return new ApiInfoBuilder()
                .title(TITLE)
                .description(DESCRIPTION)
                .contact(new Contact(NAME, URL, EMAIL))
                .version(VERSION)
                .build();
    }
}
