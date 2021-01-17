package com.cjmulcahy.accela.assessment.menu;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cjmulcahy.accela.assessment.domain.Address;
import com.cjmulcahy.accela.assessment.domain.Person;
import com.cjmulcahy.accela.assessment.service.PersonService;
import com.cjmulcahy.accela.assessment.utils.enums.UpdateFieldState;

@Component
public class CreatePersonMenu extends AbstractMenu{

    private UpdateFieldState updateField;
    
    @Autowired
    private Person person;
    
    
    private Set<Address> addresses;
    
    @Autowired
    private PersonService personService;
    
    public CreatePersonMenu(){
        
    }

    @Override
    public void display() {
        System.out.println("**Create Person**");
        System.out.println("Enter First Name : ");
        updateField = UpdateFieldState.FIRST_NAME;
        takeInputAction();
        System.out.println("Enter Last Name : ");
        updateField = UpdateFieldState.LAST_NAME;
        takeInputAction();
        updateField = UpdateFieldState.ADDRESSES;
        addresses = new HashSet<>();
        while(true){
            if(!displayCreateAddresses()){
                break;
            }
        }
        takeInputAction();
        System.out.println("Press any number to continue");
    }

    @Override
    public void display(int selection) {
        updateField = UpdateFieldState.NONE;
    }
    
    public boolean displayCreateAddresses(){
        Address address = new Address();
        System.out.println("*****Enter Addresses*********");
        System.out.println("Enter Address Street: ");
        address.setStreet(scannerUtils.listenForString(scanner));
        System.out.println("Enter Address City : ");
        address.setCity(scannerUtils.listenForString(scanner));
        System.out.println("Enter Address State : ");
        address.setState(scannerUtils.listenForString(scanner));
        System.out.println("Enter Address Postal Code : ");
        address.setPostalCode(scannerUtils.listenForString(scanner));
        addresses.add(address);
        System.out.println("Add another address ? Y/N ");
        return ("Y").equalsIgnoreCase(scannerUtils.listenForString(scanner));
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
            person.setAddresses(addresses);
            break;
     case NONE:
         personService.createPerson(person);
         break;
     default:
         break;
        }
        
    }
    

}
