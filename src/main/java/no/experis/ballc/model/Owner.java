/*
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

    public Owner(Person person, Team team) {
        this.person = person;
        this.team = team;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public Person getPerson() {
        return person;
    }

    public Team getTeam() {
        return team;
    }
}
*/
