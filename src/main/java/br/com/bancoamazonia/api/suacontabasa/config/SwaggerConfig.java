package br.com.bancoamazonia.api.suacontabasa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class SwaggerConfig extends WebMvcConfigurationSupport {
@Bean
public Docket productApi() {
return new Docket(DocumentationType.SWAGGER_2)
.select()
.apis(RequestHandlerSelectors.basePackage(“com.crm”))
.build()
.apiInfo(metaData());
}
private ApiInfo metaData() {
return new ApiInfoBuilder()
.title(“Spring Boot REST API”)
.description(“\”Spring Boot REST API\””)
.version(“1.0.0”)
.license(“Apache License Version 2.0”)
.licenseUrl(“https://www.apache.org/licenses/LICENSE-2.0\"")
.build();
}
@Override
protected void addResourceHandlers(ResourceHandlerRegistry registry) {
registry.addResourceHandler(“swagger-ui.html”)
.addResourceLocations(“classpath:/META-INF/resources/”);
registry.addResourceHandler(“/webjars/**”)
.addResourceLocations(“classpath:/META-INF/resources/webjars/”);
}
}