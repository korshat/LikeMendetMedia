package com.lmmv.step_definitions;

import com.lmmv.utilities.Driver;
import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before
    public void setUp(){
        System.out.println("------Setting up browser with further details...");

    }
    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
        final byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"image/png","screenshot");

        }
        Driver.closeDriver();

    }

}
