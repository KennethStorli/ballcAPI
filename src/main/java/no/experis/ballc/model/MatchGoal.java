package no.experis.ballc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MatchGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int goal_id;
    private String description;
    private int goal_type_id;
    private int match_id;
    private int player_id;

    public MatchGoal() {
    }

    public MatchGoal(String description, int goal_type_id, int match_id, int player_id) {
        this.description = description;
        this.goal_type_id = goal_type_id;
        this.match_id = match_id;
        this.player_id = player_id;
    }

    public int getGoal_id() {
        return goal_id;
    }

    public String getDescription() {
        return description;
    }

    public int getGoal_type_id() {
        return goal_type_id;
    }

    public int getMatch_id() {
        return match_id;
    }

    public int getPlayer_id() {
        return player_id;
    }
}
