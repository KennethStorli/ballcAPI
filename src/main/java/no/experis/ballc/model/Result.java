package no.experis.ballc.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RESULT")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.team",
                joinColumns = @JoinColumn(name = "team_id")),
        @AssociationOverride(name = "primaryKey.footballMatch",
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
    public Match getFootballMatch() {
        return getPrimaryKey().getFootballMatch();
    }

    public void setFootballMatch(Match footballMatch) {
        getPrimaryKey().setFootballMatch(footballMatch);
    }
}
