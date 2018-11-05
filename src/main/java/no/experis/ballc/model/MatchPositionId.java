package no.experis.ballc.model;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class MatchPositionId implements Serializable {
    @ManyToOne(cascade = CascadeType.ALL)
    private Player player;

    @ManyToOne(cascade = CascadeType.ALL)
    private Match footballMatch;

    public int getPlayer() {
        return player.getPlayer_id();
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getFootballMatch() {
        return footballMatch.getMatch_id();
    }

    public void setFootballMatch(Match footballMatch) {
        this.footballMatch = footballMatch;
    }
}
