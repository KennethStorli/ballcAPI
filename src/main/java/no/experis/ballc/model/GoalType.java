package no.experis.ballc.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "GOAL_TYPE")
public class GoalType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int goal_type_id;
    private String type;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "goalType",
            cascade = CascadeType.ALL)
    private Set<MatchGoal> matchGoals = new HashSet<>();

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

    public void setType(String type) {
        this.type = type;
    }

    public Set<Integer> getMatchGoal() {
        Set<Integer> matchGoalIds = new HashSet<>();
        for(MatchGoal matchGoal : matchGoals) {
            matchGoalIds.add(matchGoal.getGoal_id());
        }
        return matchGoalIds;
    }

    public void setMatchGoal(Set<MatchGoal> matchGoals) {
        this.matchGoals = matchGoals;
    }
}
