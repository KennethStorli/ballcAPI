package no.experis.ballc.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int match_id;
    private Date match_date;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team home_team;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team away_team;

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    private Set<MatchGoal> matchGoals;

    @ManyToMany(mappedBy = "projects")
    private Set<Player> matches;

    @OneToOne(mappedBy = "match")
    private Result result;

    public Match() {
    }


}
