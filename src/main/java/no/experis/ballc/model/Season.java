package no.experis.ballc.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "SEASON")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int season_id;
    private int start_date;
    private int end_date;
    private String name;
    private String description;

    @OneToMany(mappedBy = "season", cascade = CascadeType.ALL)
    private Set<Match> matches;


}
