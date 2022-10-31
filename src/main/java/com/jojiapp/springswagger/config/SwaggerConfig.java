package com.jojiapp.springswagger.config;

import org.springframework.context.annotation.*;
import org.springframework.http.*;
import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.*;
import springfox.documentation.spi.service.contexts.*;
import springfox.documentation.spring.web.plugins.*;

import java.util.*;

import static org.springframework.http.HttpHeaders.*;

@Configuration
public class SwaggerConfig {

    private static final String TITLE = "[Spring Swagger] REST API";
    private static final String DESCRIPTION = "[Spring Swagger] BackEnd REST API Details";
    private static final String NAME = "[jojiapp]";
    private static final String BASE_PACKAGE = "com.jojiapp.springswagger";
    private static final String URL = "https://github.com/jojiapp";
    private static final String EMAIL = "jojiapp@gmail.com";
    private static final String VERSION = "1.0";
    private static final String HEADER = "header";
    private static final String BEARER = "Bearer ";
    private static final String SCOPE = "global";
    private static final String SCOPE_DESCRIPTION = "accessEverything";

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.OAS_30)
                .consumes(getConsumeContentTypes())
                .produces(getProduceContentTypes())
                .useDefaultResponseMessages(false)
                .apiInfo(getApiInfo())
                .securityContexts(List.of(securityContext()))
                .securitySchemes(List.of(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
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

    private SecurityContext securityContext() {

        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build();
    }

    private List<SecurityReference> defaultAuth() {

        return List.of(
                new SecurityReference(
                        AUTHORIZATION,
                        new AuthorizationScope[]{new AuthorizationScope(SCOPE, SCOPE_DESCRIPTION)}
                )
        );
    }

    private ApiKey apiKey() {

        return new ApiKey(AUTHORIZATION, BEARER, HEADER);
    }
}
