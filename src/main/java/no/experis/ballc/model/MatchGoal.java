/*
package no.experis.ballc.model;

import javax.persistence.*;

@Entity
@Table(name = "MATCH_GOAL")
public class MatchGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int goal_id;
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "goal_type_id")
    private GoalType goalType;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    public MatchGoal() {
    }

    public MatchGoal(String description, GoalType goalType, Match match, Player player) {
        this.description = description;
        this.goalType = goalType;
        this.match = match;
        this.player = player;
    }

    public int getGoal_id() {
        return goal_id;
    }

    public String getDescription() {
        return description;
    }

    public GoalType getGoalType() {
        return goalType;
    }

    public Match getMatch() {
        return match;
    }

    public Player getPlayer() {
        return player;
    }
}
*/
