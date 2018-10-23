package no.experis.ballc.controller;


import no.experis.ballc.model.Person;
import no.experis.ballc.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonJpaRepository personRepository;
    @Autowired
    TeamJpaRepository teamRepository;
    @Autowired
    PlayerJpaRepository playerRepository;
    @Autowired
    CoachJpaRepository coachRepository;
    @Autowired
    OwnerJpaRepository ownerRepository;
    @Autowired
    ContactJpaRepository contactRepository;
    @Autowired
    AssociationJpaRepository associationRepository;


    @GetMapping("/person")
    public List<Person> getAllPersons(){
        List<Person> test = personRepository.findAll();
        return test;
    }
}
