package com.cjmulcahy.accela.assessment.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cjmulcahy.accela.assessment.dao.PersonDAO;
import com.cjmulcahy.accela.assessment.domain.Person;

@Transactional
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonDAO personDAO;
    
    public void setPersonDAO(PersonDAO personDAO){
        this.personDAO = personDAO;
    }
    
    @Override
    public void createPerson(Person person) {
        personDAO.insert(person);
        
    }

    @Override
    public void updatePerson(Person person) {
        personDAO.update(person);
        
    }

    @Override
    public void deletePerson(int id) {
        personDAO.delete(id);
        
    }

    @Override
    public int countPersons() {
        return personDAO.count();
    }

    @Override
    public List<Person> listPersons() {
        return personDAO.listPersons();
    }
    
    @Override
    public Person findPersonById(int id){
        return personDAO.findPersonById(id);
    }

}
