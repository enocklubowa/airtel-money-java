package com.enocklubowa.airtelmoneyjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class AirtelMoneyJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirtelMoneyJavaApplication.class, args);
	}

}
