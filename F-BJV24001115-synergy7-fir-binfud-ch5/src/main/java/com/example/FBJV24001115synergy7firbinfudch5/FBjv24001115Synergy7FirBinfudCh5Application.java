package com.example.FBJV24001115synergy7firbinfudch5;

import com.example.FBJV24001115synergy7firbinfudch5.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FBjv24001115Synergy7FirBinfudCh5Application {

//	public static void main(String[] args) {
//		SpringApplication.run(FBjv24001115Synergy7FirBinfudCh5Application.class, args);
//	}

	public static void main(String[] args) {
		UserController userController = SpringApplication.run(FBjv24001115Synergy7FirBinfudCh5Application.class, args).getBean(UserController.class);
		userController.startApplication();
	}

}
