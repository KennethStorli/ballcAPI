package no.experis.ballc.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "FOOTBALL_MATCH")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int match_id;
    private Date match_date;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "home_team_id")
    private Team home_team;

    @ManyToOne
    @JoinColumn(name = "away_team_id", insertable=false, updatable=false)
    private Team away_team;

    @OneToMany(mappedBy = "footballMatch", cascade = CascadeType.ALL)
    private Set<MatchGoal> matchGoals;

    @OneToMany(mappedBy = "primaryKey.footballMatch", cascade = CascadeType.ALL)
    private Set<MatchPosition> matchPositions;

    @OneToMany(mappedBy = "primaryKey.footballMatch", cascade = CascadeType.ALL)
    private Set<Result> results;

    public Match() {
    }

    public Match(Date match_date, Season season, Location location, Team home_team, Team away_team) {
        this.match_date = match_date;
        this.season = season;
        this.location = location;
        this.home_team = home_team;
        this.away_team = away_team;
    }

    public int getMatch_id() {
        return match_id;
    }

    public Date getMatch_date() {
        return match_date;
    }

    public void setMatch_date(Date match_date) {
        this.match_date = match_date;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Team getHome_team() {
        return home_team;
    }

    public void setHome_team(Team home_team) {
        this.home_team = home_team;
    }

    public Team getAway_team() {
        return away_team;
    }

    public void setAway_team(Team away_team) {
        this.away_team = away_team;
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

    public Set<Result> getResults() {
        return results;
    }

    public void setResults(Set<Result> results) {
        this.results = results;
    }
}
