package com.example.deploykub.controller;


import com.example.deploykub.entity.Person;
import com.example.deploykub.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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


    @PostMapping("/createPerson")
    private Person createPerson(@RequestBody Person person){
        return personRepository.save(person);
    }
}
