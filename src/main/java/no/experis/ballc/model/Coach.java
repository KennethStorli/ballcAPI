package no.experis.ballc.model;

import javax.persistence.*;

@Entity
@Table(name = "COACH")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int coach_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToOne(mappedBy = "coach")
    private Team team;

    public Coach() {
    }

}
