package no.experis.ballc.controller;


import no.experis.ballc.model.Person;
import no.experis.ballc.repository.PersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonJpaRepository personRepository;

    @GetMapping("/person")
    public List<Person> getAllPersons(){
        List<Person> test = personRepository.findAll();
        return test;
    }
}
