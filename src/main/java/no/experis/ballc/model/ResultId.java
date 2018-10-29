package no.experis.ballc.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class ResultId implements Serializable {
    @ManyToOne(cascade = CascadeType.ALL)
    private Team team;

    @ManyToOne(cascade = CascadeType.ALL)
    private Match footballMatch;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Match getFootballMatch() {
        return footballMatch;
    }

    public void setFootballMatch(Match footballMatch) {
        this.footballMatch = footballMatch;
    }


}
