package no.experis.ballc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int contact_id;
    private String contact_type;
    private String contact_detail;
    private int person_id;

    public Contact() {
    }

    public Contact(String contact_type, String contact_detail, int person_id) {
        this.contact_type = contact_type;
        this.contact_detail = contact_detail;
        this.person_id = person_id;
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

    public int getPerson_id() {
        return person_id;
    }
}
