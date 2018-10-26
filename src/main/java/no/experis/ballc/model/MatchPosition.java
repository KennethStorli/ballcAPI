package no.experis.ballc.model;

import javax.persistence.*;

@Entity
@Table(name = "MATCH_POSITION")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.player",
                joinColumns = @JoinColumn(name = "player_id")),
        @AssociationOverride(name = "primaryKey.match",
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
    public Match getMatch() {
        return getPrimaryKey().getMatch();
    }

    public void setMatch(Match match) {
        getPrimaryKey().setMatch(match);
    }
}
