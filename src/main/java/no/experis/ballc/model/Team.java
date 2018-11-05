package no.experis.ballc.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TEAM")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private int id;

    private String team_name;

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
    private Set<Match> home_matches = new HashSet<>();

    @OneToMany(mappedBy = "away_team", cascade = CascadeType.ALL)
    private Set<Match> away_matches = new HashSet<>();

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private Set<Player> players = new HashSet<>();

    @OneToMany(mappedBy = "primaryKey.team", cascade = CascadeType.ALL)
    private Set<Result> results = new HashSet<>();

    public Team() {
    }

    public Team(String teamName, Association association, Coach coach, Owner owner, Location location) {
        this.team_name = teamName;
        this.association = association;
        this.coach = coach;
        this.owner = owner;
        this.location = location;
    }

    public int getTeam_id() {
        return id;
    }

    public String getTeamName() {
        return team_name;
    }

    public void setTeamName(String teamName) {
        this.team_name = teamName;
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

    public Set<Integer> getHome_matches() {
        Set<Integer> homeMatchIds = new HashSet<>();
        for(Match homeMatch : home_matches) {
            homeMatchIds.add(homeMatch.getMatch_id());
        }
        return homeMatchIds;
    }

    public void setHome_matches(Set<Match> home_matches) {
        this.home_matches = home_matches;
    }

    public Set<Integer> getAway_matches() {
        Set<Integer> awayMatchIds = new HashSet<>();
        for(Match awayMatch : away_matches) {
            awayMatchIds.add(awayMatch.getMatch_id());
        }
        return awayMatchIds;
    }

    public void setAway_matches(Set<Match> away_matches) {
        this.away_matches = away_matches;
    }

    public Set<Integer> getPlayers() {
        Set<Integer> playerIds = new HashSet<>();
        for(Player player : players) {
            playerIds.add(player.getPlayer_id());
        }
        return playerIds;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

/*    public Set<Integer> getResults() {
        Set<Integer> resultIds = new HashSet<>();
        for(Result result : results) {
            resultIds.add(result);
        }
        return playerIds;
    }

    public void setResults(Set<Result> results) {
        this.results = results;
    }*/
}
