/*
package no.experis.ballc.model;

import javax.persistence.*;

@Entity
@Table(name = "CONTACT")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int contact_id;
    private String contact_type;
    private String contact_detail;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Contact() {
    }

    public Contact(String contact_type, String contact_detail, Person person) {
        this.contact_type = contact_type;
        this.contact_detail = contact_detail;
        this.person = person;
    }

    public int getContact_id() {
        return contact_id;
    }

    public String getContact_type() {
        return contact_type;
    }

    public String getContact_detail() {
        return contact_detail;
    }

    public Person getPerson() {
        return person;
    }
}
*/
