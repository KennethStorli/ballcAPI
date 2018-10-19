package no.experis.ballc.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int player_id;
    private String normal_position;
    private int number;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private Set<MatchGoal> matchGoals;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "MATCH_POSITION",
            joinColumns = { @JoinColumn(name = "player_id") },
            inverseJoinColumns = { @JoinColumn(name = "match_id") })
    private Set<Match> matches;
}
