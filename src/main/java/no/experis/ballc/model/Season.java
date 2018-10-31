package no.experis.ballc.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SEASON")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int season_id;
    private LocalDate start_date;
    private LocalDate end_date;
    private String name;
    private String description;

    @OneToMany(mappedBy = "season", cascade = CascadeType.ALL)
    private Set<Match> matches = new HashSet<>();

    public Season() {
    }

    public Season(LocalDate start_date, LocalDate end_date, String name, String description) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.name = name;
        this.description = description;
    }

    public int getSeason_id() {
        return season_id;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Match> getMatches() {
        return matches;
    }

    public void setMatches(Set<Match> matches) {
        this.matches = matches;
    }
}
