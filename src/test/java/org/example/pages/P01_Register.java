package org.example.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class P01_Register {

    WebDriver driver;

    public P01_Register(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public By genderRadio(){

        return By.id("gender-male");
    }

    public By firstNameText(){
        return By.id("FirstName");
    }

    public By lastNameText(){
        return By.id("LastName");
    }

    public By dayOfBirthList(){
        return By.name("DateOfBirthDay");
    }

    public By monthOfBirthList(){
        return By.name("DateOfBirthMonth");
    }

    public By yearOfBirthList(){
        return By.name("DateOfBirthYear");
    }

    public By emailText(){
        return By.id("Email");
    }

    public By companyNameText(){
        return By.id("Company");
    }

    public By passwordText(){
        return By.id("Password");
    }

    public By confirmPassword(){
        return By.id("ConfirmPassword");
    }

    public By registerationButton(){
        return By.id("register-button");
    }

    public By registrationMessage(){
        return By.xpath("//div[@class=\"result\"]");
    }

    public void registration(){
        driver.findElement(P02_HomePage.registerButton()).click();
        driver.findElement(genderRadio()).click();
        driver.findElement(firstNameText()).sendKeys("Mahmoud");
        driver.findElement(lastNameText()).sendKeys("ElGhazy");
        Select selectObject = new Select(driver.findElement(dayOfBirthList()));
        selectObject.selectByValue("2");
        selectObject = new Select(driver.findElement(monthOfBirthList()));
        selectObject.selectByValue("11");
        selectObject = new Select(driver.findElement(yearOfBirthList()));
        selectObject.selectByValue("1997");
        Faker fake = new Faker();
        driver.findElement(emailText()).sendKeys(fake.internet().safeEmailAddress());
        driver.findElement(companyNameText()).sendKeys("Professional Test Track");
        driver.findElement(passwordText()).sendKeys("Gh@zy!23");
        driver.findElement(confirmPassword()).sendKeys("Gh@zy!23");
        driver.findElement(registerationButton()).click();
        driver.navigate().to("https://demo.nopcommerce.com/");
    }


}
