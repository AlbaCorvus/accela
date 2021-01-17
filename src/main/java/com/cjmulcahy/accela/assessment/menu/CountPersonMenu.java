package com.cjmulcahy.accela.assessment.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cjmulcahy.accela.assessment.service.PersonService;

@Component
public class CountPersonMenu extends AbstractMenu{

  @Autowired
  PersonService personService;

    @Override
    public void display() {
        int count = personService.countPersons();
        System.out.println("***********Persons count*************");
        System.out.println("*********** "+ count +"*************");
        System.out.println("Press any number to continue");
    }

    @Override
    public void display(int selection) {
        
    }

    @Override
    public void takeInputAction() {
        
    }

}
