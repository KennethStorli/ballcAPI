package no.experis.ballc.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ASSOCIATION")
public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int association_id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "association", cascade = CascadeType.ALL)
    private Set<Team> teams;

    public Association() {
    }

    public Association(String name, String description) {
        this.name = name;
        this.description = description;

    }

    public int getAssociation_id() {
        return association_id;
    }
    public void setAssociation_id(int id){
        this.association_id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Set<Team> getTeams() {
        return teams;
    }
    public void setTeams(Set<Team> teams){
        this.teams = teams;
    }
}
