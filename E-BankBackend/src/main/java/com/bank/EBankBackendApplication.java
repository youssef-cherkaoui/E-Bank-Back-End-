package com.bank;

import com.bank.Model.RegisterRequest;
import com.bank.Service.AuthenticationService;
import lombok.Builder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.bank.Model.Role.ADMIN;
import static com.bank.Model.Role.MANAGER;

@SpringBootApplication
public class EBankBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EBankBackendApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			var admin = RegisterRequest.builder()
					.Name("Admin")
					.email("Admin@gmail.com")
					.password("Admin123")
					.role(ADMIN)
					.build();
			System.out.println("Admin: " + service.register(admin).getToken());


//			var manager = RegisterRequest.builder()
//					.Name("Admin")
//					.email("Admin@admin.com")
//					.password("password")
//					.role(MANAGER)
//					.build();
//			System.out.println("Admin token" + service.register(manager).getToken());
		};




	}
}
