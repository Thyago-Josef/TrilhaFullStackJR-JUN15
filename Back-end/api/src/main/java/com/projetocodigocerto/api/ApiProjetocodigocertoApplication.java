package com.projetocodigocerto.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(/*scanBasePackages = "com.projetocodigocerto.api",*/ exclude = {UserDetailsServiceAutoConfiguration.class})
//@EnableJpaRepositories("com.projetocodigocerto.api.repositories")
public class ApiProjetocodigocertoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiProjetocodigocertoApplication.class, args);
	}

}
