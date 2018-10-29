package no.experis.ballc.controller;

import no.experis.ballc.model.Address;
import no.experis.ballc.repository.AddressJpaRepository;
//import no.experis.ballc.repository.LocationJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PlaceController {

/*    @Autowired
    LocationJpaRepository locationRepository;*/
    @Autowired
    AddressJpaRepository addressRepository;

/*    @GetMapping("/addresses")
    public List<Address> getAllAddresses(){
        List<Address> test =  addressRepository.findAll();
        return test;
    }

    @GetMapping("/addresses/{id}")
    public Address getAddress(@PathVariable int id){
        Optional<Address> address = addressRepository.findById(id);
        return address.get();
    }*/
}
