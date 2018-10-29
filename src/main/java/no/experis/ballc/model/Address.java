package no.experis.ballc.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ADDRESS")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int address_id;
    private String address_line_1;
    private String address_line_2;
    private String postal_code;
    private String city;
    private String country;
    private String address_line_3;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "address",
            cascade = CascadeType.ALL)
    private Set<Person> persons;

    @OneToOne(mappedBy = "address")
    private Location location;

    public Address() {
    }

    public Address(String address_line_1, String postal_code, String city) {
        this.address_line_1 = address_line_1;
        this.postal_code = postal_code;
        this.city = city;
    }

    public Address(String address_line_1, String address_line_2, String postal_code, String city, String country, String address_line_3, Set<Person> persons, Location location) {
        this.address_line_1 = address_line_1;
        this.address_line_2 = address_line_2;
        this.postal_code = postal_code;
        this.city = city;
        this.country = country;
        this.address_line_3 = address_line_3;
        this.persons = persons;
        this.location = location;
    }

    public int getAddress_id() {
        return address_id;
    }

    public String getAddress_line_1() {
        return address_line_1;
    }

    public String getAddress_line_2() {
        return address_line_2;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress_line_3() {
        return address_line_3;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public Location getLocation() {
        return location;
    }
}
