package com.ch7.Gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("orderService", r -> r.path("/api/orders/**")
                        .uri("http://localhost:6060/"))
                .route("notificationService", r -> r.path("/api/notifications/**")
                        .uri("http://localhost:7070/"))
                .build();
    }
}
