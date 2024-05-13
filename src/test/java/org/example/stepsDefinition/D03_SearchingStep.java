package org.example.stepsDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Data.Data_Drived;
import org.example.pages.P02_HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class D03_SearchingStep {

    Data_Drived data = new Data_Drived();
    WebDriver driver = Hooks.driver;
    P02_HomePage HomePageRegister = new P02_HomePage(Hooks.driver);

    @When("user clicks on search field")
    public void searchFieldClick(){
        HomePageRegister.searchField.click();
    }

    @And("types product name")
    public void typesItemName(){
        HomePageRegister.searchField.sendKeys(data.F03_Item_Type);
    }

    @And("clicks on the search button")
    public void clickSearch(){
        HomePageRegister.searchButton.click();
    }

    @Then("the search results will appear")
    public void searchFeedback(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search"));
        softAssert.assertTrue(!driver.findElements(By.xpath("//div[@class='item-box']")).isEmpty());
        softAssert.assertAll();
    }

    @And("types product SKU")
    public void typesProductSKU() {

        HomePageRegister.searchField.sendKeys(data.F03_search);
    }
}
