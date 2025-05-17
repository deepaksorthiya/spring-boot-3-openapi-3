package com.example.config;

import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static org.springdoc.core.utils.Constants.ALL_PATTERN;

@Configuration
public class ApiDocConfig {

    @Bean
    @Profile("!prod")
    public GroupedOpenApi actuatorApi(OpenApiCustomizer actuatorOpenApiCustomizer,
                                      WebEndpointProperties endpointProperties,
                                      @Value("${springdoc.version}") String appVersion) {
        return GroupedOpenApi.builder()
                .group("actuator").displayName("Spring Boot Actuator")
                .pathsToMatch(endpointProperties.getBasePath() + ALL_PATTERN)
                .addOpenApiCustomizer(actuatorOpenApiCustomizer)
                .addOpenApiCustomizer(openApi -> openApi.info(new Info().title("Actuator API").version(appVersion)))
                .pathsToExclude("/health/*")
                .build();
    }

    @Bean
    public GroupedOpenApi usersV1Group(@Value("${springdoc.version}") String appVersion) {
        return GroupedOpenApi.builder().group("users-v1").displayName("User API V1")
                .addOpenApiCustomizer(openApi -> openApi.info(new Info().title("User API V1").version(appVersion)))
                .packagesToScan("com.example")
                .pathsToMatch("/api/v1/**")
                .build();
    }

    @Bean
    public GroupedOpenApi usersV2Group(@Value("${springdoc.version}") String appVersion) {
        return GroupedOpenApi.builder().group("users-v2").displayName("User API V2")
                .addOpenApiCustomizer(openApi -> openApi.info(new Info().title("User API V2").version(appVersion)))
                .packagesToScan("com.example")
                .pathsToMatch("/api/v2/**")
                .build();
    }
}
