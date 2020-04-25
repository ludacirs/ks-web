package com.you.app;

import com.you.app.entity.Person;
import com.you.app.repository.PersonRepository;
import org.hibernate.dialect.lock.PessimisticEntityLockException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {
	private final PersonRepository personRepository;

	public AppApplication(PersonRepository personRepository) {//요부분 이해 안됨
		this.personRepository = personRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		personRepository.save(new Person("유제호","프론트", "hello@test.com", "010-1234-5678"));
	}
}