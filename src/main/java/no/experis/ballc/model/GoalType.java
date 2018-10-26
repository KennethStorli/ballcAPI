package no.experis.ballc.model;

import javax.persistence.*;

@Entity
@Table(name = "GOAL_TYPE")
public class GoalType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int goal_type_id;
    private String type;

    @OneToOne(mappedBy = "goalType")
    private MatchGoal matchGoal;

    public GoalType() {
    }

    public GoalType(String type, MatchGoal matchGoal) {
        this.type = type;
        this.matchGoal = matchGoal;
    }

    public int getGoal_type_id() {
        return goal_type_id;
    }

    public String getType() {
        return type;
    }

    public MatchGoal getMatchGoal() {
        return matchGoal;
    }
}
