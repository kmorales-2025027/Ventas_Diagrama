package com.kevinmorales.ventas;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class VentasApplication implements CommandLineRunner {

    public static void main(String[] args) {
		SpringApplication.run(VentasApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        log.info("Api funcionando correctamente...");
    }
}
