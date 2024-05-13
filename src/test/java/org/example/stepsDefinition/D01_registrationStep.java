package org.example.stepsDefinition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Register;
import org.example.pages.P02_HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class D01_registrationStep {

    WebDriver driver = Hooks.driver;
    P01_Register register = new P01_Register(Hooks.driver);

    @When("guest user clicks on Register Tab")
    public void registerTabClick(){
        driver.findElement(P02_HomePage.registerButton()).click();
    }

    @Then("guest user should be directed to registering page")
    public void guestDirecting(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/register?returnUrl=%2F");
    }

    @When("guest user chooses any Gender option")
    public void choosingGender(){
        driver.findElement(register.genderRadio()).click();
    }

    @And("Fill First Name")
    public void firstName(){
        driver.findElement(register.firstNameText()).sendKeys("Mahmoud");
    }

    @And("Fill Last Name")
    public void lastName(){
        driver.findElement(register.lastNameText()).sendKeys("ElGhazy");
    }

    @And("Select Day")
    public void dayOfBirth(){
        WebElement selectElement = driver.findElement(register.dayOfBirthList());
        Select selectObject = new Select(selectElement);
        selectObject.selectByValue("2");
    }

    @And("Select Month")
    public void monthOfBirth(){
        WebElement selectElement = driver.findElement(register.monthOfBirthList());
        Select selectObject = new Select(selectElement);
        selectObject.selectByValue("11");
    }

    @And("Select Year")
    public void yearOfBirth(){
        WebElement selectElement = driver.findElement(register.yearOfBirthList());
        Select selectObject = new Select(selectElement);
        selectObject.selectByValue("1997");
    }

    @And("Enter any email")
    public void enterEmail(){
        driver.findElement(register.emailText()).sendKeys("MahmoudGalal.ElGhazy2024@gmail.com");
    }

    @And("Enter any company name")
    public void enterCompanyName(){
        driver.findElement(register.companyNameText()).sendKeys("Sprints");
    }

    @And("Enter any password")
    public void enterPassword(){
        driver.findElement(register.passwordText()).sendKeys("Gh@zy!23");
    }

    @And("Enter same password in Confirm Password field")
    public void reEnterPassword(){
        driver.findElement(register.confirmPassword()).sendKeys("Gh@zy!23");
    }

    @And("Click on REGISTER button")
    public void clickRegister(){
        driver.findElement(register.registerationButton()).click();
    }

    @And("the user should be registered successfully")
    public void successRegistration(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/registerresult/1?returnUrl=/");
    }

    @And("a success green message is displayed")
    public void message() throws InterruptedException {
        Thread.sleep(3000);
        String expectedResult = "Your registration completed";
        String actualResult = driver.findElement(register.registrationMessage()).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }


    @Given("User is registered and logged in")
    public void randomRegister(){
        register.registration();
    }
}
