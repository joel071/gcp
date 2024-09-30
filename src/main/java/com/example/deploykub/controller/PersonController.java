package com.example.deploykub.controller;


import com.example.deploykub.entity.Person;
import com.example.deploykub.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PersonController {

    private PersonRepository personRepository;

    @GetMapping("/getPersons")
    private List<Person> getPersons() {
        return personRepository.findAll();
    }
}
