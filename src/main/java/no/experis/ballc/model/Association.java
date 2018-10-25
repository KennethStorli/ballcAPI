/*
package no.experis.ballc.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ASSOCIATION")
public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int association_id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "association", cascade = CascadeType.ALL)
    private Set<Team> teams;

    public Association() {
    }

    public Association(String name, String description, Set<Team> teams) {
        this.name = name;
        this.description = description;
        this.teams = teams;
    }

    public int getAssociation_id() {
        return association_id;
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
}
*/
