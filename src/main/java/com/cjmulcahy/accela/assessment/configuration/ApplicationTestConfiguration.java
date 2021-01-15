package com.cjmulcahy.accela.assessment.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

import com.cjmulcahy.accela.assessment.dao.PersonDAO;
import com.cjmulcahy.accela.assessment.dao.PersonDAOImpl;
import com.cjmulcahy.accela.assessment.dao.PersonTestDAOImpl;
import com.cjmulcahy.accela.assessment.domain.Person;
import com.cjmulcahy.accela.assessment.service.PersonService;
import com.cjmulcahy.accela.assessment.service.PersonServiceImpl;

@Configuration
public class ApplicationTestConfiguration {

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
        PersonTestDAOImpl bean = new PersonTestDAOImpl();
        return bean;
    }
    
}
