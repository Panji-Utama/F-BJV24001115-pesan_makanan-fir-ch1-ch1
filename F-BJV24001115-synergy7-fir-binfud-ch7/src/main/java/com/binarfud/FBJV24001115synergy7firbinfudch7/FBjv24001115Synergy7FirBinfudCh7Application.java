package com.binarfud.FBJV24001115synergy7firbinfudch7;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FBjv24001115Synergy7FirBinfudCh7Application {

	public static void main(String[] args) {
		EnvLoader.load();
		SpringApplication.run(FBjv24001115Synergy7FirBinfudCh7Application.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

//	public static void main(String[] args) {
//		UserController userController = SpringApplication.run(FBjv24001115Synergy7FirBinfudCh7Application.class, args).getBean(UserController.class);
//		userController.startApplication();
//	}

}
