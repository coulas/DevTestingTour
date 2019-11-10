package com.fedou.workshops.devtestingtour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@EnableWebMvc
@EnableWebSecurity
@EnableSwagger2
public class TrainReservationApplication {

	public static void main(String[] args) {
		run(TrainReservationApplication.class, args);
	}

}
