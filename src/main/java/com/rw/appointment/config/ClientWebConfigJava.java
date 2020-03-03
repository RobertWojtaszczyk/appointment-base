package com.rw.appointment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// https://www.baeldung.com/spring-validate-requestparam-pathvariable
// If we're using a Spring Boot application, then this bean is auto-configured if we have the hibernate-validator dependency on our classpath.
//@EnableWebMvc
//@Configuration
public class ClientWebConfigJava { //implements WebMvcConfigurer {
    //@Bean
    /*public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }*/
    // ...
}
