package org.example.stepsDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_HomePage;
import org.example.pages.P04_CartManagement;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class D07_CartManagementStep {

    WebDriver driver = Hooks.driver;
    P04_CartManagement cartPage = new P04_CartManagement(Hooks.driver);
    P02_HomePage HomePageRegister = new P02_HomePage(Hooks.driver);

    @When("user click on cart icon in top of page")
    public void go_to_cart() throws InterruptedException {
        HomePageRegister.cart.click();
        Thread.sleep(1000);
    }

    @When("click on increase button")
    public void increase_quantity() {
        cartPage.increase.click();
    }

    @Then("the quantity and price will increase")
    public void increasing_the_quantity_and_price() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        String Price = cartPage.price.getText();




        String Total_Price = cartPage.total_price.getText();

        System.out.println(Price);
        System.out.println(Total_Price);

        softAssert.assertEquals(Price,Total_Price);
    }

    @When("click on decrease button")
    public void decrease_quantity() {
        cartPage.decrease.click();

    }

    @Then("the quantity and price will decrease")
    public void decreasing_the_quantity_and_price() {
        SoftAssert softAssert = new SoftAssert();
        String Price = cartPage.price.getText();


        String Total_Price = cartPage.total_price.getText();


        softAssert.assertEquals(Price,Total_Price);

    }

    @When("click on remove icon")
    public void remove_item() {
        cartPage.remove.click();

    }

    @Then("the cart will Empty")
    public void empty_chart() {

        SoftAssert softAssert = new SoftAssert();

        String Text= "Your Shopping Cart is empty!";
        String expectedText= cartPage.Empty.getText();
        softAssert.assertTrue(expectedText.contains(Text));
    }

}
