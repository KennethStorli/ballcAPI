package no.experis.ballc.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "MATCH")
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
    @JoinColumn(name = "team_id", insertable=false, updatable=false)
    private Team away_team;

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    private Set<MatchGoal> matchGoals;

    @OneToMany(mappedBy = "primaryKey.match", cascade = CascadeType.ALL)
    private Set<MatchPosition> matchPositions;

/*    @ManyToMany(mappedBy = "matches")
    private Set<Player> matches;*/

    @OneToMany(mappedBy = "primaryKey.match", cascade = CascadeType.ALL)
    private Set<Result> results;

    public Match() {
    }


}
