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

    public Coach(Person person, Team team) {
        this.person = person;
        this.team = team;
    }

    public int getCoach_id() {
        return coach_id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
