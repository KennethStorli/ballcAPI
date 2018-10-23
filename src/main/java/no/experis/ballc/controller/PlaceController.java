package no.experis.ballc.controller;

import no.experis.ballc.repository.AddressJpaRepository;
import no.experis.ballc.repository.LocationJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaceController {

    @Autowired
    LocationJpaRepository locationRepository;
    @Autowired
    AddressJpaRepository addressRepository;
}
