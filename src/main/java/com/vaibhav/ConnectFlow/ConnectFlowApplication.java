package com.vaibhav.ConnectFlow;

import com.vaibhav.ConnectFlow.user.User;
import com.vaibhav.ConnectFlow.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConnectFlowApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnectFlowApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (UserService userService) {
		return args -> {
			userService.register(User.builder()
							.username("Vaibhav")
							.email("vaibhav@gmail.com")
							.password("vvv")
					.build());

			userService.register(User.builder()
					.username("Abhay")
					.email("abhay@gmail.com")
					.password("aaa")
					.build());

			userService.register(User.builder()
					.username("Vandana")
					.email("vandana@gmail.com")
					.password("vvv")
					.build());
		};
	}

}
