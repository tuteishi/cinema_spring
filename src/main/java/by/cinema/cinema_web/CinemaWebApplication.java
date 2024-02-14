package by.cinema.cinema_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CinemaWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaWebApplication.class, args);
	}

}
