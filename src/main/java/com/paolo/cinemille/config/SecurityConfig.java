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

/*
 * E' stato scelto di utilizzare Spring Security per predisporre l'applicativo 
 * per un possibile sistema di autenticazione futuro e per questioni formative 
 */

@Configuration
public class SecurityConfig {
	
	@Bean
	@SneakyThrows
	SecurityFilterChain securityFilterChain(HttpSecurity http) {
		

		/*
		 * nel caso di questa API REST è stato scelto di disabilitare la
		 * sicurezza CROSS-SITE-REQUEST-FORGE (da abilitare in caso di implementazione di sistema di autenticazione).
		 * In questa api tutti gli endpoint sono pubblici
		 */
		
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
	
	/*
	 * Configurazione CORS (CROSS-ORIGIN RESOUCE SHARING):
	 * sono ammesse solo richieste GET la cui origine è localhost:4200
	 */
	
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
