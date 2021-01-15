package com.cjmulcahy.accela.assessment.sevice;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cjmulcahy.accela.assessment.configuration.ApplicationTestConfiguration;
import com.cjmulcahy.accela.assessment.domain.Person;
import com.cjmulcahy.accela.assessment.service.PersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationTestConfiguration.class})
public class PersonServiceTest {
    
    @Autowired
    private Person person;
    
    @Autowired
    private PersonService personService;
    
    
    @Test
    public void testInjections(){
        Assert.assertNotNull(person);
        Assert.assertNotNull(personService);
    }

    @Test
    public void createPersonTest(){
        
    }
    
    @Test
    public void updatePersonTest(){
        
    }
    
    @Test
    public void deletePersonTest(){
        
    }
    
    @Test
    public void countPersonTest(){
        
    }
    
    @Test
    public void listPersonTest(){
        
    }
    
    @Test
    public void findPersonByIdTest(){
        
    }
}
