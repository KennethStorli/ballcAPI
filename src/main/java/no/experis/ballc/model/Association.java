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


}
