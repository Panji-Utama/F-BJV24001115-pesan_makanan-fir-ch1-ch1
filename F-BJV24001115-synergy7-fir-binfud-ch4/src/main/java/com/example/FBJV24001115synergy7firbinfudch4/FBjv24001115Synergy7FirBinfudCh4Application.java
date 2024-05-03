package com.example.FBJV24001115synergy7firbinfudch4;

import com.example.FBJV24001115synergy7firbinfudch4.controller.MerchantController;
import com.example.FBJV24001115synergy7firbinfudch4.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FBjv24001115Synergy7FirBinfudCh4Application {

	public static void main(String[] args) {
		UserController userController = SpringApplication.run(FBjv24001115Synergy7FirBinfudCh4Application.class, args).getBean(UserController.class);
		userController.startApplication();
	}
}
