package no.experis.ballc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PERSON")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int person_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    private String first_name;
    private String last_name;
    private Date date_of_birth;
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "person",
            cascade = CascadeType.ALL)
    private Set<Contact> contacts;

    public Person() {
    }

    public Person(Address address, String first_name, String last_name, Date date_of_birth) {
        this.address = address;
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public int getAddress() {
        return address.getAddress_id();
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Integer> getContacts() {
        Set<Integer> contactIds = new HashSet<>();
        for(Contact contact : contacts) {
            contactIds.add(contact.getContact_id());
        }
        return contactIds;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
}
