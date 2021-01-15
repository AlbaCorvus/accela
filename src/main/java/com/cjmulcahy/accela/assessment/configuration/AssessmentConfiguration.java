package com.cjmulcahy.accela.assessment.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

import com.cjmulcahy.accela.assessment.ConsoleUI;
import com.cjmulcahy.accela.assessment.dao.PersonDAO;
import com.cjmulcahy.accela.assessment.dao.PersonDAOImpl;
import com.cjmulcahy.accela.assessment.domain.Person;
import com.cjmulcahy.accela.assessment.service.PersonService;
import com.cjmulcahy.accela.assessment.service.PersonServiceImpl;

@Configuration
public class AssessmentConfiguration {

    @Bean
    public PersonService personService(){
        PersonServiceImpl bean = new PersonServiceImpl();
        return bean;
    }
    
    @Bean
    public Person person(){
        Person bean = new Person();
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
