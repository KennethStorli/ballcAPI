package no.experis.ballc.model;

import javax.persistence.*;

@Entity
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

}
