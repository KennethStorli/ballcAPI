package no.experis.ballc.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int match_id;
    private Date match_date;
    private int season_id;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    private int home_team_id;
    private int away_team_id;


    public Match() {
    }

    public Match(Date match_date, int season_id, Location location, int home_team_id, int away_team_id) {
        this.match_date = match_date;
        this.season_id = season_id;
        this.location = location;
        this.home_team_id = home_team_id;
        this.away_team_id = away_team_id;
    }

    public int getMatch_id() {
        return match_id;
    }

    public Date getMatch_date() {
        return match_date;
    }

    public int getSeason_id() {
        return season_id;
    }

    public Location getLocation() {
        return location;
    }

    public int getHome_team_id() {
        return home_team_id;
    }

    public int getAway_team_id() {
        return away_team_id;
    }
}
