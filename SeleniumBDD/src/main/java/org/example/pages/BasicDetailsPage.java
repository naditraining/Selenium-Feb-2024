package org.example.pages;

import org.example.utility.BaseClass;
import org.openqa.selenium.By;

public class BasicDetailsPage extends BaseClass {


    public BasicDetailsPage enterUsername(){
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(rowDataToUse.get("username"));
        return this;
    }

    public BasicDetailsPage enterPassword(){
        driver.findElement(By.xpath("//input[@id='usrPwd']")).sendKeys(rowDataToUse.get("password"));
        return this;
    }

    public BasicDetailsPage enterConfirmPassword(){
        driver.findElement(By.xpath("//input[@name='cnfUsrPwd']")).sendKeys(rowDataToUse.get("confirmpassword"));
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

    public void clickContinue(){
        driver.findElement(By.xpath("//button[@label='checkbox']")).click();

    }
    public BasicDetailsPage clickCancel(){
        return this;
    }


}
