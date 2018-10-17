package no.experis.ballc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int match_id;
    private Date match_date;
    private int season_id;
    private int location_id;
    private int home_team_id;
    private int away_team_id;

    public Match() {
    }

    public Match(Date match_date, int season_id, int location_id, int home_team_id, int away_team_id) {
        this.match_date = match_date;
        this.season_id = season_id;
        this.location_id = location_id;
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

    public int getLocation_id() {
        return location_id;
    }

    public int getHome_team_id() {
        return home_team_id;
    }

    public int getAway_team_id() {
        return away_team_id;
    }
}
