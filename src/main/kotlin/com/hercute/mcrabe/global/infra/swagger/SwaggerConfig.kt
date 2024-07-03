package com.hercute.mcrabe.global.infra.swagger

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun openAPI(): OpenAPI {
        return OpenAPI()
            .components(Components())
            .info(
                Info()
                    .title("최종 프로젝트 - 티켓 레이더 API")
                    .description("티켓 레이더 API schema")
                    .version("1.0.0")
            )
    }
}
//
//@Configuration
//class SwaggerConfig {
//
//    @Bean
//    fun openAPI(): OpenAPI = OpenAPI()
//        .components(Components())
//        .info(
//            Info()
//                .title("Course API")
//                .description("Course API schema")
//                .version("1.0.0")
//        )
//}
