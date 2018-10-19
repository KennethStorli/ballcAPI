package no.experis.ballc.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ADDRESS")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String address_id;
    private String address_line_1;
    private String address_line_2;
    private String postal_code;
    private String city;
    private String country;
    private String address_line_3;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private Set<Person> persons;

    @OneToOne(mappedBy = "address")
    private Location location;

    public Address() {
    }

}
