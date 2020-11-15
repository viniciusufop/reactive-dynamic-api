package br.com.vfs.reactivedynamicapi.configuration;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@RequiredArgsConstructor
public class Swagger2 {
        private final BuildProperties buildProperties;

        @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.vfs.reactivedynamicapi.web"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                buildProperties.getName(),
                "Reactive Dynamic API",
                buildProperties.getVersion(),
                "Terms of service Url",
                new Contact("VFS Team", "", "-"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }
}