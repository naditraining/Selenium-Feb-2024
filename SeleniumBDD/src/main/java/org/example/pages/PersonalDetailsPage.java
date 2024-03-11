package org.example.pages;

import io.cucumber.java.Scenario;
import org.example.utility.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class PersonalDetailsPage extends BaseClass {
    ChromiumDriver driver =null;
    Map<String,String> dataInMap =null;
    public PersonalDetailsPage(ChromiumDriver driver,Map<String,String> dataInMap){
        this.driver = driver;
        this.dataInMap = dataInMap;
    }

    public void enterFirstName(){
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Sheela");
    }

    public void enterMiddleName(){
        driver.findElement(By.xpath("//input[@id='middleName']")).sendKeys("C");
    }

    public void enterLastName(){
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Chinnasamy");
    }
    public void selectOccupation(){
        driver.findElement(By.xpath("//span[@class='ng-tns-c65-9 ui-dropdown-label ui-inputtext ui-corner-all ui-placeholder ng-star-inserted']")).click();
        driver.findElement(By.xpath("//li[@aria-label='PRIVATE']")).click();

    }
    public void enterDOB(){
        driver.findElement(By.xpath("//input[@placeholder='Date Of Birth']")).sendKeys("06-02-2006");
        driver.findElement(By.xpath("//a[contains(text(),'6')]")).click();
    }
    public void selectMaritalStatus(){
        driver.findElement(By.xpath("//label[text()='Married']")).click();
    }

    public void selectCountry(){
        WebElement country = driver.findElement(By.xpath("//select[@formcontrolname='resCountry']"));
        Select sei = new Select(country);
        sei.selectByValue("94");
    }
    public void chooseGender(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Female']"))));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Female']")));
        driver.findElement(By.xpath("//span[text()='Female']")).click();
    }
    public void enterEmail(){
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("cpshe@gmail.com");
    }
    public void enterMobile(){
        driver.findElement(By.xpath("//input[@formcontrolname='mobile']")).sendKeys("7448515464");
    }
    public void chooseNationaltiy(){
        WebElement Nation = driver.findElement(By.xpath("//select[@formcontrolname='nationality']"));
        Select Nat = new Select(Nation);
        Nat.selectByValue("94");

    }
    public void clickBack(){

    }
    public void clickContinue(Scenario scenario){
        driver.findElement(By.xpath("//button[@label='Continue']")).click();

    }




}
