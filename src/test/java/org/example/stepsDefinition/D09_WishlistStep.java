package org.example.stepsDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class D09_WishlistStep {
    WebDriver driver = Hooks.driver;
    P02_HomePage HomePageRegister = new P02_HomePage(Hooks.driver);
    String itemsNumber;

    @When("user add product to wishlist")
    public void addingToWishlist() throws InterruptedException {
        driver.findElements(HomePageRegister.addToWishListButtons()).get(2).click();
        Thread.sleep(4000);
    }

    @Then("wishlist notification success is visible")
    public void wishlistNotification() {
        Assert.assertTrue(driver.findElement(HomePageRegister.addToWishListSuccesMessage()).isDisplayed());
    }

    @And("user get the number of wishlist items after adding product")
    public void userGetTheNumberOfItems() {
        itemsNumber = driver.findElement(HomePageRegister.wishListItemsNo()).getText();
    }

    @Then("number of wishlist items increased")
    public void wishlistItemsIncreased() {
        itemsNumber = itemsNumber.replaceAll("[^0-9]","");
        Assert.assertTrue(Integer.parseInt(itemsNumber)>0);
    }
}
