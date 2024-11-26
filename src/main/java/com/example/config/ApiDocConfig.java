package com.example.config;

import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.customizers.ActuatorOpenApiCustomizer;
import org.springdoc.core.customizers.ActuatorOperationCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.properties.SpringDocConfigProperties;
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
    public GroupedOpenApi actuatorApi(WebEndpointProperties endpointProperties,
                                      SpringDocConfigProperties springDocConfigProperties,
                                      @Value("${springdoc.version}") String appVersion) {
        return GroupedOpenApi.builder()
                .group("actuator").displayName("Spring Boot Actuator")
                .pathsToMatch(endpointProperties.getBasePath() + ALL_PATTERN)
                .addOpenApiCustomizer(new ActuatorOpenApiCustomizer(endpointProperties))
                .addOpenApiCustomizer(openApi -> openApi.info(new Info().title("Actuator API").version(appVersion)))
                .addOperationCustomizer(new ActuatorOperationCustomizer(springDocConfigProperties))
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
