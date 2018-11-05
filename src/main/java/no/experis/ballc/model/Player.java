package no.experis.ballc.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PLAYER")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Set<MatchGoal> matchGoals = new HashSet<>();

    @OneToMany(mappedBy = "primaryKey.player", cascade = CascadeType.ALL)
    private Set<MatchPosition> matchPositions = new HashSet<>();

    public Player() {
    }

    public Player(String normal_position, int number, Person person, Team team) {
        this.normal_position = normal_position;
        this.number = number;
        this.person = person;
        this.team = team;
    }

    public int getPlayer_id() {
        return player_id;
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

    public Set<Integer> getMatchGoals() {
        Set<Integer> matchGoalIds = new HashSet<>();
        for(MatchGoal matchGoal : matchGoals) {
            matchGoalIds.add(matchGoal.getGoal_id());
        }
        return matchGoalIds;
    }

    public void setMatchGoals(Set<MatchGoal> matchGoals) {
        this.matchGoals = matchGoals;
    }

    public Set<MatchPositionId> getMatchPositions() {
        Set<MatchPositionId> matchPositionIds = new HashSet<>();
        for(MatchPosition matchPosition : matchPositions) {
            matchPositionIds.add(matchPosition.getPrimaryKey());
        }
        return matchPositionIds;
    }

    public void setMatchPositions(Set<MatchPosition> matchPositions) {
        this.matchPositions = matchPositions;
    }
}
