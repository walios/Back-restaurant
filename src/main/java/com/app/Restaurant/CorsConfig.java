package com.app.Restaurant;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:3000");
        config.addAllowedHeader("*"); // You could also specify individual headers like "Content-Type", "Authorization", etc.
        config.addAllowedMethod("*"); // This allows all methods. You could also specify individual methods like "GET", "POST", etc.
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}


