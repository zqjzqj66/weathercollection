package com.imooc.weatherssss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WeatherssssApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherssssApplication.class, args);
	}

}
