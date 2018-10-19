package no.experis.ballc.model;

import javax.persistence.*;

@Entity
@Table(name = "RESULT")
public class Result {
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "match_id")
    private Match match;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    private int score;
    private String result;
}
