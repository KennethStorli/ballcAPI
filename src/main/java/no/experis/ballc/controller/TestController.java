package no.experis.ballc.controller;

import no.experis.ballc.model.Test;
import no.experis.ballc.repository.TestJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    TestJpaRepository testRepository;

    @GetMapping("/test")
    @CrossOrigin(origins = "*")
    public List<Test> getAllPersons(){
        return testRepository.findAll();
    }

    @PostMapping("/test")
    @CrossOrigin(origins = "*")
    public Test create(@RequestBody Test test){
        return testRepository.save(test);
    }
}
