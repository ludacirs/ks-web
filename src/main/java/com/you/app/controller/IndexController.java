package com.you.app.controller;

import com.you.app.entity.Person;
import com.you.app.repository.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final PersonRepository personRepository;
    public IndexController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @GetMapping("/")
    public String index(Model model) {
        Person person = personRepository.findAll().stream().findFirst().orElse(null);
        model.addAttribute("person", person);
        return "resume";
    }
}