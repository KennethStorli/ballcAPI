/*
package no.experis.ballc.model;

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
    private Association association;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coach_id")
    private Coach coach;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "location_id")
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

    public Team(Association association, Coach coach, Owner owner, Location location, Set<Match> home_matches, Set<Match> away_matches, Set<Player> players, Set<Result> results) {
        this.association = association;
        this.coach = coach;
        this.owner = owner;
        this.location = location;
        this.home_matches = home_matches;
        this.away_matches = away_matches;
        this.players = players;
        this.results = results;
    }

    public int getTeam_id() {
        return team_id;
    }

    public Association getAssociation() {
        return association;
    }

    public Coach getCoach() {
        return coach;
    }

    public Owner getOwner() {
        return owner;
    }

    public Location getLocation() {
        return location;
    }

    public Set<Match> getHome_matches() {
        return home_matches;
    }

    public Set<Match> getAway_matches() {
        return away_matches;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public Set<Result> getResults() {
        return results;
    }
}
*/
