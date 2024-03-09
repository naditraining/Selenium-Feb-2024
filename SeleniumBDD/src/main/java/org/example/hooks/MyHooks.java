package org.example.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.example.utility.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class MyHooks extends BaseClass {


    @Before
    public void before(){
        System.out.println("before method");
    }
    @After
    public void after(Scenario scenario){
        System.out.println("take screenshot");
        final byte [] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"image/png","image2");
    }
}
