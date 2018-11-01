package no.experis.ballc.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class ResultId implements Serializable {
    @ManyToOne(cascade = CascadeType.ALL)
    private Team team;

    @ManyToOne(cascade = CascadeType.ALL)
    private Match footballMatch;

    public int getTeam() {
        return team.getTeam_id();
    }



    public void setTeam(Team team) {
        this.team = team;
    }

    public int getFootballMatch() {
        return footballMatch.getMatch_id();
    }

    public void setFootballMatch(Match footballMatch) {
        this.footballMatch = footballMatch;
    }


}
