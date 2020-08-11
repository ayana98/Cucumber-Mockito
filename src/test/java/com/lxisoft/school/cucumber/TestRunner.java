package com.lxisoft.school.cucumber;


import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty", features = "classpath:feature/MockingService.feature",glue="com.lxisoft.school.cucumber")


public class TestRunner {
}
