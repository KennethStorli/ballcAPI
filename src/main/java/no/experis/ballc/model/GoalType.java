package no.experis.ballc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GoalType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int goal_type_id;
    private String type;

    public GoalType() {
    }

    public GoalType(String type) {
        this.type = type;
    }

    public int getGoal_type_id() {
        return goal_type_id;
    }

    public String getType() {
        return type;
    }
}
