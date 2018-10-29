package no.experis.ballc.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ADDRESS")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Set<Person> persons = new HashSet<>();

    @OneToOne(mappedBy = "address")
    private Location location;

    public Address() {
    }

    public Address(String address_line_1, String postal_code, String city) {
        this.address_line_1 = address_line_1;
        this.postal_code = postal_code;
        this.city = city;
    }

    public Address(String address_line_1, String address_line_2, String postal_code, String city, String country, String address_line_3, Location location) {
        this.address_line_1 = address_line_1;
        this.address_line_2 = address_line_2;
        this.postal_code = postal_code;
        this.city = city;
        this.country = country;
        this.address_line_3 = address_line_3;
        this.location = location;
    }

    public int getAddress_id() {
        return address_id;
    }

    public String getAddress_line_1() {
        return address_line_1;
    }

    public void setAddress_line_1(String address_line_1) {
        this.address_line_1 = address_line_1;
    }

    public String getAddress_line_2() {
        return address_line_2;
    }

    public void setAddress_line_2(String address_line_2) {
        this.address_line_2 = address_line_2;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress_line_3() {
        return address_line_3;
    }

    public void setAddress_line_3(String address_line_3) {
        this.address_line_3 = address_line_3;
    }

    public Set<Integer> getPersons() {
        Set<Integer> personIds = new HashSet<>();
        for(Person person : persons) {
            personIds.add(person.getPerson_id());
        }
        return personIds;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    public int getLocation() {
        int test = location.getLocation_id();
        return test;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
