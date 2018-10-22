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

}
