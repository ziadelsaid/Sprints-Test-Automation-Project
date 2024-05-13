package org.example.stepsDefinition;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_HomePage;
import org.example.pages.P06_AccountManagement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class D08_AccountManagementStep {

    WebDriver driver = Hooks.driver;
    P06_AccountManagement changeInfoPage = new P06_AccountManagement(Hooks.driver);
    P02_HomePage HomePageRegister = new P02_HomePage(Hooks.driver);

    @When("click on my account  icon")
    public void account_info() {

        HomePageRegister.accountinfo.click();
    }
    @When("change first name with {string}")
    public void chang_first_name(String string) {
        changeInfoPage.firstname.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all text
        changeInfoPage.firstname.sendKeys(Keys.DELETE);
        changeInfoPage.firstname.sendKeys(string);

    }

    @When("change last name{string}")
    public void chang_last_name(String string) {

        changeInfoPage.lastname.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all text
        changeInfoPage.lastname.sendKeys(Keys.DELETE);
        changeInfoPage.lastname.sendKeys(string);
    }

    @When("change email")
    public void chang_email() {
        changeInfoPage.email.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all text
        changeInfoPage.email.sendKeys(Keys.DELETE);
        Faker fake = new Faker();
        changeInfoPage.email.sendKeys(fake.internet().safeEmailAddress());
    }

    @When("change company name with {string}")
    public void chang_company_name_with(String string) {
        changeInfoPage.company.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all text
        changeInfoPage.company.sendKeys(Keys.DELETE);
        changeInfoPage.company.sendKeys(string);
    }
    @When("choose newsletter")
    public void chose_news_letter() {
        changeInfoPage.subscription.click();
    }
    @When("do Save")
    public void do_save() {
        changeInfoPage.save.click();
    }
    @Then("the info has been updated")
    public void updated() {
        String expected = changeInfoPage.success.getText();
        String actualtext = "The customer info has been updated successfully.";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(expected,actualtext);
    }
    @When("view order history")
    public void view_history()
    {
        changeInfoPage.order_history.click();

    }

}
