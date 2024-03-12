package org.example.steps;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.hooks.MyHooks;
import org.example.pages.BasicDetailsPage;
import org.example.pages.PersonalDetailsPage;
import org.example.utility.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;


public class IrctcSteps extends BaseClass {


    Scenario scenario = null;
    public IrctcSteps(){

    }
    Map<String,String> testData;
    @Given("As a user launching the irctc portal")
    public void register() {
        loadProperties();
        launchApp();
    }

    @When("I enter personal details")
    public void personalDetails(){

        PersonalDetailsPage personal = new PersonalDetailsPage(driver,rowDataToUse);
        personal.enterFirstName();
        personal.enterMiddleName();
        personal.enterLastName();
        personal.selectOccupation();
        personal.enterDOB();
        personal.selectMaritalStatus();
        personal.selectCountry();
        personal.chooseGender();
        personal.enterEmail();
        personal.enterMobile();
        personal.chooseNationaltiy();
        personal.clickContinue(scenario);
    }

    @When("I read test data for {string}")
    public void readTestDataFor(String testCaseName) throws IOException {
          readTestDataForMyTest(testCaseName);
    }

    @When("I enter address details")
    public void addressDetails(){

        driver.findElement(By.xpath("//input[@id='resAddress1']")).sendKeys("No3, Gandhi Nagar");
        driver.findElement(By.xpath("//input[@id='resAddress2']")).sendKeys("Mookondapalli");
        driver.findElement(By.xpath("//input[@id='resAddress3']")).sendKeys("Hosur");
        driver.findElement(By.xpath("//input[@name='resPinCode']")).sendKeys("635126");
        driver.findElement(By.xpath("//select[@formcontrolname='resCity']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement City = driver.findElement(By.xpath("//select[@formcontrolname='resCity']"));

        wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver driver)
            {
                Select cit = new Select(City);
                return cit.getOptions().size()>1;
            }

        });

        Select cit = new Select(City);
        cit.selectByVisibleText("Krishnagiri");

        //driver.findElement(By.xpath("//input[@id='resState']")).sendKeys("TAMILNADU");
        WebElement Post = driver.findElement(By.xpath("//select[@formcontrolname='resPostOff']"));
        wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver driver)
            {
                Select cit = new Select(Post);
                return cit.getOptions().size()>1;
            }
        });
        Select off = new Select(Post);
        off.selectByValue("Mookandapalli B.O");
        driver.findElement(By.xpath("//input[@id='resPhone']")).sendKeys("9987689979");
        driver.findElement(By.xpath("//label[text()='Yes']")).click();
        WebElement button= driver.findElement(By.xpath("//button[@type='submit']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(button);
        actions.perform();
        WebElement checkbox= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='termCondition']")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", checkbox);

    }

    @When("registration is complete")
    public void complete(){
        System.out.println("dummy statement for registration completion");
    }

    @When("I enter basic details")
    public void enterBasicDetails(){

        System.out.println("printing driver object in step defintion "+driver);
        BasicDetailsPage basic = new BasicDetailsPage(driver,rowDataToUse);

        basic.enterUsername().enterPassword().enterConfirmPassword().choosePrefLanguage().chooseSecurityQuestion().enterSecurityAnswer().clickContinue(scenario);

    }

}

