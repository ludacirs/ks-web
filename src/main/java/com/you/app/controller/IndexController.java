package com.you.app.controller;

import com.you.app.entity.Interests;
import com.you.app.entity.Person;
import com.you.app.repository.InterestsRepository;
import com.you.app.repository.PersonRepository;
import com.you.app.repository.SocialMediaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {
    private final SocialMediaRepository socialMediaRepository;
    private final PersonRepository personRepository;
    private final InterestsRepository interestsRepository;

    public IndexController(SocialMediaRepository socialMediaRepository, PersonRepository personRepository, InterestsRepository interestsRepository) {
        this.socialMediaRepository = socialMediaRepository;
        this.personRepository = personRepository;
        this.interestsRepository = interestsRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        Person person = personRepository.findAll().stream().findFirst().orElse(null);
        model.addAttribute("person", person);

        List<Interests> interests = interestsRepository.findAll();
        model.addAttribute("interests", interests);

        model.addAttribute("socialMedia", socialMediaRepository.findAll().stream().findFirst().orElse(null));
        return "resume";
    }
}