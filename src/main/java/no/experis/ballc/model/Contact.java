package no.experis.ballc.model;

import javax.persistence.*;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int contact_id;
    private String contact_type;
    private String contact_detail;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;


}
