package com.cjmulcahy.accela.assessment.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cjmulcahy.accela.assessment.domain.Person;
import com.cjmulcahy.accela.assessment.service.PersonService;

@Component
public class ListPersonMenu extends AbstractMenu{

    @Autowired
    PersonService personService;

    @Override
    public void display() {
        System.out.println("*******Show people*********");
        List<Person> people = personService.listPersons();
        for (Person person : people) {
            System.out.println("Person ID : " + person.getId() + " :: " + person.getFirstName() + " " + person.getLastName());
            displayAddressInformation(person);
        }
        System.out.println("*******Press Any Number To Continue*********");
    }

    @Override
    public void display(int selection) {
        
    }

    @Override
    public void takeInputAction() {
        
    }
    
    private void displayAddressInformation(Person person){
        person.getAddresses().forEach(address -> {
            System.out.println("Address Street :: "+address.getStreet()+" City :: "+address.getCity() +" State :: "+address.getState()+" PostalCode :: "+address.getPostalCode());
        });
    }

}
