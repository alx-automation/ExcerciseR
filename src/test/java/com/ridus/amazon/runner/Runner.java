package com.ridus.amazon.runner;

import com.ridus.amazon.driver.Driver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/ItemsFromCartTest.feature"},
        glue = {"com.ridus.amazon.steps"},
        tags = "@wip or @smoke")
public class Runner {

    static Driver driverInstance = new Driver();

    @BeforeClass
    public static void driverInstanceCreation() {
        driverInstance.createDriverInstance();
    }

    @AfterClass
    public static void cleanDriverInstances() {
        driverInstance.deleteDriverInstance();
    }
}
