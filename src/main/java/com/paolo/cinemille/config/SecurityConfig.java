package com.paolo.cinemille.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.SneakyThrows;

@Configuration
public class SecurityConfig {
	
	@Bean
	@SneakyThrows
	SecurityFilterChain securityFilterChain(HttpSecurity http) {
		

		//nel caso di questa API REST si puo disabilitare la protezione csfr
        http
        .cors(c -> c.configurationSource(corsConfigurationSource()))
        .csrf(csrf -> csrf.disable())
        //autorizzazione degli endpoint pubblici 
        .authorizeHttpRequests(auth-> auth
        		.requestMatchers(
        				"/api/**"
        				).permitAll()
        		).httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
	
	//configurazione cors. sono ammesse solo richieste GET da localhost:4200
	private CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration cors = new CorsConfiguration();
		
		cors.addAllowedOrigin("http://localhost:4200");
		cors.addAllowedMethod("GET");
		cors.setAllowedHeaders(List.of("Authorization", "Content-Type"));
		cors.setAllowCredentials(true);
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		
		source.registerCorsConfiguration("/api/**", cors);
		
		return source;
	}
	
}
