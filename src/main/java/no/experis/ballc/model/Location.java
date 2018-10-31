package no.experis.ballc.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "LOCATION")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int location_id;
    private String name;
    private String description;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private Set<Team> teams = new HashSet<>();

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private Set<Match> footballMatches = new HashSet<>();

    public Location() {
    }

    public Location(String name, String description, Address address) {
        this.name = name;
        this.description = description;
        this.address = address;
    }

    public int getLocation_id() {
        return location_id;
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

    public int getAddress() {
        return address.getAddress_id();
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Integer> getTeams() {
        Set<Integer> teamIds = new HashSet<>();
        for(Team team : teams) {
            teamIds.add(team.getTeam_id());
        }
        return teamIds;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public Set<Integer> getFootballMatches() {
        Set<Integer> fotballMatchIds = new HashSet<>();
        for(Match match : footballMatches) {
            fotballMatchIds.add(match.getMatch_id());
        }
        return fotballMatchIds;
    }

    public void setFootballMatches(Set<Match> footballMatches) {
        this.footballMatches = footballMatches;
    }
}
