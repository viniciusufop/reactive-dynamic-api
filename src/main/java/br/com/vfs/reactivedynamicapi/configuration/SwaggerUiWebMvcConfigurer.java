package br.com.vfs.reactivedynamicapi.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@RequiredArgsConstructor
public class SwaggerUiWebMvcConfigurer implements WebFluxConfigurer {

    private final String baseUrl;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        final String baseUrl = StringUtils.trimTrailingCharacter(this.baseUrl, '/');
        registry.
                addResourceHandler(baseUrl + "/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
                .resourceChain(false);
    }
}
