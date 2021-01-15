package com.cjmulcahy.accela.assessment.dao;

import java.util.List;

import com.cjmulcahy.accela.assessment.domain.Person;

public interface PersonDAO {

    public void insert(Person person);
    
    public void delete(int id);
    
    public void update(Person person);
    
    public void update(List<Person> persons);
    
    public int count();
    
    public List<Person> listPersons();
    
    public Person findPersonById(int id);
    
}
