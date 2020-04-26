package com.you.app;

import com.you.app.entity.*;
import com.you.app.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {
	private final PersonRepository personRepository;
	private final SocialMediaRepository socialMediaRepository;
	private final InterestsRepository interestsRepository;
	private final SkillRepository skillRepository;
	private final WorkRepository workRepositor;


	public AppApplication(PersonRepository personRepository, SocialMediaRepository socialMediaRepository, InterestsRepository interestsRepository, SkillRepository skillRepository, WorkRepository workRepositor) {//요부분 이해 안됨
		this.personRepository = personRepository;
		this.socialMediaRepository = socialMediaRepository;
        this.interestsRepository = interestsRepository;
		this.skillRepository = skillRepository;
		this.workRepositor = workRepositor;
	}

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		socialMediaRepository.save(new SocialMedia("anonymous", "anonymous"));

		personRepository.save(new Person("유제호","프론트", "hello@test.com", "010-1234-5678"));

		interestsRepository.save(new Interests("cafe"));
		interestsRepository.save(new Interests("game"));
		interestsRepository.save(new Interests("sleep"));

		skillRepository.save(new Skill("Java",100));
		skillRepository.save(new Skill("JavaScript",100));

		workRepositor.save(new Work("front", "kakao", "3years", "null"));
		workRepositor.save(new Work("back", "naver", "5years", "null"));
	}
}