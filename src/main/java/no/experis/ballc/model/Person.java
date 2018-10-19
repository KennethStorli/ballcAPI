package no.experis.ballc.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "PERSON")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int person_id;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    private String first_name;
    private String last_name;
    private Date date_of_birth;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<Contact> contacts;

    @OneToOne(mappedBy = "person")
    private Player player;

    @OneToOne(mappedBy = "person")
    private Coach coach;

    @OneToOne(mappedBy = "person")
    private Owner owner;

}
