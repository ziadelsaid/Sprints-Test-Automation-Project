package org.example.stepsDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class D04_HoverCategoriesStep {
    WebDriver driver = Hooks.driver;
    P02_HomePage HomePageRegister = new P02_HomePage(Hooks.driver);
    String subCategory;

    @When("user hover category and select subcategory")
    public void userHoverCategory() throws InterruptedException {
        Actions action = new Actions(driver);

        WebElement computers = driver.findElement(HomePageRegister.computersCategory());
        action.moveToElement(computers).perform();

        Thread.sleep(1000);

        WebElement desktops = Hooks.driver.findElement(HomePageRegister.desktopsSubCategory());
        subCategory = desktops.getText().toLowerCase().trim();
        desktops.click();
    }

    @Then("the subcategory's results will be shown")
    public void subCategoryResults() {
        Assert.assertEquals(HomePageRegister.titleOfSelectedCategory.getText().toLowerCase(),subCategory);
    }
}

