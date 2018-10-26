package no.experis.ballc.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "PLAYER")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int player_id;
    private String normal_position;
    private int number;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private Set<MatchGoal> matchGoals;

    @OneToMany(mappedBy = "primaryKey.player", cascade = CascadeType.ALL)
    private Set<MatchPosition> matchPositions;

    public Player() {
    }

    public Player(String normal_position, int number, Person person, Team team) {
        this.normal_position = normal_position;
        this.number = number;
        this.person = person;
        this.team = team;
    }

    public String getNormal_position() {
        return normal_position;
    }

    public void setNormal_position(String normal_position) {
        this.normal_position = normal_position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    public Set<MatchGoal> getMatchGoals() {
        return matchGoals;
    }

    public void setMatchGoals(Set<MatchGoal> matchGoals) {
        this.matchGoals = matchGoals;
    }

    public Set<MatchPosition> getMatchPositions() {
        return matchPositions;
    }

    public void setMatchPositions(Set<MatchPosition> matchPositions) {
        this.matchPositions = matchPositions;
    }
}
