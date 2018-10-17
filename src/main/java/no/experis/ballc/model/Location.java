package no.experis.ballc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int location_id;
    private String name;
    private String description;
    private String address_id;

    public Location() {
    }

    public Location(String name, String description, String address_id) {
        this.name = name;
        this.description = description;
        this.address_id = address_id;
    }

    public int getLocation_id() {
        return location_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress_id() {
        return address_id;
    }
}
