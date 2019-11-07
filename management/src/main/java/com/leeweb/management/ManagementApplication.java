package com.leeweb.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication	//@SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan
public class ManagementApplication {

	/**
	 * @author イーソンハク
	 * @since 2019.10.25
	 * @version 3.23
	 */
	public static void main(String[] args) {
		SpringApplication.run(ManagementApplication.class, args);
	}
}
