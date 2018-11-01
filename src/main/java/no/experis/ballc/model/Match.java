package no.experis.ballc.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "FOOTBALL_MATCH")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int match_id;
    private LocalDate match_date;

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
    @JoinColumn(name = "away_team_id"/*, insertable=false, updatable=false*/)
    private Team away_team;

    @OneToMany(mappedBy = "footballMatch", cascade = CascadeType.ALL)
    private Set<MatchGoal> matchGoals = new HashSet<>();

    @OneToMany(mappedBy = "primaryKey.footballMatch", cascade = CascadeType.ALL)
    private Set<MatchPosition> matchPositions = new HashSet<>();

    @OneToMany(mappedBy = "primaryKey.footballMatch", cascade = CascadeType.ALL)
    private Set<Result> results = new HashSet<>();

    public Match() {
    }

    public Match(LocalDate match_date, Season season, Location location, Team home_team, Team away_team) {
        this.match_date = match_date;
        this.season = season;
        this.location = location;
        this.home_team = home_team;
        this.away_team = away_team;
    }

    public int getMatch_id() {
        return match_id;
    }

    public LocalDate getMatch_date() {
        return match_date;
    }

    public void setMatch_date(LocalDate match_date) {
        this.match_date = match_date;
    }

    public int getSeason() {
        return season.getSeason_id();
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public int getLocation() {
        return location.getLocation_id();
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getHome_team() {
        return home_team.getTeam_id();
    }

    public void setHome_team(Team home_team) {
        this.home_team = home_team;
    }

    public int getAway_team() {
        return away_team.getTeam_id();
    }

    public void setAway_team(Team away_team) {
        this.away_team = away_team;
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

/*
    public Set<Integer> getMatchPositions() {
        Set<Integer> matchPositionIds = new HashSet<>();
        for(MatchPosition matchPosition : matchPositions) {
            matchPositionIds.add(matchPosition.getPrimaryKey());
        }
        return matchPositionIds;
    }
*/

    public void setMatchPositions(Set<MatchPosition> matchPositions) {
        this.matchPositions = matchPositions;
    }

    public Set<ResultId> getResults() {
        Set<ResultId> retVar = new HashSet<ResultId>();
        for (Result res: results) {
            retVar.add(res.getPrimaryKey());
        }
        return retVar;
    }

    public void setResults(Set<Result> results) {
        this.results = results;
    }
}
