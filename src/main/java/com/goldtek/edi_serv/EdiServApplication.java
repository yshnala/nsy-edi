package com.goldtek.edi_serv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EdiServApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdiServApplication.class, args);
	}

}
