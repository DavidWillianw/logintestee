package com.loginteste2.logintestee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LogintesteeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogintesteeApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserService userService) {
		return (args) -> {

			user usuarioTeste = new user();
			usuarioTeste.setUsername("David");
			usuarioTeste.setSenha("123");

			userService.adicionarUsuario(usuarioTeste);
		};

	}
}
