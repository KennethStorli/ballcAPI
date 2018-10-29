package no.experis.ballc.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "LOCATION")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int location_id;
    private String name;
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private Set<Team> teams;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private Set<Match> footballMatches;

    public Location() {
    }

    public Location(String name, String description, Address address, Set<Team> teams, Set<Match> footballMatches) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.teams = teams;
        this.footballMatches = footballMatches;
    }

    public int getLocation_id() {
        return location_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Address getAddress() {
        return address;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public Set<Match> getFootballMatches() {
        return footballMatches;
    }
}
