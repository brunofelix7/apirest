package com.products.apirest;

import com.products.apirest.seed.ProductSeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApirestApplication implements CommandLineRunner {

	@Autowired
	private ProductSeed productSeed;

	public static void main(String[] args) {
		SpringApplication.run(ApirestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.productSeed.seed();
	}

	/* Heroku - JWT - S3 - Docker - Email - JavaDoc	- mLab (prod) */

}
