package com.example.deploykub;

import com.example.deploykub.entity.Person;
import com.example.deploykub.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@AllArgsConstructor
public class DeploykubApplication implements CommandLineRunner {

	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(DeploykubApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Person person = Person.builder()
				.code(1L)
				.name("Joe")
				.city("London")
				.build();

		personRepository.save(person);
	}
}
