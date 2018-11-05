package no.experis.ballc.model;

import javax.persistence.*;

@Entity
@Table(name = "OWNER")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int owner_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToOne(mappedBy = "owner")
    private Team team;

    public Owner() {
    }

    public Owner(Person person) {
        this.person = person;
    }

    public Owner(Person person, Team team) {
        this.person = person;
        this.team = team;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setPerson(Person person){
        this.person = person;
    }

    public int getPerson() {
        return person.getPerson_id();
    }

    public void setTeam(Team team){
        this.team = team;
    }

    public int getTeam() {
        if(team != null) {
            return team.getTeam_id();
        }
        return -1;
    }


}
