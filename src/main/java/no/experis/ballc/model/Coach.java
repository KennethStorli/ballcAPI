package no.experis.ballc.model;

import javax.persistence.*;

@Entity
@Table(name = "COACH")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int coach_id;
    private int person_id;

    public Coach() {
    }

    public Coach(int person_id) {
        this.person_id = person_id;
    }

    public int getCoach_id() {
        return coach_id;
    }

    public int getPerson_id() {
        return person_id;
    }
}
