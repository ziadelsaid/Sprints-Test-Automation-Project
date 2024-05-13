package org.example.stepsDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Objects;

public class D05_AddToCartStep {
    WebDriver driver = Hooks.driver;
    P02_HomePage HomePage = new P02_HomePage(Hooks.driver);


    @When("user add item: {string} to cart")
    public void addItemToCart(String itemName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(HomePage.addToCartButton(itemName)));
        HomePage.addToCartButton(itemName).click();

        closeSuccessBar();
    }

    @When("user add item variant: {string} to cart")
    public void addItemVariantToCart(String itemName) throws InterruptedException {
        driver.findElement(By.xpath("//div[text()=\"" + itemName + "\"]/parent::div//button[@id=\"add-to-cart-button-15\"]")).click();

        closeSuccessBar();
    }


    @And("item: {string} is added to cart")
    public void itemIsAddedToCart(String itemName) {
        Actions actions = new Actions(driver);

        WebElement elementToHover = HomePage.topCart;
        actions.moveToElement(elementToHover).perform();

        boolean itemFoundInCart = false;
        for (WebElement i : HomePage.itemsInCart()) {
            if(Objects.equals(i.getText(), itemName)) {
                itemFoundInCart = true;
                break;
            }
        }

        Assert.assertTrue(itemFoundInCart);
    }

    @Given("user navigate camera category")
    public void navigateCategory() {
        HomePage.electronicsCategory.click();
        HomePage.camerasCategory.click();
    }

    @Then("user should be directed to item page")
    public void directedToItemPage() {
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/nikon-d5500-dslr");
    }


    public void closeSuccessBar() throws InterruptedException {
        if(HomePage.successBarClose()!=null) {
            HomePage.successBarClose().click();
            Thread.sleep(1500);
        }
    }

    @And("user add any featured product to cart")
    public void addToCartAndCheck() throws InterruptedException {
        addItemToCart("HTC One M8 Android L 5.0 Lollipop");
        itemIsAddedToCart("HTC One M8 Android L 5.0 Lollipop");
    }

}
