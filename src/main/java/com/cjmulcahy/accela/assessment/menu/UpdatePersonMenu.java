package com.cjmulcahy.accela.assessment.menu;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cjmulcahy.accela.assessment.domain.Address;
import com.cjmulcahy.accela.assessment.domain.Person;
import com.cjmulcahy.accela.assessment.service.PersonService;
import com.cjmulcahy.accela.assessment.utils.enums.UpdateFieldState;


@Component
public class UpdatePersonMenu extends AbstractMenu{

    private UpdateFieldState updateField;
    
    @Autowired
    private PersonService personService;
    
    private Set<Address> addresses;
    
    private Person person;
    
    
    @Override
    public void display() {
        System.out.println("**Update Person**");
        System.out.println("**Choose from list of people who to edit**");
        showListPersonUI();
        System.out.println("Enter person's ID to update");
    }

    @Override
    public void display(int selection) {
        person = personService.findPersonById(selection);
        displayPersonDetails(person);
        showUpdatePersonFieldSelection(scannerUtils.listenForIntegerWithRange(scanner,0,3));
    }
    
    private void showUpdatePersonFieldSelection(int selection){
    switch(selection){
    case 1:
        showUpdateFirstName();
        updateField = UpdateFieldState.FIRST_NAME;
        break;
    case 2:
        showUpdateLastName();
        updateField = UpdateFieldState.LAST_NAME;
        break;
    case 3:
        showUpdateAdresses();
        showUpdateAddressSelection(scannerUtils.listenForAnyInt(scanner));
        updateField = UpdateFieldState.ADDRESSES;
        break;
        default:
            updateField = UpdateFieldState.NONE;
    }
    }
    
    private void displayPersonDetails(Person person){
        System.out.println("***********EDIT PERSON************");
        System.out.println("**-- " + person.getFirstName() + " " + person.getLastName() + "  --**");
        System.out.println("1.) Change First Name [Press 1]");
        System.out.println("2.) Change Last Name [Press 2]");
        System.out.println("3.) Change Addresses [Press 3]");
    }
    
    private void showUpdateFirstName() {
        System.out.println("**Update FirstName**");
    }

    private void showUpdateLastName() {
        System.out.println("**Update LastName**");
    }

    private void showUpdateAdresses() {
        person.getAddresses().forEach(address -> {
            System.out.println("**Update Address**");
            System.out.println("**" +address.getStreet()+" "+address.getCity()+" "+address.getState()+" "+address.getPostalCode()+ "[Press "+address.getId()+" to select]**");
        });
    }
    
    private void showUpdateAddressSelection(int addressId){
        addresses = new HashSet<>();
        Address address = person.getAddressById(addressId);
        System.out.println(address.getStreet() + " Enter new Street address :: ");
        address.setStreet(scannerUtils.listenForString(scanner));
        System.out.println(address.getCity() + " Enter new City address :: ");
        address.setCity(scannerUtils.listenForString(scanner));
        System.out.println(address.getState() + " Enter new State address :: ");
        address.setState(scannerUtils.listenForString(scanner));
        System.out.println(address.getPostalCode() + " Enter new Postal Code address :: ");
        address.setPostalCode(scannerUtils.listenForString(scanner));
        addresses.add(address);
    }

    private void showListPersonUI() {
        List<Person> people = personService.listPersons();
        people.forEach(person -> {
            System.out.println("Person FirstName : " + person.getFirstName() + " Person LastName : "+person.getLastName()+" [Enter Person ID "+person.getId()+" to choose]");
        });
            
    }

    @Override
    public void takeInputAction() {
       switch(updateField){
       case FIRST_NAME:
           String firstName = scannerUtils.listenForString(scanner);
           person.setFirstName(firstName);
           break;
       case LAST_NAME:
           String lastName = scannerUtils.listenForString(scanner);
           person.setLastName(lastName);
           break;
       case ADDRESSES:
           person.getAddresses().removeIf(address -> addresses.contains(address));
           person.getAddresses().addAll(addresses);
           break;
    case NONE:
        break;
    default:
        break;
       }
       personService.updatePerson(person);
        
    }
    
   

}
