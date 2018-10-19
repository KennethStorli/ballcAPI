package no.experis.ballc.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TEAM")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int team_id;

    @ManyToOne
    @JoinColumn(name = "association_id")
    private Association association;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coach_id")
    private Coach coach;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "home_team", cascade = CascadeType.ALL)
    private Set<Match> home_matches;

    @OneToMany(mappedBy = "away_team", cascade = CascadeType.ALL)
    private Set<Match> away_matches;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private Set<Player> players;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private Set<Result> results;
}
