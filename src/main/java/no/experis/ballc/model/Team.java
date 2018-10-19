package no.experis.ballc.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TEAM")
public class Team {

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
