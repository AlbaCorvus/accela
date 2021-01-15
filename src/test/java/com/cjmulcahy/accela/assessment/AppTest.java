package com.cjmulcahy.accela.assessment;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cjmulcahy.accela.assessment.configuration.ApplicationTestConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationTestConfiguration.class})
public class AppTest 
{
   @Autowired
    private ApplicationContext applicationContext;
   
    @Test
    public void applicationContextTest()
    {
        Assert.assertNotNull(applicationContext);
    }
}
