package com.cjmulcahy.accela.assessment.configuration;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

import com.cjmulcahy.accela.assessment.ConsoleUI;
import com.cjmulcahy.accela.assessment.dao.PersonDAO;
import com.cjmulcahy.accela.assessment.dao.PersonDAOImpl;
import com.cjmulcahy.accela.assessment.domain.Address;
import com.cjmulcahy.accela.assessment.domain.Person;
import com.cjmulcahy.accela.assessment.menu.CreatePersonMenu;
import com.cjmulcahy.accela.assessment.menu.DeletePersonMenu;
import com.cjmulcahy.accela.assessment.menu.CountPersonMenu;
import com.cjmulcahy.accela.assessment.menu.ListPersonMenu;
import com.cjmulcahy.accela.assessment.menu.MainMenu;
import com.cjmulcahy.accela.assessment.menu.MenuFactory;
import com.cjmulcahy.accela.assessment.menu.UpdatePersonMenu;
import com.cjmulcahy.accela.assessment.service.PersonService;
import com.cjmulcahy.accela.assessment.service.PersonServiceImpl;
import com.cjmulcahy.accela.assessment.utils.ScannerUtils;
import com.cjmulcahy.accela.assessment.utils.ScannerValidator;

@Configuration
public class AssessmentConfiguration {

    @Bean
    public PersonService personService(){
        PersonServiceImpl bean = new PersonServiceImpl();
        return bean;
    }
    
    @Bean
    public MenuFactory menuFactory(){
        MenuFactory menuFactory = new MenuFactory();
        return menuFactory;
    }
    
    @Bean
    public MainMenu mainMenu(){
        MainMenu mainMenu = new MainMenu();
            return mainMenu;
        }
    @Bean
    public DeletePersonMenu deletePersonMenu(){
        DeletePersonMenu bean = new DeletePersonMenu();
        return bean;
    }
    @Bean
    public CreatePersonMenu createPersonMenu(){
        CreatePersonMenu bean = new CreatePersonMenu();
        return bean;
    }
    @Bean
    public ListPersonMenu listPersonMenu(){
        ListPersonMenu bean = new ListPersonMenu();
        return bean;
    }
    @Bean
    public CountPersonMenu findPersonMenu(){
        CountPersonMenu bean = new CountPersonMenu();
        return bean;
    }
    
    @Bean
    UpdatePersonMenu updatePersonMenu(){
        UpdatePersonMenu bean = new UpdatePersonMenu();
        return bean;
    }
    
    @Bean
    public ScannerUtils scannerUtils(){
        ScannerUtils bean = new ScannerUtils();
        return bean;
    }
    
    @Bean
    public Scanner scanner(){
        Scanner bean = new Scanner(System.in);
        return bean;
    }
    
    @Bean
    public ScannerValidator scannerValidator(){
        ScannerValidator bean = new ScannerValidator();
        return bean;
    }
    
    @Bean
    public Person person(){
        Person bean = new Person();
        return bean;
    }
    
    @Bean
    public Address address(){
        Address bean = new Address();
        return bean;
    }
    
    @Bean
    public PersonDAO personDAO(){
        PersonDAOImpl bean = new PersonDAOImpl();
        return bean;
    }
    
    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory(){
        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("test-jpa");
        return factoryBean;
    }
    
    @Bean
    public static PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){
        PersistenceExceptionTranslationPostProcessor bean = new PersistenceExceptionTranslationPostProcessor();
        return bean;
    }
    
    @Bean
    public ConsoleUI consoleUI(){
        ConsoleUI bean = new ConsoleUI();
        return bean;
    }
    
    
}
