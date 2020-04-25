package com.you.app.controller;

import com.you.app.entity.Person;
import com.you.app.entity.SocialMedia;
import com.you.app.repository.PersonRepository;
import com.you.app.repository.SocialMediaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    private final SocialMediaRepository socialMediaRepository;
    private final PersonRepository personRepository;

    public IndexController(SocialMediaRepository socialMediaRepository, PersonRepository personRepository) {
        this.socialMediaRepository = socialMediaRepository;
        this.personRepository = personRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        Person person = personRepository.findAll().stream().findFirst().orElse(null);
        model.addAttribute("person", person);

        model.addAttribute("socialMedia", socialMediaRepository.findAll().stream().findFirst().orElse(null));
        return "resume";
    }
}