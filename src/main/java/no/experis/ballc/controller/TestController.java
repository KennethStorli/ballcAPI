package no.experis.ballc.controller;


import no.experis.ballc.model.Test;
import no.experis.ballc.repository.TestJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    TestJpaRepository testRepository;

    @GetMapping("/test")
    public List<Test> getAllPersons(){
        return testRepository.findAll();
    }

    @PostMapping("/test")
    public Test create(@RequestBody Map<String, String> body){
        String name = body.get("name");
        return testRepository.save(new Test(name));
    }
}
