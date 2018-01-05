package com.raven.croaker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CroakerApp {

    private static final Logger log = LoggerFactory.getLogger(CroakerApp.class);

	public static void main(String[] args) {
		SpringApplication.run(CroakerApp.class, args);

        log.info("\n----------------------------------------------------------\n\t"
                + "Application is running!" +
                "\n----------------------------------------------------------");
	}
}
