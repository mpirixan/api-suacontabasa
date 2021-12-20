package br.com.bancoamazonia.api.suacontabasa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;


@SpringBootApplication
@EnableJpaRepositories
@OpenAPIDefinition(info = @Info(description = "API - Sua Conta Basa", contact = @Contact(name = "Matheus Pirixan", email = "mpirixan@yahoo.com")))
public class ApiSuacontabasaApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ApiSuacontabasaApplication.class, args);
	}

}
