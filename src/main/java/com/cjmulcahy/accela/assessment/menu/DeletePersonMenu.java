package com.cjmulcahy.accela.assessment.menu;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cjmulcahy.accela.assessment.domain.Person;
import com.cjmulcahy.accela.assessment.service.PersonService;

@Component
public class DeletePersonMenu extends AbstractMenu{

    @Autowired
    private PersonService personService;
    
    private Person person;

    @Override
    public void display() {
        System.out.println("**Delete Person**");
        System.out.println("**Choose from list of people who to delete**");
        showListPersonUI();
        System.out.println("Enter person's ID to delete");
        
    }

    @Override
    public void display(int selection) {
        person = personService.findPersonById(selection);
    }

    @Override
    public void takeInputAction() {
        personService.deletePerson(((Long)person.getId()).intValue());
    }
    
    private void showListPersonUI(){
    List<Person> people = personService.listPersons();
    people.forEach(person -> {
        System.out.println("Person FirstName : " + person.getFirstName() + " Person LastName : "+person.getLastName()+" [Enter Person ID "+person.getId()+" to choose]");
    });
    }

}
