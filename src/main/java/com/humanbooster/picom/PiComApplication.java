package com.humanbooster.picom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PiComApplication {

    public static void main(String[] args) {
        SpringApplication.run(PiComApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/test/**")
                        .addResourceLocations("classpath:/test/");
            }
        };
    }

    //Bean qui permet d'afficher en console toutes les dépendances utilisées par l'application
//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext applicationContext) {
//		return args -> {
//
//			String[] noms = applicationContext.getBeanDefinitionNames();
//
//			for (String nom : noms) {
//				System.out.println(nom + " : " + applicationContext.getBean(nom).getClass().getSimpleName());
//			}
//		};
//	}
}
