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

   /* @OneToMany(mappedBy = "season", cascade = CascadeType.ALL)
    private Set<Match> matches;*/

    public Season() {
    }

    public Season(int start_date, int end_date, String name, String description/*, Set<Match> matches*/) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.name = name;
        this.description = description;
//        this.matches = matches;
    }

    public int getSeason_id() {
        return season_id;
    }

    public int getStart_date() {
        return start_date;
    }

    public int getEnd_date() {
        return end_date;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

//    public Set<Match> getMatches() {
//        return matches;
//    }
}
