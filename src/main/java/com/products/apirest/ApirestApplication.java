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
	//	https://www.youtube.com/watch?v=-HYrUs1ZCLI
	//	https://www.youtube.com/watch?v=FLSdkP33Lwo&index=6&list=PL8iIphQOyG-D2FP9wkg12AavzmVRWEcnJ

}
