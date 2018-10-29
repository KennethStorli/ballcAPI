package no.experis.ballc.model;

import javax.persistence.*;

@Entity
@Table(name = "COACH")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public int getPerson() {
        return person.getPerson_id();
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getTeam() {
        return team.getTeam_id();
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
