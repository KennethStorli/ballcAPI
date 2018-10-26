package no.experis.ballc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TEAM")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int team_id;

    @ManyToOne
    @JoinColumn(name = "association_id")
    @JsonIgnore
    private Association association;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coach_id")
    @JsonIgnore
    private Coach coach;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    @JsonIgnore
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "location_id")
    @JsonIgnore
    private Location location;

    @OneToMany(mappedBy = "home_team", cascade = CascadeType.ALL)
    private Set<Match> home_matches;

    @OneToMany(mappedBy = "away_team", cascade = CascadeType.ALL)
    private Set<Match> away_matches;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private Set<Player> players;

    @OneToMany(mappedBy = "primaryKey.team", cascade = CascadeType.ALL)
    private Set<Result> results;

    public Team() {
    }

    public Team(Association association, Coach coach, Owner owner, Location location) {
        this.association = association;
        this.coach = coach;
        this.owner = owner;
        this.location = location;
    }

    public int getTeam_id() {
        return team_id;
    }

    public int getAssociation() {
        return association.getAssociation_id();
    }

    public void setAssociation(Association association) {
        this.association = association;
    }

    public int getCoach() {
        return coach.getCoach_id();
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public int getOwner() {
        return owner.getOwner_id();
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public int getLocation() {
        return location.getLocation_id();
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<Match> getHome_matches() {
        return home_matches;
    }

    public void setHome_matches(Set<Match> home_matches) {
        this.home_matches = home_matches;
    }

    public Set<Match> getAway_matches() {
        return away_matches;
    }

    public void setAway_matches(Set<Match> away_matches) {
        this.away_matches = away_matches;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public Set<Result> getResults() {
        return results;
    }

    public void setResults(Set<Result> results) {
        this.results = results;
    }
}
