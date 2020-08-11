package com.lxisoft.school.cucumber;

import com.lxisoft.school.SchoolManagementApp;
import io.cucumber.java.Before;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@WebAppConfiguration
@ContextConfiguration(classes = SchoolManagementApp.class)
public class CucumberContextConfiguration {

    @Before
    public void setup_cucumber_spring_context(){
        // Dummy method so cucumber will recognize this class as glue
        // and use its context configuration.
        System.out.println("################ spring context is running #############");
    }
}
