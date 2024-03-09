package org.example.pages;

import org.example.utility.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class PersonalDetailsPage extends BaseClass {

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
    public void clickContinue(){
        driver.findElement(By.xpath("//button[@label='Continue']")).click();
    }




}
