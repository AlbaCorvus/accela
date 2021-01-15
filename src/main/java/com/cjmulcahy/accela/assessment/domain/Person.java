package com.cjmulcahy.accela.assessment.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="person")
public class Person {
    @Id
    @GeneratedValue
    private int id;

    private String firstName;
    
    private String lastName;
    
    @OneToMany(targetEntity = com.cjmulcahy.accela.assessment.domain.Address.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<Address> addresses;
    
    public long getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
    }
    
}
