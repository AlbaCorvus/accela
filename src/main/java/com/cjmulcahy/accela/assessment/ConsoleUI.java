package com.cjmulcahy.accela.assessment;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.cjmulcahy.accela.assessment.domain.Person;
import com.cjmulcahy.accela.assessment.service.PersonService;

public class ConsoleUI {

    @Autowired
    private Person person;

    @Autowired
    private PersonService personService;

    public ConsoleUI() {

    }

    public void showConsoleMenu() {
        System.out.println("****************************************");
        System.out.println("1.) Create Person [Press 1]");
        System.out.println("2.) Update Person [Press 2]");
        System.out.println("3.) Delete Person [Press 3]");
        System.out.println("4.) Count People [Press 4]");
        System.out.println("5.) List People [Press 5]");
        System.out.println("6.) Exit [Press 0]");
        System.out.println("*****************************************");
    }

    public int listen(Scanner scanner) throws InputMismatchException {
        return scanner.nextInt();
    }

    public void showCreatePersonMenu(Scanner scanner) {
        System.out.println("**Create Person**");
        System.out.print("Enter First Name : ");
        person.setFirstName(scanner.next());
        System.out.print("Enter Last Name : ");
        person.setLastName(scanner.next());
        personService.createPerson(person);
    }

    public void showUpdatePersonMenu(Scanner scanner) {
        System.out.println("**Update Person**");
        System.out.println("**Choose from list of people who to edit**");
        showListPersonUI();
        System.out.println("Enter person's ID to update");
        int id = scanner.nextInt();
        Person person = personService.findPersonById(id);
        int updateChoice = showPersonDetails(person, scanner);
        updatePersonsDetails(updateChoice, person, scanner);
        personService.updatePerson(person);
    }

    private void showListPersonUI() {
        List<Person> people = personService.listPersons();
        for (Person person : people) {
            System.out.println("Person ID : " + person.getId() + " :: " + person.getFirstName() + " " + person.getLastName()
                    + "[Enter Person ID to choose]");
        }
    }

    private void updatePersonsDetails(int updateChoice, Person person, Scanner scanner) {
        switch (updateChoice) {
        case 1:
            System.out.println("Update First Name");
            person.setFirstName(scanner.next());
            break;
        case 2:
            System.out.println("Update Last Name");
            person.setLastName(scanner.next());
            break;
        default:
            break;
        }

    }

    public void showDeletionMenu(Scanner scanner) {
        System.out.println("**Delete Person**");
        System.out.println("**Choose from list of people who to delete**");
        showListPersonUI();
        System.out.println("Enter person's ID to delete");
        int id = scanner.nextInt();
        personService.deletePerson(id);
        System.out.println("Deletion Successful");
    }

    public void showCount() {
        int count = personService.countPersons();
        System.out.println("***********Persons count*************");
        System.out.println("*********** "+ count +"*************");
    }

    public void listPersons() {
        showListPersonUI();
    }

    private int showPersonDetails(Person person, Scanner scanner) {
        System.out.println("***********EDIT PERSON************");
        System.out.println("**-- " + person.getFirstName() + " " + person.getLastName() + "  --**");
        System.out.println("1.) Change First Name [Press 1]");
        System.out.println("2.) Change Last Name [Press 2]");
        System.out.println("3.) Change Addresses [Press 3]");
        return scanner.nextInt();
    }
}
