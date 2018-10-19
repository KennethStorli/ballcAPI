package no.experis.ballc.model;

import javax.persistence.*;

@Entity
@Table(name = "OWNER")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int owner_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToOne(mappedBy = "owner")
    private Team team;

    public Owner() {
    }
}
