package com.app.upe.myproject.mypokedexapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class MyPokedexApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyPokedexApiApplication.class, args);
	}

}
