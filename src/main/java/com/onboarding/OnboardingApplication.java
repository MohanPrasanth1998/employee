package com.onboarding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableJpaAuditing
@EnableWebMvc
public class OnboardingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnboardingApplication.class, args);
	}
/*	@SuppressWarnings("deprecation")
	@Bean
	public Docket swaggerAppConfig() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any()).apis(RequestHandlerSelectors
				.basePackage("com.onboarding")).build().apiInfo(new
						ApiInfo("Job Portal", "Job portal", "1.0", "Terms", "Abytz", "Abytz Licence", "Licence URL"));  
	}  
	@Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.onboarding")).build();
	   }*/

}
