package no.experis.ballc.model;

import javax.persistence.*;

@Entity
@Table(name = "MATCH_POSITION")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.player",
                joinColumns = @JoinColumn(name = "player_id")),
        @AssociationOverride(name = "primaryKey.footballMatch",
                joinColumns = @JoinColumn(name = "match_id")) })
public class MatchPosition {
    @EmbeddedId
    private MatchPositionId primaryKey = new MatchPositionId();
    private String position;

    public MatchPositionId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(MatchPositionId primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Transient
    public Player getPlayer() {
        return getPrimaryKey().getPlayer();
    }

    public void setPlayer(Player player) {
        getPrimaryKey().setPlayer(player);
    }

    @Transient
    public Match getFootballMatch() {
        return getPrimaryKey().getFootballMatch();
    }

    public void setFootballMatch(Match footballMatch) {
        getPrimaryKey().setFootballMatch(footballMatch);
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
