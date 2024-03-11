package org.example.pages;

import io.cucumber.java.Scenario;
import org.example.utility.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

import java.util.Map;

public class BasicDetailsPage extends BaseClass {

    ChromiumDriver driver = null;
    Map<String,String> dataInMap =null;

    public BasicDetailsPage(ChromiumDriver driver, Map<String,String> dataInMap){
        this.driver = driver ;
        this.dataInMap = dataInMap;
    }

    public BasicDetailsPage enterUsername(){
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(dataInMap.get("username"));
        return this;
    }

    public BasicDetailsPage enterPassword(){
        driver.findElement(By.xpath("//input[@id='usrPwd']")).sendKeys(dataInMap.get("password"));
        return this;
    }

    public BasicDetailsPage enterConfirmPassword(){
        driver.findElement(By.xpath("//input[@name='cnfUsrPwd']")).sendKeys(dataInMap.get("confirmpassword"));
        return this;
    }
    public BasicDetailsPage choosePrefLanguage(){
        driver.findElement(By.xpath("//div[@class='ng-tns-c65-7 ui-dropdown ui-widget ui-state-default ui-corner-all']")).click();
        driver.findElement(By.xpath("//li[@aria-label='English']")).click();
        return this;
    }
    public BasicDetailsPage chooseSecurityQuestion(){
        driver.findElement(By.xpath("//div[@class='ng-tns-c65-8 ui-dropdown ui-widget ui-state-default ui-corner-all']")).click();
        driver.findElement(By.xpath("//li[@aria-label='What is your pet name?']")).click();
        return this;

    }
    public BasicDetailsPage enterSecurityAnswer(){
        driver.findElement(By.xpath("//input[@placeholder='Security Answer']")).sendKeys("Suvi");
        return this;
    }

    public void clickContinue(Scenario scenario){
        driver.findElement(By.xpath("//button[@label='Continue']")).click();

    }
    public BasicDetailsPage clickCancel(){
        return this;
    }


}
