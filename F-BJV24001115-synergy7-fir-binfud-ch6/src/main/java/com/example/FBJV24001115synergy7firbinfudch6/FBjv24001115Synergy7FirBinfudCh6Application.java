package com.example.FBJV24001115synergy7firbinfudch6;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FBjv24001115Synergy7FirBinfudCh6Application {

	public static void main(String[] args) {
		SpringApplication.run(FBjv24001115Synergy7FirBinfudCh6Application.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

//	public static void main(String[] args) {
//		UserController userController = SpringApplication.run(FBjv24001115Synergy7FirBinfudCh6Application.class, args).getBean(UserController.class);
//		userController.startApplication();
//	}

}
