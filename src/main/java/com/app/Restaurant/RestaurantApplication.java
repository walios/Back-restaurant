package com.app.Restaurant;

import com.app.Restaurant.serviceimpl.ApiService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class RestaurantApplication {
	public static ApiService apiService;
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(RestaurantApplication.class, args);

		 apiService = context.getBean(ApiService.class);
	}

}
