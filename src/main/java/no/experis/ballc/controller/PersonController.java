package no.experis.ballc.controller;


import no.experis.ballc.model.Address;
import no.experis.ballc.model.Person;
import no.experis.ballc.model.Test;
import no.experis.ballc.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    PersonJpaRepository personRepository;
    @Autowired
    AddressJpaRepository addressRepository;
/*
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
*/


    @GetMapping("/persons")
    public List<Person> getAllPersons(){
        List<Person> test =  personRepository.findAll();
        return test;
    }

    @GetMapping("/persons/{id}")
    public Person getPersons(@PathVariable int id){
        Optional<Person> person = personRepository.findById(id);
        return person.get();
    }

    @PostMapping("/persons")
//    @CrossOrigin(origins = "*")
    public Person createPerson(@RequestBody Map<String, String> body) throws ParseException {
        Optional<Address> address = addressRepository.findById(Integer.parseInt(body.get("address")));
        String first_name = body.get("first_name");
        String last_name = body.get("last_name");
        return personRepository.save(new Person(address.get(), first_name, last_name, parseDate(body.get("date_of_birth"))));
    }

    @PutMapping("/persons/{id}")
    public Person updatePerson(@PathVariable int id,
                           @RequestBody Map<String, String> body) throws ParseException {

        Optional<Address> address = addressRepository.findById(Integer.parseInt(body.get("address")));
        Optional<Person> personResponse = personRepository.findById(id);
        Person person = personResponse.get();

        person.setAddress(address.get());
        person.setFirst_name(body.get("first_name"));
        person.setLast_name(body.get("last_name"));
        person.setDate_of_birth(parseDate(body.get("date_of_birth")));
        return personRepository.save(person);
    }

    @DeleteMapping("/persons/{id}")
    public void deletePerson(@PathVariable int id) {
        personRepository.deleteById(id);
    }

    private Date parseDate(String dateString) throws ParseException {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.parse(dateString);
    }
}
