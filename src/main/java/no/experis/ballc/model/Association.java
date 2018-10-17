package no.experis.ballc.model;

import javax.persistence.*;

@Entity
@Table(name = "ASSOCIATION")
public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int association_id;
    private String name;
    private String description;

    public Association() {
    }

    public Association(String name, String description) {
        this.name = name;
        this.description = description;
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
}
