package com.you.app.controller;

import com.you.app.entity.Interests;
import com.you.app.entity.Person;
import com.you.app.entity.Skill;
import com.you.app.repository.InterestsRepository;
import com.you.app.repository.PersonRepository;
import com.you.app.repository.SkillRepository;
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
    private final SkillRepository skillRepository;

    public IndexController(SocialMediaRepository socialMediaRepository, PersonRepository personRepository, InterestsRepository interestsRepository, SkillRepository skillRepository) {
        this.socialMediaRepository = socialMediaRepository;
        this.personRepository = personRepository;
        this.interestsRepository = interestsRepository;
        this.skillRepository = skillRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        Person person = personRepository.findAll().stream().findFirst().orElse(null);
        model.addAttribute("person", person);

        model.addAttribute("socialMedia", socialMediaRepository.findAll().stream().findFirst().orElse(null));

        List<Interests> interests = interestsRepository.findAll();
        model.addAttribute("interests", interests);

        List<Skill> skills = skillRepository.findAll();
        model.addAttribute("skills", skills);

        return "resume";
    }
}