/*
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

    public Player(String normal_position, int number, Person person, Team team, Set<MatchGoal> matchGoals, Set<MatchPosition> matchPositions) {
        this.normal_position = normal_position;
        this.number = number;
        this.person = person;
        this.team = team;
        this.matchGoals = matchGoals;
        this.matchPositions = matchPositions;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public String getNormal_position() {
        return normal_position;
    }

    public int getNumber() {
        return number;
    }

    public Person getPerson() {
        return person;
    }

    public Team getTeam() {
        return team;
    }

    public Set<MatchGoal> getMatchGoals() {
        return matchGoals;
    }

    public Set<MatchPosition> getMatchPositions() {
        return matchPositions;
    }
}
*/
