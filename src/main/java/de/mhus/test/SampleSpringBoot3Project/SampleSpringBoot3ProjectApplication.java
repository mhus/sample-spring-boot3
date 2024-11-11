package de.mhus.test.SampleSpringBoot3Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportRuntimeHints;

@SpringBootApplication
@ImportRuntimeHints(MyRuntimeHints.class)
public class SampleSpringBoot3ProjectApplication {

	@Bean
	public AnswerBean answerBean() {
		return new AnswerBean();
	}

	public static void main(String[] args) {
		SpringApplication.run(SampleSpringBoot3ProjectApplication.class, args);
	}

}
