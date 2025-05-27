package com.proyectoestructura.estructuraDatos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class EstructuraDatosApplication {
	public static void main(String[] args) {
		SpringApplication.run(EstructuraDatosApplication.class, args);
	}

}
