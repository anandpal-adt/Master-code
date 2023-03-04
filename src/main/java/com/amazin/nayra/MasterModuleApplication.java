package com.amazin.nayra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
//@EnableEurekaClient
public class MasterModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterModuleApplication.class, args);
	}
//	
//	  @SuppressWarnings("deprecation")
//	@Bean
//	   public WebMvcConfigurer corsConfigurer() {
//	      return new WebMvcConfigurerAdapter() {
//	         @Override
//	         public void addCorsMappings(CorsRegistry registry) {
//	            registry.addMapping("/").allowedOrigins("http://localhost:8041");
//	         }
//	      };
//	   }
	
	

}
