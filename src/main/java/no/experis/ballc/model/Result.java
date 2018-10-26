package no.experis.ballc.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RESULT")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.team",
                joinColumns = @JoinColumn(name = "team_id")),
        @AssociationOverride(name = "primaryKey.match",
                joinColumns = @JoinColumn(name = "match_id")) })
public class Result implements Serializable {
    @EmbeddedId
    private ResultId primaryKey = new ResultId();
    private int score;
    private String result;

    public ResultId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(ResultId primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Transient
    public Team getTeam() {
        return getPrimaryKey().getTeam();
    }

    public void setTeam(Team team) {
        getPrimaryKey().setTeam(team);
    }

    @Transient
    public Match getMatch() {
        return getPrimaryKey().getMatch();
    }

    public void setMatch(Match match) {
        getPrimaryKey().setMatch(match);
    }
}
