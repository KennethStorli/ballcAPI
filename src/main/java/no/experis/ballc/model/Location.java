package no.experis.ballc.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int location_id;
    private String name;
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private Set<Team> teams;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private Set<Match> matches;

    public Location() {
    }


}
