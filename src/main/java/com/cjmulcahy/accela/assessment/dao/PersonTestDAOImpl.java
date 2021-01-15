package com.cjmulcahy.accela.assessment.dao;

import java.util.Collections;
import java.util.List;

import com.cjmulcahy.accela.assessment.domain.Person;

public class PersonTestDAOImpl implements PersonDAO{

    @Override
    public void insert(Person person) {
        
    }

    @Override
    public void delete(int id) {
        
    }

    @Override
    public void update(Person person) {
        
    }

    @Override
    public void update(List<Person> persons) {
        
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public List<Person> listPersons() {
        return Collections.emptyList();
    }

    @Override
    public Person findPersonById(int id) {
        Person person = new Person();
        person.setId(id);
        person.setFirstName("Test");
        person.setLastName("User");
        return person;
    }

}
