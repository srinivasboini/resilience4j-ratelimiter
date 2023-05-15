package com.srini.ratelimit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Resilience 4 j ratelimiter application.
 */
@SpringBootApplication
public class Resilience4jRatelimiterApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(Resilience4jRatelimiterApplication.class, args);
	}

}
