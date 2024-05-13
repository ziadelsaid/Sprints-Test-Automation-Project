package org.example.stepsDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Data.Data_Drived;
import org.example.pages.P02_HomePage;
import org.example.pages.P03_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class D02_LoginStep {

    Data_Drived  data = new Data_Drived();
    WebDriver driver = Hooks.driver;
    P03_Login login = new P03_Login(Hooks.driver);
    P02_HomePage HomePage = new P02_HomePage(Hooks.driver);

    @Given("user clicks on Login tab")
    public void loginTabClick(){
        HomePage.loginButton.click();
    }


    @Then("user should be directed to login page")
    public void isLoginPage() {
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/login?returnUrl=%2F");
    }


    @When("user enter existing email:")
    public void enterEmail() {
        login.emailField.sendKeys(data.F02_Email);
    }

    @And("user enter right password:")
    public void enterPassword() {
        login.passwordField.sendKeys(data.F02_Password);
    }

    @And("user clicks on Login Button")
    public void clickLoginBtn() {
        login.loginButton.click();
    }


    @Then("user should be directed to homepage")
    public void loginSuccessOne() {
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
    }


    @And("user can see logout button")
    public void loginSuccessTwo() {
        Assert.assertTrue(driver.findElement(By.className("ico-logout")).isDisplayed());
    }

    @And("user select Remember me option")
    public void rememberMe() {
        System.out.println(login.rememberMeSelect.isSelected());
        if(!login.rememberMeSelect.isSelected()) {
            login.rememberMeSelect.click();
        }
    }
}
