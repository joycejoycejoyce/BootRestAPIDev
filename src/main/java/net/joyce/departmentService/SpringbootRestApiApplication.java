package net.joyce.departmentService;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class SpringbootRestApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringbootRestApiApplication.class, args);
	}
	/* 这个 bean 就被 register 在我们这个 application context 下面了
	* */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
