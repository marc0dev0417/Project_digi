package com.proyecto.Proyecto_piso.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.oas.annotations.EnableOpenApi
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@Configuration
@EnableOpenApi
class SwaggerDocumentationConfig {
    fun apiInfo(): ApiInfo?{
        return ApiInfoBuilder()
            .title("This is our Rest API for the House App")
            .description("Here you can make calls to the different models that my API contains")
            .license("Apache 2.0")
            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
            .termsOfServiceUrl("")
            .version("1.0.0")
            .contact(Contact("Iker Nadal y Marco Benegas","", "marcobenegasdev@outlook.es"))
            .build()
    }
    @Bean
    fun api(): Docket{
        return Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.proyecto.Proyecto_piso.controller"))
            .build()
    }
}