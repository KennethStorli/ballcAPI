package no.experis.ballc.model;

import javax.persistence.*;

@Entity
@Table(name = "MATCH_GOAL")
public class MatchGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int goal_id;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goal_type_id")
    private GoalType goalType;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match footballMatch;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    public MatchGoal() {
    }

    public MatchGoal(String description, GoalType goalType, Match footballMatch, Player player) {
        this.description = description;
        this.goalType = goalType;
        this.footballMatch = footballMatch;
        this.player = player;
    }

    public int getGoal_id() {
        return goal_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGoalType() {
        return goalType.getGoal_type_id();
    }

    public void setGoalType(GoalType goalType) {
        this.goalType = goalType;
    }

    public int getFootballMatch() {
        return footballMatch.getMatch_id();
    }

    public void setFootballMatch(Match footballMatch) {
        this.footballMatch = footballMatch;
    }

    public int getPlayer() {
        return player.getPlayer_id();
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
