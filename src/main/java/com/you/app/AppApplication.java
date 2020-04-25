package com.you.app;

import com.you.app.entity.Person;
import com.you.app.entity.SocialMedia;
import com.you.app.repository.PersonRepository;
import com.you.app.repository.SocialMediaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {
	private final PersonRepository personRepository;
	private final SocialMediaRepository socialMediaRepository;

	public AppApplication(PersonRepository personRepository, SocialMediaRepository socialMediaRepository) {//요부분 이해 안됨
		this.personRepository = personRepository;
		this.socialMediaRepository = socialMediaRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		socialMediaRepository.save(new SocialMedia("anonymous", "anonymous"));
		personRepository.save(new Person("유제호","프론트", "hello@test.com", "010-1234-5678"));
	}
}