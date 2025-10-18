package com.paolo.cinemille.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.paolo.cinemille.aspects.LogAspect;

@Configuration
@EnableAspectJAutoProxy
public class AspectsConfig {

    @Bean
    LogAspect logAspect() {
		return new LogAspect();
	}
}