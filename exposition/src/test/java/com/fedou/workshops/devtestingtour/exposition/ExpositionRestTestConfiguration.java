package com.fedou.workshops.devtestingtour.exposition;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@AutoConfigureWebMvc
//@EnableAutoConfiguration
//@ComponentScan
public class ExpositionRestTestConfiguration extends ExpositionRestConfiguration {
//    @Bean
//    SecurityContext testSecuritycontext() {
//        return SecurityContextHolder.createEmptyContext();
//    }
}
