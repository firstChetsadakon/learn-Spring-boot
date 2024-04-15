package com.firstcode.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@SpringBootApplication
		(
		scanBasePackages = {"com.firstcode.springboot",
							"com.firstcode.util"}) */
@SpringBootApplication
public class DemoinjectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoinjectionApplication.class, args);
	}
}
